package com.nttdata.academy.controller;

import com.nttdata.academy.daos.ProdutoRepository;
import com.nttdata.academy.dto.ClienteDTO;
import com.nttdata.academy.dto.ProdutoDTO;
import com.nttdata.academy.facade.ProdutoFacade;
import com.nttdata.academy.models.ClienteModel;
import com.nttdata.academy.models.ProdutoModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private static final Logger LOG = LogManager.getLogger(ProdutoController.class);

    @Resource(name = "produtoFacade")
    private ProdutoFacade produtoFacade;


    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<ProdutoModel>> receberProdutoPeloId(@PathVariable Integer id) {
        return produtoFacade.listar(id);
    }

    @RequestMapping(value = "/adicionar", method = RequestMethod.POST)
    public ResponseEntity adicionarProduto(@RequestBody ProdutoDTO produto) {

        LOG.debug(produto.toString());

        produto = produtoFacade.adicionar(produto);

        return ResponseEntity.ok().body(produto);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ProdutoDTO> atualizarProduto(@RequestBody ProdutoDTO produto, @PathVariable Integer id) {
        return produtoFacade.atualizar(produto, id);

    }

}
