package com.nttdata.academy.controller;

import com.nttdata.academy.dto.ClienteDTO;
import com.nttdata.academy.facade.ClienteFacade;
import com.nttdata.academy.models.ClienteModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private static final Logger LOG = LogManager.getLogger(ClienteController.class);

    @Resource(name = "clienteFacade")
    private ClienteFacade clienteFacade;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<ClienteModel>> receberClientePeloId(@PathVariable Integer id) {
        return clienteFacade.listar(id);

    }

    @RequestMapping(value = "/adicionar", method = RequestMethod.POST)
    public ResponseEntity adicionarCliente(@RequestBody ClienteDTO cliente){
        LOG.debug(cliente.toString());
        return clienteFacade.adicionar(cliente);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ClienteDTO> atualizarCliente(@RequestBody ClienteDTO cliente, @PathVariable Integer id) {
            return clienteFacade.atualizar(cliente, id);

    }
}
