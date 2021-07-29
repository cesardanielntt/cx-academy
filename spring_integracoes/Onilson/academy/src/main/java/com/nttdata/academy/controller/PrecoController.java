package com.nttdata.academy.controller;

import com.nttdata.academy.dto.PrecoDTO;
import com.nttdata.academy.facade.PrecoFacade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/preco")
public class PrecoController {

    private static final Logger LOG = LogManager.getLogger(PrecoController.class);

    @Resource(name = "precoFacade")
    private PrecoFacade precoFacade;

    @RequestMapping(value = "/adicionar", method = RequestMethod.POST)
    public ResponseEntity adicionarPreco(@RequestBody PrecoDTO preco) {

        LOG.debug(preco.toString());

        precoFacade.adicionar(preco);

        return ResponseEntity.ok().body(preco);


    }

}
