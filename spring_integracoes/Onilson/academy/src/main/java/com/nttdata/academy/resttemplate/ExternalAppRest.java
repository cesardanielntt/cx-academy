package com.nttdata.academy.resttemplate;

import com.nttdata.academy.dto.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class ExternalAppRest {
    
    private static final Logger LOG = LogManager.getLogger(ExternalAppRest.class);
    
    private static final String URL_BASE = "http://localhost:8080";


    public static void main(String[] args) {
        
        ExternalAppRest app = new ExternalAppRest();
        
        app.gravarCliente();
        app.gravarProduto();
        app.gravarPreco();
        app.gravarCarrinho();
        app.gravarItem();
        
    
    
    
    }

    private void gravarItem() {

//        Declarado no carrinho.


    }

    private void gravarCarrinho() {
        LOG.debug("REST Template - Cadastro Carrinho DTO -- START");

        String url = URL_BASE + "/carrinho/adicionar";
        RestTemplate restTemplate = new RestTemplate();
        CarrinhoDTO carrinhoDTO = new CarrinhoDTO();
        Double total = 30.00;

        carrinhoDTO.setTotal(30.00 + "- rest - "+ total);

        carrinhoDTO = restTemplate.postForObject(url, carrinhoDTO, CarrinhoDTO.class);
        LOG.debug(carrinhoDTO);
        LOG.debug("REST Template - Cadastro Carrinho DTO --- END\n\n");

        List<ItemDTO> itensDTO = new ArrayList<>();

        ItemDTO itemDTO = new ItemDTO();
        Integer quantidade = 1;
        itemDTO.setQuantidade(quantidade);
        itemDTO.setTotal(total +" rest " + quantidade);
        itensDTO.add(itemDTO);

        itemDTO.setItens(itensDTO);

        carrinhoDTO = restTemplate.postForObject(url,carrinhoDTO, CarrinhoDTO.class);

        LOG.debug(carrinhoDTO);

        LOG.debug("REST Template - Cadastro Carrinho DTO --- END\n\n");


    }

    private void gravarPreco() {

        LOG.debug("REST Template - Cadastro Preco DTO -- START");

        String url = URL_BASE + "/preco/adicionar";
        RestTemplate restTemplate = new RestTemplate();
        PrecoDTO precoDTO = new PrecoDTO();
        Double valor = 10.00;

        precoDTO.setValor(10.00 + "- rest -" + valor);

        precoDTO = restTemplate.postForObject(url, precoDTO, PrecoDTO.class);
        LOG.debug(precoDTO);
        LOG.debug("REST Template - Cadastro Preco DTO --- END\n\n");

    }

    private void gravarProduto() {

        LOG.debug("REST Template - Cadastro Produto DTO -- START");

        String url = URL_BASE + "/produto/adicionar";
        RestTemplate restTemplate = new RestTemplate();
        ProdutoDTO produtoDTO = new ProdutoDTO();
        String sku = "333";

        produtoDTO.setNome("mochila - rest - "+ sku);
        produtoDTO.setSku("rest - "+ sku);

        produtoDTO = restTemplate.postForObject(url, produtoDTO, ProdutoDTO.class);
        LOG.debug(produtoDTO);
        LOG.debug("REST Template - Cadastro Produto DTO --- END\n\n");
    }

    private void gravarCliente() {

        LOG.debug("REST Template - Cadastro Cliente DTO -- START");

        String url = URL_BASE + "/cliente/adicionar";
        RestTemplate restTemplate = new RestTemplate();
        ClienteDTO clienteDTO = new ClienteDTO();
        String cpf = "12569822265";

        clienteDTO.setNome("João - rest - " + cpf);
        clienteDTO.setCpf("rest-" + cpf);

        List<EnderecoDTO> enderecosDTO = new ArrayList<>();

        EnderecoDTO enderecoDTO = new EnderecoDTO();
        String cep = "74000000";
        enderecoDTO.setCep(cep);
        enderecoDTO.setLogradouro("Rua rest " + cep);
        enderecoDTO.setNumero("Numero rest " + cep);
        enderecoDTO.setBairro("Bairro rest " + cep);
        enderecoDTO.setCidade("Cidade rest " + cep);
        enderecoDTO.setEstado("Estado rest " + cep);
        enderecosDTO.add(enderecoDTO);

        clienteDTO.setEnderecos(enderecosDTO);

        clienteDTO = restTemplate.postForObject(url, clienteDTO, ClienteDTO.class);

        LOG.debug(clienteDTO);

        LOG.debug("REST Template - Cadastro Cliente DTO --- END\n\n");
    }




}
