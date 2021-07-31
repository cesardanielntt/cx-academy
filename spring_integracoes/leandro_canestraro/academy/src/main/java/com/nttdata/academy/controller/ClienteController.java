package com.nttdata.academy.controller;

import com.nttdata.academy.dto.ClienteDTO;
import com.nttdata.academy.facade.ClienteFacade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private static final Logger LOG = LogManager.getLogger(ClienteController.class);

    @Resource(name = "clienteFacade")
    private ClienteFacade clienteFacade;


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity adicionarCliente(@RequestBody ClienteDTO cliente){

//     JSON structure to make a request (values may be changed to make request, these are the ones I used to test)
//        {
//            "cpf": "22ere",
//            "nome": "Mateus",
//            "enderecos": [
//              {
//                  "cep": "463523",
//                  "logradouro": "Rua ghjutyyy",
//                  "numero": "512",
//                  "bairro": "Afonso Pena",
//                  "cidade": "Sao Jose dos Pinhais"
//                  "uf": "pr"
//              }
//            ]
//        }


        LOG.debug(cliente.toString());

        cliente = clienteFacade.adicionar(cliente);

        return ResponseEntity.ok().body(cliente);
    }

    @GetMapping
    public ResponseEntity getClientes() {
        return ResponseEntity.ok().body(clienteFacade.getClientes());
    }
}
