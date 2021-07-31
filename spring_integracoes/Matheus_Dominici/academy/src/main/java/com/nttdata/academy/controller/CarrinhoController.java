package com.nttdata.academy.controller;


import com.nttdata.academy.dto.CarrinhoDto;
import com.nttdata.academy.facade.CarrinhoFacade;
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
@RequestMapping("/carrinho")
public class CarrinhoController {
    private static Logger LOG = LogManager.getLogger(CarrinhoController.class);

    @Resource(name = "carrinhoFacade")
    private CarrinhoFacade carrinhoFacade;

    @RequestMapping(value = "adicionar", method = RequestMethod.POST)
    public ResponseEntity adicionarCarrinho(@RequestBody CarrinhoDto carrinho){
        LOG.debug(carrinho.toString());

        carrinho = carrinhoFacade.adicionar(carrinho);

        return ResponseEntity.ok().body(carrinho);
    }

}
