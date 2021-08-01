package com.nttdata.academy.resttemplate;

import com.nttdata.academy.dto.ClienteDTO;
import com.nttdata.academy.dto.EnderecoDTO;
import com.nttdata.academy.dto.ProdutoDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Essa Classe é uma simulação de uma outra aplicação que irá consumir um sistema REST
 * <p>
 * Essa classe irá consumir API dos correios para validar o CEP e popular outras informações do endereço
 */
public class ExternalAppRest {

    private static final Logger LOG = LogManager.getLogger(ExternalAppRest.class);

    private static final String URL_BASE = "http://localhost:8080";

    public static void main(String[] args) {

        ExternalAppRest app = new ExternalAppRest();

        // cadastrar cliente
        app.gravarCliente();

        // cadastrar produto
        //app.gravarProduto();

        // cadastrar preco
        //app.gravarPreco();

        // criar carrinho
        //app.gravarCarrinho();

        // criar item
        //app.gravarItem();

    }

    private void gravarCliente() {

        LOG.debug("REST Template - Cadastro Cliente DTO --- START");

        String url = URL_BASE + "/cliente/adicionar";
        RestTemplate restTemplate = new RestTemplate();

        ClienteDTO clienteDTO = new ClienteDTO();

        String cpf = "22222222222";

        clienteDTO.setNome("João - rest - " + cpf);
        clienteDTO.setCpf("rest-" + cpf);

        List<EnderecoDTO> enderecosDTO = new ArrayList<>();

        EnderecoDTO enderecoDTO = new EnderecoDTO();
        String cep = "81580010";
        enderecoDTO.setCep(cep);
        enderecoDTO.setLogradouro("Rua rest " + cep);
        enderecoDTO.setNumero("Numero rest " + cep);
        enderecoDTO.setBairro("Bairro rest " + cep);
        enderecoDTO.setCidade("Cidade rest " + cep);
        enderecoDTO.setUf("UF rest " + cep);
        enderecosDTO.add(enderecoDTO);

        clienteDTO.setEnderecos(enderecosDTO);

        clienteDTO = restTemplate.postForObject(url, clienteDTO, ClienteDTO.class);

        LOG.debug(clienteDTO);

        LOG.debug("REST Template - Cadastro Cliente DTO --- END\n\n");

    }

    private void gravarProduto() {

        LOG.debug("REST Template - Cadastro Produto DTO --- START");

        String url = URL_BASE + "/produto/addOrUpdate";
        RestTemplate restTemplate = new RestTemplate();

        ProdutoDTO produtoDTO = new ProdutoDTO();

        String sku = "333";

        //produtoDTO.setNome("Produto Rest " + sku);
        //produtoDTO.setSku("rest-" + sku);

        produtoDTO = restTemplate.postForObject(url, produtoDTO, ProdutoDTO.class);

        LOG.debug(produtoDTO);

        LOG.debug("REST Template - Cadastro Produto DTO --- END\n\n");

    }


    private void gravarPreco() {

        RestTemplate restTemplate = new RestTemplate();

        // TODO desenvolver gravacao do preco

    }

    private void gravarCarrinho() {

        RestTemplate restTemplate = new RestTemplate();

        // TODO desenvolver gravacao do carrinho

    }

    private void gravarItem() {

        RestTemplate restTemplate = new RestTemplate();

        // TODO desenvolver gravacao do carrinho

    }

}