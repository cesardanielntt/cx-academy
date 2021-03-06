package com.nttdata.academy.controller;


import com.nttdata.academy.dto.ProdutoDTO;

import com.nttdata.academy.facade.ProdutoFacade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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

}