package com.nttdata.academy.controller;

import com.nttdata.academy.dto.ClienteDTO;
import com.nttdata.academy.facade.ClienteFacade;
import com.nttdata.academy.models.ClienteModels;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private static final Logger LOG = LogManager.getLogger(ClienteController.class);

    @Resource(name = "clienteFacade")
    private ClienteFacade clienteFacade;

    @RequestMapping(value = "/adicionar", method = RequestMethod.POST)
    public ResponseEntity adicionarCliente(@RequestBody ClienteDTO cliente){
        LOG.debug(cliente.toString());

        clienteFacade.adicionar(cliente);

        return clienteFacade.adicionar(cliente);
    }

    @DeleteMapping (path = "/{id}")
    public ResponseEntity<ClienteModels> deletarCliente(@PathVariable Integer id){

        return clienteFacade.deletar(id);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<ClienteModels>> receberCliente(@PathVariable Integer id){

        return clienteFacade.listar(id);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity <ClienteDTO> atualizarCliente(@RequestBody ClienteDTO cliente, @PathVariable Integer id){

        return clienteFacade.atualizar(cliente, id);
    }
}