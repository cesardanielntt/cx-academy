package com.nttdata.academy.controller;


import com.nttdata.academy.dto.ProdutoDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private static final Logger LOG = LogManager.getLogger(ProdutoController.class);

    @RequestMapping(value = "/adicionar", method = RequestMethod.POST)
    public ResponseEntity adcionarProduto(@RequestBody ProdutoDTO produto) {

        LOG.debug(produto.toString());

        return ResponseEntity.ok().body(produto);
    }



}
