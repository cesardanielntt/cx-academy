package com.nttdata.academy.controller;


import com.nttdata.academy.daos.CarrinhoRepository;
import com.nttdata.academy.daos.PrecoRepository;
import com.nttdata.academy.dto.CarrinhoDTO;
import com.nttdata.academy.dto.PrecoDTO;
import com.nttdata.academy.facade.PrecoFacade;
import com.nttdata.academy.models.CarrinhoModel;
import com.nttdata.academy.models.PrecoModel;
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
@RequestMapping("/preco")
public class PrecoController {

    private static final Logger LOG = LogManager.getLogger(PrecoController.class);

    @PostMapping(produces="application/json")
    public ResponseEntity<PrecoModel> createPreco(@Validated @RequestBody PrecoDTO preco) {
        PrecoModel preco = new PrecoModel();

        var newPrecoDTO = PrecoRepository.save(preco);
        preco.setPrecoDTO(newPrecoDTO);
        preco.setMessage("Successo!");
        return new ResponseEntity<>(preco, HttpStatus.CREATED);
    }



    @PutMapping(path = "/{id}")
    public ResponseEntity<PrecoModel> updatePrecoDTO(@RequestBody PrecoDTO preco, @PathVariable int id) {
        boolean data = PrecoRepository.existsById(id);
        PrecoModel preco = new PrecoModel();
        if(data){
            preco.setId(id);
            PrecoRepository.save(preco);
            preco.setPreco(preco);
            preco.setMessage("Successo");
            return new ResponseEntity<>(preco, HttpStatus.OK);
        }else{
            preco.setMessage("Preço de ID: "+id+" não encontrado.");
            return new ResponseEntity<>(preco, HttpStatus.NO_CONTENT);
        }


        @GetMapping(path = "/{id}")
        public ResponseEntity<PrecoModel> getPrecoById(@PathVariable int id) {
            var preco = PrecoRepository.findById(id);
            PrecoModel preco = new PrecoModel();
            if(preco.isPresent()){
                preco.setPrecoModel(preco.get());
                preco.setMessage("Successo");
                return new ResponseEntity<>(carrinho, HttpStatus.OK);
            }
            preco.setMessage("Preço de ID: \"+id+\" não encontrado.");
            return new ResponseEntity<>(cliente, HttpStatus.NO_CONTENT);
        }


        @DeleteMapping(path = "/{id}")
        public ResponseEntity<PrecoModel> deletePrecoDTO(@PathVariable int id) {
            Optional<PrecoDTO> data = PrecoRepository.findById(id);
            PrecoModel carrinho = new PrecoModel();
            if(data.isPresent()){
                PrecoRepository.delete(data.get());
                preco.setMessage("Preço deletado");
                return new ResponseEntity<>(carrinho, HttpStatus.OK);
            }
            preco.setMessage("Preço de ID: \"+id+\" não encontrado.");
            return new ResponseEntity<>(carrinho, HttpStatus.NO_CONTENT);
        }



    @Resource(name = "precoFacade")
    private PrecoFacade precoFacade;


    @RequestMapping(value = "/adicionar", method = RequestMethod.POST)
    public ResponseEntity adicionarPreco(@RequestBody PrecoDTO preco) {

        LOG.debug(preco.toString());

        precoFacade.adicionar(preco);


        return ResponseEntity.ok().body(preco);
    }
}
