package com.nttdata.academy.controller;

import com.nttdata.academy.dto.ClienteDTO;
import com.nttdata.academy.facade.ClienteFacade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private static final Logger LOG = LogManager.getLogger(ClienteController.class);

    @Resource(name = "clienteFacade")
    private ClienteFacade clienteFacade;

    @RequestMapping(value = "/adicionar", method = RequestMethod.POST)
    public ResponseEntity adicionarCliente(@RequestBody ClienteDTO cliente){
        LOG.debug(cliente.toString());
        return clienteFacade.adicionar(cliente);
    }

    @RequestMapping(value = "/atualizar/{id}", method = RequestMethod.POST)
    public void atualizarCliente(@RequestBody ClienteDTO cliente, @PathVariable Integer id){
        LOG.debug(cliente.toString());
        System.out.println("Usuário atualizado!");

        clienteFacade.atualizar(cliente, id);
    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    @ResponseBody
    public List<ClienteDTO> getClientes(){
        List<ClienteDTO> clientes = clienteFacade.listar();

        System.out.println("Clientes: " + clientes);

        return clientes;

    }

    @RequestMapping(value = "/consultar/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ClienteDTO getClienteById(@PathVariable Integer id){
        ClienteDTO cliente = clienteFacade.consultar(id);

        System.out.println("Cliente: " + cliente);

        return cliente;

    }

    @RequestMapping(value = "/deletar/{id}", method = RequestMethod.DELETE)
    public void deletarCliente(@PathVariable Integer id){

        clienteFacade.deletar(id);

        System.out.println("Usuário de ID " + id + " deletado!");
    }
}
