package com.nttdata.academy.controller;


import com.nttdata.academy.dto.CarrinhoDTO;
import com.nttdata.academy.facade.CarrinhoFacade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("/carrinho")
@RestController
public class CarrinhoController {

    private static final Logger LOG = LogManager.getLogger(ClienteController.class);

    @Resource(name ="carrinhoFacade")
    private CarrinhoFacade carrinhoFacade;

    @RequestMapping(value = "/adicionar", method = RequestMethod.POST)
    public ResponseEntity adicionarCarrinho(@RequestBody CarrinhoDTO carrinho){

        LOG.debug(carrinho.toString());

        carrinhoFacade.adicionar(carrinho);

        return ResponseEntity.ok().body(carrinho);

    }
}
