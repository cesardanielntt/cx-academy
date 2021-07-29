package com.nttdata.academy.controller;

import com.nttdata.academy.daos.ClienteRepository;
import com.nttdata.academy.dto.ClienteDTO;
import com.nttdata.academy.facade.ClienteFacade;
import com.nttdata.academy.models.ClienteModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping(produces="application/json")
    public ResponseEntity<ClienteModel> createCliente(@Validated @RequestBody ClienteDTO cliente) {
        Optional<ClienteDTO> cpf = ClienteRepository.findClientByCpf(cliente.getCpf());
        ClienteModel cliente = new ClienteModel();
        if(cpf.isPresent() ){
            if (cpf.isPresent() ) {
                cliente.setMessage("CPF é obrigatório e precisa ser único!");


            return new ResponseEntity<>(cliente, HttpStatus.BAD_REQUEST);
        }
        else{
            var newClienteDTO = ClienteRepository.save(cliente);
            cliente.setClienteDTO(newClienteDTO);
            cliente.setMessage("Successo!");
            return new ResponseEntity<>(cliente, HttpStatus.CREATED);
        }



            @PutMapping(path = "/{id}")
            public ResponseEntity<ClienteModel> updateClienteDTO(@RequestBody ClienteDTO cliente, @PathVariable int id) {
                boolean data = ClienteRepository.existsById(id);
                ClienteModel cliente = new ClienteModel();
                if(data){
                    cliente.setId(id);
                    ClienteRepository.save(cliente);
                    cliente.setCliente(cliente);
                    cliente.setMessage("Successo");
                    return new ResponseEntity<>(cliente, HttpStatus.OK);
                }else{
                    cliente.setMessage("Cliente de ID: "+id+" não encontrado.");
                    return new ResponseEntity<>(cliente, HttpStatus.NO_CONTENT);
                }


                @GetMapping(path = "/{id}")
                public ResponseEntity<ClienteModel> getClienteById(@PathVariable int id) {
                    var cliente = ClienteRepository.findById(id);
                    ClienteModel cliente = new ClienteModel();
                    if(cliente.isPresent()){
                        cliente.setClienteModel(cliente.get());
                        cliente.setMessage("Successo");
                        return new ResponseEntity<>(cliente, HttpStatus.OK);
                    }
                    cliente.setMessage("Cliente de ID: \"+id+\" não encontrado.");
                    return new ResponseEntity<>(cliente, HttpStatus.NO_CONTENT);
                }


                @DeleteMapping(path = "/{id}")
                public ResponseEntity<ClienteModel> deleteClienteDTO(@PathVariable int id) {
                    Optional<ClienteDTO> data = ClienteRepository.findById(id);
                    ClienteModel cliente = new ClienteModel();
                    if(data.isPresent()){
                        ClienteRepository.delete(data.get());
                        cliente.setMessage("Client deleted");
                        return new ResponseEntity<>(cliente, HttpStatus.OK);
                    }
                    cliente.setMessage("Cliente de ID: \"+id+\" não encontrado.");
                    return new ResponseEntity<>(cliente, HttpStatus.NO_CONTENT);
                }



    @Resource(name="clienteFacade")
    private ClienteFacade clienteFacade;


    @RequestMapping(value = "/adicionar", method = RequestMethod.POST)
    public ResponseEntity adicionarCliente(@RequestBody ClienteDTO cliente){

        LOG.debug(cliente.toString());

        cliente =clienteFacade.adicionar(cliente);

        LOG.debug(cliente.toString());

        return ResponseEntity.ok().body(cliente);

    }


}
