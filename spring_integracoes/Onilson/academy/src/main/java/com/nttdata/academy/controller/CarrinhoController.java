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

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

    private static final Logger LOG = LogManager.getLogger(CarrinhoController.class);

    @Resource(name = "carrinhoFacade")
    private CarrinhoFacade carrinhoFacade;

    @RequestMapping(value = "/adicionar", method = RequestMethod.POST)
    public ResponseEntity adicionarCarrinho(@RequestBody CarrinhoDTO carrinho ) {

        LOG.debug(carrinho.toString());

        carrinho = carrinhoFacade.adicionar(carrinho);

        LOG.debug(carrinho.toString());

        return ResponseEntity.ok().body(carrinho);
    }

}
