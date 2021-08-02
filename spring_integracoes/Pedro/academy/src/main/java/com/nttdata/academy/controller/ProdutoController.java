package com.nttdata.academy.controller;

import com.nttdata.academy.dto.ProdutoDTO;
import com.nttdata.academy.facade.ProdutoFacade;
import org.springframework.http.ResponseEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private static final Logger LOG = LogManager.getLogger(ProdutoController.class);

    @Resource(name = "produtoFacade")
    private ProdutoFacade produtoFacade;

    @RequestMapping(value = "/adicionar", method = RequestMethod.POST)
    public ResponseEntity adicionarProduto(@RequestBody ProdutoDTO produto){

        LOG.debug(produto.toString());
        return produtoFacade.adicionar(produto);

    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    @ResponseBody
    public List<ProdutoDTO> getProdutosById(){
        List<ProdutoDTO> produtos = produtoFacade.listar();

        System.out.println("Produtos: " + produtos);

        return produtos;

    }

    @RequestMapping(value = "/consultar/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ProdutoDTO getProdutosById(@PathVariable Integer id){
        ProdutoDTO produto = produtoFacade.consultar(id);

        System.out.println("Produtos: " + produto);

        return produto;

    }

    @RequestMapping(value = "/atualizar/{id}", method = RequestMethod.POST)
    public void atualizarProduto(@RequestBody ProdutoDTO produto, @PathVariable Integer id){

        LOG.debug(produto.toString());

        produtoFacade.atualizar(produto, id);

        LOG.debug("Produto " + id + " atualizado!");

    }

    @RequestMapping(value = "/deletar/{id}", method = RequestMethod.DELETE)
    public void deletarProduto(@PathVariable Integer id){

        produtoFacade.deletar(id);

        System.out.println("Produto de ID " + id + " deletado!");
    }
}
