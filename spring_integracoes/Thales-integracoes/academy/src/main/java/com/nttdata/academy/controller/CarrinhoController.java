package com.nttdata.academy.controller;


import com.nttdata.academy.daos.CarrinhoRepository;
import com.nttdata.academy.dto.CarrinhoDTO;
import com.nttdata.academy.facade.CarrinhoFacade;
import com.nttdata.academy.models.CarrinhoModel;
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

@RequestMapping("/carrinho")
@RestController
public class CarrinhoController {

    private static final Logger LOG = LogManager.getLogger(ClienteController.class);

    @PostMapping(produces="application/json")
    public ResponseEntity<CarrinhoModel> createCarrinho(@Validated @RequestBody CarrinhoDTO carrinho) {
        CarrinhoModel carrinho = new CarrinhoModel();

                var newCarrinhoDTO = CarrinhoRepository.save(cliente);
                carrinho.setCarrinhoDTO(newCarrinhoDTO);
                carrinho.setMessage("Successo!");
                return new ResponseEntity<>(carrinho, HttpStatus.CREATED);
            }



            @PutMapping(path = "/{id}")
            public ResponseEntity<CarrinhoModel> updateCarrinhoDTO(@RequestBody CarrinhoDTO carrinho, @PathVariable int id) {
                boolean data = CarrinhoRepository.existsById(id);
                CarrinhoModel carrinho = new CarrinhoModel();
                if(data){
                    carrinho.setId(id);
                    CarrinhoRepository.save(carrinho);
                    carrinho.setCliente(carrinho);
                    carrinho.setMessage("Successo");
                    return new ResponseEntity<>(carrinho, HttpStatus.OK);
                }else{
                    carrinho.setMessage("Carrinho de ID: "+id+" não encontrado.");
                    return new ResponseEntity<>(carrinho, HttpStatus.NO_CONTENT);
                }


                @GetMapping(path = "/{id}")
                public ResponseEntity<CarrinhoModel> getCarrinhoById(@PathVariable int id) {
                    var carrinho = CarrinhoRepository.findById(id);
                    CarrinhoModel cliente = new CarrinhoModel();
                    if(carrinho.isPresent()){
                        carrinho.setCarrinhoModel(carrinho.get());
                        carrinho.setMessage("Successo");
                        return new ResponseEntity<>(carrinho, HttpStatus.OK);
                    }
                    carrinho.setMessage("Carrinho de ID: \"+id+\" não encontrado.");
                    return new ResponseEntity<>(cliente, HttpStatus.NO_CONTENT);
                }


                @DeleteMapping(path = "/{id}")
                public ResponseEntity<CarrinhoModel> deleteCarrinhoDTO(@PathVariable int id) {
                    Optional<CarrinhoDTO> data = CarrinhoRepository.findById(id);
                    CarrinhoModel carrinho = new CarrinhoModel();
                    if(data.isPresent()){
                        CarrinhoRepository.delete(data.get());
                        carrinho.setMessage("Carrinho deletado");
                        return new ResponseEntity<>(carrinho, HttpStatus.OK);
                    }
                    carrinho.setMessage("Carrinho de ID: \"+id+\" não encontrado.");
                    return new ResponseEntity<>(carrinho, HttpStatus.NO_CONTENT);
                }
    @Resource(name ="carrinhoFacade")
    private CarrinhoFacade carrinhoFacade;

    @RequestMapping(value = "/adicionar", method = RequestMethod.POST)
    public ResponseEntity adicionarCarrinho(@RequestBody CarrinhoDTO carrinho){

        LOG.debug(carrinho.toString());

        carrinhoFacade.adicionar(carrinho);

        return ResponseEntity.ok().body(carrinho);

    }
}
