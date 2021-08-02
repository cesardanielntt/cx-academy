package com.nttdata.academy.controller;

import com.nttdata.academy.dto.ClienteDTO;
import com.nttdata.academy.dto.ProdutoDTO;
import com.nttdata.academy.facade.ProdutoFacade;
import com.nttdata.academy.models.ClienteModels;
import com.nttdata.academy.models.ProdutoModels;
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
@RequestMapping("/produto")
public class  ProdutoController {

    private static final Logger LOG = LogManager.getLogger(ProdutoController.class);

    @Resource(name = "produtoFacade")
    private ProdutoFacade produtoFacade;

    @RequestMapping(value = "/adicionar", method = RequestMethod.POST)
    public ResponseEntity adicionarProduto(@RequestBody ProdutoDTO produto){

        LOG.debug(produto.toString());

        produtoFacade.adicionar(produto);

        return ResponseEntity.ok().body(produto);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ProdutoModels> deletarProduto(@PathVariable Integer id){

        return produtoFacade.deletar(id);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<ProdutoModels>> receberProduto(@PathVariable Integer id){

        return produtoFacade.listar(id);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity <ProdutoDTO> atualizarProduto(@RequestBody ProdutoDTO produto, @PathVariable Integer id){

        return produtoFacade.atualizar(produto, id);
    }



}
