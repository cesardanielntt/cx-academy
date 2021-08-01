package com.nttdata.academy.resttemplate;

import com.nttdata.academy.dto.CarrinhoDTO;
import com.nttdata.academy.dto.ClienteDTO;
import com.nttdata.academy.dto.EnderecoDTO;
import com.nttdata.academy.dto.ItemDTO;
import com.nttdata.academy.dto.PrecoDTO;
import com.nttdata.academy.dto.ProdutoDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


public class ExternalAppRest {

    private static final Logger LOG = LogManager.getLogger(ExternalAppRest.class);

    private static final String URL_BASE = "http://localhost:8080";
    private Object PrecoDTO;


    public static void main(String[] args) {

        ExternalAppRest app = new ExternalAppRest();

        // cadastrar cliente
        app.gravarCliente();

        // cadastrar produto
        app.gravarProduto();

        // cadastrar preco
        app.gravarPreco();

        // criar carrinho
        app.gravarCarrinho();


    }

    private void gravarCliente() {

        LOG.debug("REST Template - Cadastro Cliente DTO --- START");

        String url = URL_BASE + "/cliente/adicionar";
        RestTemplate restTemplate = new RestTemplate();

        ClienteDTO clienteDTO = new ClienteDTO();

        String cpf = "11256895840";

        clienteDTO.setNome("Khaue - rest - " + cpf);
        clienteDTO.setCpf("rest-" + cpf);

        List<EnderecoDTO> enderecosDTO = new ArrayList<>();

        EnderecoDTO enderecoDTO = new EnderecoDTO();
        String cep = "89924030";
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

        LOG.debug("REST Template - Gravar Produto DTO --- START");

        String url = URL_BASE + "/produto/adicionar";
        RestTemplate restTemplate = new RestTemplate();

        ProdutoDTO produtoDTO = new ProdutoDTO();

        String sku = "555";

        produtoDTO.setNome("Cafeteira Rest " + sku);
        produtoDTO.setSku("rest-" + sku);

        produtoDTO = restTemplate.postForObject(url, produtoDTO, ProdutoDTO.class);

        LOG.debug(produtoDTO);

        LOG.debug("REST Template - Gravar Produto DTO --- END\n\n");

    }


    private void gravarPreco() {

        LOG.debug("REST Template - Gravar Preco DTO --- START");

        String url = URL_BASE + "/preco/adicionar";
        RestTemplate restTemplate = new RestTemplate();

        PrecoDTO precoDTO = new PrecoDTO();

        Double valor = 150.0;


        precoDTO.setValor("Cafeteira Rest " + valor);


        PrecoDTO = restTemplate.postForObject(url, precoDTO, ProdutoDTO.class);

        LOG.debug(precoDTO);

        LOG.debug("REST Template - Gravar Preco DTO --- END\n\n");

    }

    private void gravarCarrinho() {
        LOG.debug("REST Template - Gravar Carrinho DTO -- START");

        String url = URL_BASE + "/carrinho/adicionar";
        RestTemplate restTemplate = new RestTemplate();

        CarrinhoDTO carrinhoDTO = new CarrinhoDTO();

        Double total = 150.00;

        carrinhoDTO.setTotal(150.00 + "- rest - "+ total);

        carrinhoDTO = restTemplate.postForObject(url, carrinhoDTO, CarrinhoDTO.class);

        LOG.debug(carrinhoDTO);

        LOG.debug("REST Template - Gravar Carrinho DTO --- END\n\n");

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
}
