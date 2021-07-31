package com.nttdata.academy.resttemplate;

import com.nttdata.academy.dto.*;
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

        ProdutoDto produtoDTO = new ProdutoDto();

        String sku = "333";

        //produtoDTO.setNome("Produto Rest " + sku);
        //produtoDTO.setSku("rest-" + sku);

        produtoDTO = restTemplate.postForObject(url, produtoDTO, ProdutoDto.class);

        LOG.debug(produtoDTO);

        LOG.debug("REST Template - Cadastro Produto DTO --- END\n\n");

    }


    private void gravarPreco() {

        LOG.debug("REST Template - Cadastro Produto DTO --- START");

        String url = URL_BASE + "/produto/addOrUpdate";
        RestTemplate restTemplate = new RestTemplate();

        PrecoDto precoDto = new PrecoDto();


        //precoDto.setValor("Valor é: " + precoDto.getValor());

        precoDto = restTemplate.postForObject(url, precoDto, PrecoDto.class);

        LOG.debug(precoDto);

        LOG.debug("REST Template - Definir Preco DTO --- END\n\n");

    }

    private void gravarCarrinho() {

        LOG.debug("REST Template - Cadastro Produto DTO --- START");

        String url = URL_BASE + "/produto/addOrUpdate";
        RestTemplate restTemplate = new RestTemplate();

        CarrinhoDto carrinhoDto = new CarrinhoDto();


        //setcarrinho

        carrinhoDto = restTemplate.postForObject(url, carrinhoDto, CarrinhoDto.class);

        LOG.debug(carrinhoDto);

        LOG.debug("REST Template - Definir Preco DTO --- END\n\n");

    }

    private void gravarItem() {

        LOG.debug("REST Template - Cadastro Produto DTO --- START");

        String url = URL_BASE + "/produto/addOrUpdate";
        RestTemplate restTemplate = new RestTemplate();

        PrecoDto precoDto = new PrecoDto();


        //ItemDto.setValor("Valor é: " + precoDto.getValor());

        precoDto = restTemplate.postForObject(url, precoDto, PrecoDto.class);

        LOG.debug(precoDto);

        LOG.debug("REST Template - Definir Preco DTO --- END\n\n");

    }

}
