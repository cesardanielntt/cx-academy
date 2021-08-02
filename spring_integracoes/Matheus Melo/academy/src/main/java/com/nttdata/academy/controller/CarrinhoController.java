package com.nttdata.academy.controller;

import com.nttdata.academy.dto.CarrinhoDTO;
import com.nttdata.academy.facade.CarrinhoFacade;
import com.nttdata.academy.models.CarrinhoModels;
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
@RequestMapping("/carrinho")
public class CarrinhoController {
    private static final Logger LOG = LogManager.getLogger(CarrinhoController.class);

    @Resource(name = "carrinhoFacade")
    private CarrinhoFacade carrinhoFacade;

    @RequestMapping(value = "/adicionar", method = RequestMethod.POST)
    public ResponseEntity adicionarCarrinho(@RequestBody CarrinhoDTO carrinho){

        LOG.debug(carrinho.toString());

        carrinhoFacade.adicionar(carrinho);

        return ResponseEntity.ok().body(carrinho);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<CarrinhoModels>> receberCarrinho(@PathVariable Integer id){
        return carrinhoFacade.listar(id);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<CarrinhoDTO> atualizarCarrinho(@RequestBody CarrinhoDTO carrinho, @PathVariable Integer id){
        return carrinhoFacade.atualizar(carrinho, id);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<CarrinhoModels> deletarCarrinho(@PathVariable Integer id){
        return carrinhoFacade.deletar(id);
    }

}
