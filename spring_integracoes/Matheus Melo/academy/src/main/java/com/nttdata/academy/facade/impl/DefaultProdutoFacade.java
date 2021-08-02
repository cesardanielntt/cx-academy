package com.nttdata.academy.facade.impl;


import com.nttdata.academy.controller.ClienteController;
import com.nttdata.academy.dto.ClienteDTO;
import com.nttdata.academy.dto.ProdutoDTO;
import com.nttdata.academy.facade.ProdutoFacade;
import com.nttdata.academy.models.ProdutoModels;
import com.nttdata.academy.populators.ProdutoPopulator;
import com.nttdata.academy.service.ProdutoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("produtoFacade")
public class DefaultProdutoFacade implements ProdutoFacade {
    private static final Logger LOG = LogManager.getLogger(ClienteController.class);

    @Autowired
    public ProdutoPopulator produtoPopulator;

    @Autowired
    private ProdutoService produtoService;

    @Override
    public ProdutoDTO adicionar(ProdutoDTO produtoDTO) {
        ProdutoModels produto = produtoPopulator.populateProdutoModels(produtoDTO);
        produto = produtoService.adicionar(produto);
        produtoDTO = produtoPopulator.populateProdutoDTO(produto);

        return produtoDTO;
    }

    @Override
    public ResponseEntity<Optional<ProdutoModels>> listar(Integer id) {
        Optional<ProdutoModels> produto = produtoService.listar(id);

        return ResponseEntity.ok().body(produto);
    }

    @Override
    public ResponseEntity deletar(Integer id) {
        Optional<ProdutoModels> produtoData = produtoService.listar(id);

        if (produtoData.isEmpty()){
            return messageFalha();
        } else {
            produtoService.deletar(id);
            return messageSucesso();
        }
    }

    @Override
    public ResponseEntity<ProdutoDTO> atualizar(ProdutoDTO produtoDTO, Integer id) {
        ProdutoModels produto = produtoPopulator.populateProdutoModels(produtoDTO);
        produto = produtoService.atualizar(produto, id);
        produtoDTO = produtoPopulator.populateProdutoDTO(produto);

        return ResponseEntity.ok().body(produtoDTO);
    }

    private ResponseEntity messageFalha(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ClienteDTO("Produto não encontrado!", 404));
    }

    private ResponseEntity messageSucesso(){
        return ResponseEntity.ok().body(new ClienteDTO("Produto removido com sucesso!", 200));
    }
}
