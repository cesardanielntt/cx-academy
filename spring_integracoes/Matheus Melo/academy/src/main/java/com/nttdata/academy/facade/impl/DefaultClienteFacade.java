package com.nttdata.academy.facade.impl;

import com.nttdata.academy.dto.ClienteDTO;
import com.nttdata.academy.dto.EnderecoDTO;
import com.nttdata.academy.dto.ViaCepDTO;
import com.nttdata.academy.facade.ClienteFacade;
import com.nttdata.academy.models.ClienteModels;
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

import java.util.List;
import java.util.Optional;

@Service("clienteFacade")
public class DefaultClienteFacade implements ClienteFacade {

    private static final Logger LOG = LogManager.getLogger(DefaultClienteFacade.class);

    @Autowired
    private ClientePopulator clientePopulator;

    @Autowired
    private ClienteService clienteService;

    @Override
    public ResponseEntity adicionar(ClienteDTO clienteDTO) {

        if(!validaEnderecoEPreencheDados(clienteDTO.getEnderecos())){
            return messageEnderecoInvalido(clienteDTO);
        }

        ClienteModels cliente = clientePopulator.populateClienteModel(clienteDTO);

        cliente = clienteService.adicionar(cliente);

        clienteDTO = clientePopulator.populateClienteDTO(cliente);

        LOG.debug(clienteDTO);

        return ResponseEntity.ok().body(clienteDTO);

    }

    @Override
    public ResponseEntity<ClienteDTO> atualizar(ClienteDTO clienteDTO, Integer id) {
        if (!validaEnderecoEPreencheDados(clienteDTO.getEnderecos())){
            return messageEnderecoInvalido(clienteDTO);
        }
        Optional<ClienteModels> clienteData;
        clienteData = clienteService.listar(id);

        if (clienteData.isEmpty()){
            return messageFalha();
        }
        ClienteModels cliente = clientePopulator.populateClienteModel(clienteDTO);
        cliente=clienteService.atualizar(cliente, id);
        clienteDTO=clientePopulator.populateClienteDTO(cliente);
        return ResponseEntity.ok().body(clienteDTO);
    }

    @Override
    public ResponseEntity<Optional<ClienteModels>> listar(Integer id) {
        Optional<ClienteModels> cliente = clienteService.listar(id);

        if (cliente.isEmpty()){
            return messageFalha();
        }

        return ResponseEntity.ok().body(cliente);
    }

    @Override
    public ResponseEntity<ClienteModels> deletar(Integer id) {
        Optional<ClienteModels> clienteData = clienteService.listar(id);

        if (clienteData.isEmpty()){
            return messageFalha();
        } else {
            clienteService.deletar(id);
            return messageSucesso();
        }
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
            // cep inv??lido ou API fora do ar
        }

        LOG.debug("");
        LOG.debug("URL: " + url);
        LOG.debug(cep);

        if( cep == null || Boolean.TRUE.equals(cep.getErro()) ){
            LOG.debug("inv??lido");
            enderecoDTO.setStatus(404);
            enderecoDTO.setMessage("CEP inv??lido !");
        } else {
            LOG.debug("v??lido");
            enderecoDTO.setStatus(200);
            enderecoDTO.setMessage("CEP v??lido !");
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
        clienteDTO.setMessage("Nenhum cliente cadastrado, h?? endere??os inv??lidos !");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(clienteDTO);
    }

    private ResponseEntity messageSucesso() {
        return ResponseEntity.ok().body(new ClienteDTO("Cliente removido com sucesso!", 200));
    }

    private ResponseEntity messageFalha() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ClienteDTO("Cliente n??o encontrado !", 404));
    }

    private ResponseEntity messageEnderecoSucesso() {
        return ResponseEntity.ok().body(new ClienteDTO("Endere??o removido com sucesso!", 200));
    }

    private ResponseEntity messageEnderecoFalha() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ClienteDTO("Endere??o n??o encontrado !", 404));
    }

}