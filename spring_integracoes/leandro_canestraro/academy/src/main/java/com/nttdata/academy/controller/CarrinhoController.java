package com.nttdata.academy.controller;


import com.nttdata.academy.dto.CarrinhoDTO;
import com.nttdata.academy.dto.PrecoDTO;
import com.nttdata.academy.facade.CarrinhoFacade;
import com.nttdata.academy.facade.PrecoFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {


    @Resource(name = "carrinhoFacade")
    private CarrinhoFacade carrinhoFacade;


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity adicionarAoCarrinho(@RequestBody CarrinhoDTO carrinho){


//        LOG.debug(cliente.toString());

        carrinho = carrinhoFacade.adicionar(carrinho);

        return ResponseEntity.ok().body(carrinho);
    }

}
