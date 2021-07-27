package com.nttdata.academy.controller;

import com.nttdata.academy.dto.ClienteDto;
import com.nttdata.academy.facade.ClienteFacade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/cliente")

public class ClienteController {

    private static Logger LOG = LogManager.getLogger(ClienteController.class);

    @Resource(name = "clienteFacade")
    private ClienteFacade clienteFacade;

    @RequestMapping(value = "adicionar", method = RequestMethod.POST)
    public ResponseEntity adicionarCliente(@RequestBody ClienteDto cliente){

        LOG.debug(cliente.toString());

        clienteFacade.adicionar(cliente);

        return ResponseEntity.ok().body(cliente);
    }
}
