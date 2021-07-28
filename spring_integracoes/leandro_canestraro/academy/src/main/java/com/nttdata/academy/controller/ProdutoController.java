package com.nttdata.academy.controller;


import com.nttdata.academy.dto.ClienteDataDTO;
import com.nttdata.academy.dto.ProdutoDTO;
import com.nttdata.academy.facade.ClienteFacade;
import com.nttdata.academy.facade.ProdutoFacade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.xml.ws.Response;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private static final Logger LOG = LogManager.getLogger(ProdutoController.class);

    @Resource(name = "produtoFacade")
    private ProdutoFacade produtoFacade;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity adicionarProduto(@RequestBody ProdutoDTO produto){


        LOG.debug(produto.toString());

        produtoFacade.adicionar(produto);

        return ResponseEntity.ok().body(produto);
    }

}
