package com.nttdata.academy.controller;

import com.nttdata.academy.dto.ClienteDataDTO;
import com.nttdata.academy.facade.ClienteFacade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private static final Logger LOG = LogManager.getLogger(ClienteController.class);

    @Resource(name = "clienteFacade")
    private ClienteFacade clienteFacade;


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity adicionarCliente(@RequestBody ClienteDataDTO cliente){


        LOG.debug(cliente.toString());

        cliente = clienteFacade.adicionar(cliente);

        return ResponseEntity.ok().body(cliente);
    }
}
