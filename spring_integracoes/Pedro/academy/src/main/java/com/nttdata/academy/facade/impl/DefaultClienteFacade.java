package com.nttdata.academy.facade.impl;

import com.nttdata.academy.dto.ClienteDTO;
import com.nttdata.academy.dto.EnderecoDTO;
import com.nttdata.academy.dto.ViaCepDTO;
import com.nttdata.academy.facade.ClienteFacade;
import com.nttdata.academy.models.ClienteModel;
import com.nttdata.academy.models.EnderecoModel;
import com.nttdata.academy.populators.ClientePopulator;
import com.nttdata.academy.service.ClienteService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("clienteFacade")
public class DefaultClienteFacade implements ClienteFacade {

    private static final Logger LOG = LogManager.getLogger(DefaultClienteFacade.class);

    @Autowired
    private ClientePopulator clientePopulator;

    @Autowired
    private ClienteService clienteService;

    @Override
    public ResponseEntity adicionar(ClienteDTO clienteDTO) {

        LOG.debug(clienteDTO);

        if(!validaEnderecoEPreencheDados(clienteDTO.getEnderecos())){
            return messageEnderecoInvalido(clienteDTO);
        }

        ClienteModel cliente = clientePopulator.populateClienteModel(clienteDTO);

        cliente = clienteService.adicionar(cliente);

        clienteDTO = clientePopulator.populateClienteDto(cliente);

        LOG.debug(clienteDTO);

        return ResponseEntity.ok().body(clienteDTO);

    }

    @Override
    public void atualizar(ClienteDTO clienteDTO, Integer id) {

        LOG.debug(clienteDTO);

        if(!validaEnderecoEPreencheDados(clienteDTO.getEnderecos())){
            LOG.debug("Endereço inválido!");
        }

        ClienteModel clienteModel = clientePopulator.populateClienteModel(clienteDTO);

        clienteService.atualizar(clienteModel, id);

    }

    @Override
    public List<ClienteDTO> listar(){

        List<ClienteModel> clienteModels = clienteService.listar(); // returns List<ClienteModel>

        List<ClienteDTO> clientesDTO = new ArrayList<>();

        for(ClienteModel cliente: clienteModels){
            clientesDTO.add(clientePopulator.populateClienteDto(cliente));
        }

        return clientesDTO;
    }

    public ClienteDTO consultar(Integer id){
        List<ClienteModel> clienteModels = clienteService.consultar(id); // returns List<ClienteModel>

        List<ClienteDTO> clientesDTO = new ArrayList<>();

        for(ClienteModel cliente: clienteModels){
            clientesDTO.add(clientePopulator.populateClienteDto(cliente));
        }

        ClienteDTO cliente = new ClienteDTO();

        if(clientesDTO.size() > 0 ) cliente = clientesDTO.get(0);

        return cliente;
    }

    @Override
    public void deletar(Integer id){

        clienteService.deletar(id);

    }

    private boolean validaEnderecoEPreencheDados(List<EnderecoDTO> enderecos) {

        if(enderecos == null)
            return true;

        enderecos.forEach(e -> verifyEnderecoValidoAndPreenhchaDados(e));
        LOG.debug("");
        LOG.debug("Lista de endereco");
        LOG.debug(enderecos);

        boolean isNotValid = enderecos.stream().anyMatch(e -> (e.getStatus() == 404));
        LOG.debug("");
        LOG.debug("isNotValid ?");
        LOG.debug(isNotValid);

        return !isNotValid;
    }

    private void verifyEnderecoValidoAndPreenhchaDados(EnderecoDTO enderecoDTO) {

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://viacep.com.br/ws/"+ enderecoDTO.getCep()+"/json";

        ViaCepDTO cep = null;

        try {
            cep = restTemplate.getForObject(url, ViaCepDTO.class);
        } catch (HttpClientErrorException e){
            // cep inválido ou API fora do ar
        }

        LOG.debug("");
        LOG.debug("URL: " + url);
        LOG.debug(cep);

        if( cep == null || Boolean.TRUE.equals(cep.getErro()) ){
            LOG.debug("inválido");
            enderecoDTO.setStatus(404);
            enderecoDTO.setMessage("CEP inválido !");
        } else {
            LOG.debug("válido");
            enderecoDTO.setStatus(200);
            enderecoDTO.setMessage("CEP válido !");
            enderecoDTO.setLogradouro(cep.getLogradouro());
            enderecoDTO.setBairro(cep.getBairro());
            enderecoDTO.setCidade(cep.getLocalidade());
            enderecoDTO.setUf(cep.getUf());
        }

        LOG.debug("");
        LOG.debug("endereco");
        LOG.debug(enderecoDTO);

    }

    private ResponseEntity messageEnderecoInvalido(ClienteDTO clienteDTO) {
        clienteDTO.setStatus(404);
        clienteDTO.setMessage("Nenhum cliente cadastrado, há endereços inválidos !");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(clienteDTO);
    }

    private ResponseEntity messageSucesso() {
        return ResponseEntity.ok().body(new ClienteDTO("Cliente removido com sucesso!", 200));
    }

    private ResponseEntity messageFalha() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ClienteDTO("Cliente não encontrado !", 404));
    }

    private ResponseEntity messageEnderecoSucesso() {
        return ResponseEntity.ok().body(new ClienteDTO("Endereço removido com sucesso!", 200));
    }

    private ResponseEntity messageEnderecoFalha() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ClienteDTO("Endereço não encontrado !", 404));
    }

}