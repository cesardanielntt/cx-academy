package com.nttdata.academy.facade.impl;

import com.nttdata.academy.dto.CarrinhoDTO;
import com.nttdata.academy.dto.EnderecoDTO;
import com.nttdata.academy.dto.ViaCepDTO;
import com.nttdata.academy.facade.CarrinhoFacade;
import com.nttdata.academy.models.CarrinhoModel;
import com.nttdata.academy.populators.CarrinhoPopulator;
import com.nttdata.academy.service.CarrinhoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service("CarrinhoFacade")
public class DefaultCarrinhoFacade implements CarrinhoFacade {

    private static final Logger LOG = LogManager.getLogger(DefaultCarrinhoFacade.class);

    @Autowired
    private CarrinhoPopulator CarrinhoPopulator;

    @Autowired
    private CarrinhoService CarrinhoService;

    @Override
    public ResponseEntity adicionar(CarrinhoDTO CarrinhoDTO) {

        LOG.debug(CarrinhoDTO);

        CarrinhoModel Carrinho = CarrinhoPopulator.populateCarrinhoModel(CarrinhoDTO);

        Carrinho = CarrinhoService.adicionar(Carrinho);

        CarrinhoDTO = CarrinhoPopulator.populateCarrinhoDto(Carrinho);

        LOG.debug(CarrinhoDTO);

        return ResponseEntity.ok().body(CarrinhoDTO);

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

}