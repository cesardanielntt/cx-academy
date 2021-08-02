package com.nttdata.academy.facade.impl;

import com.nttdata.academy.dto.ProdutoDTO;
import com.nttdata.academy.dto.ProdutoDTO;
import com.nttdata.academy.facade.ProdutoFacade;
import com.nttdata.academy.models.ProdutoModel;
import com.nttdata.academy.models.ProdutoModel;
import com.nttdata.academy.populators.ProdutoPopulator;
import com.nttdata.academy.service.ProdutoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("produtoFacade")
public class DefaultProdutoFacade implements ProdutoFacade {

    private static final Logger LOG = LogManager.getLogger(DefaultProdutoFacade.class);

    @Autowired
    private ProdutoPopulator produtoPopulator;

    @Autowired
    private ProdutoService produtoService;

    @Override
    public ResponseEntity adicionar(ProdutoDTO produtoDTO) {

        //LOG.debug(produtoDTO);

        ProdutoModel produto = produtoPopulator.populateProdutoModel(produtoDTO);

        produto = produtoService.adicionar(produto);

        System.out.println("Id do produto: " + produto.getId());

        produtoDTO = produtoPopulator.populateProdutoDto(produto);

        LOG.debug(produtoDTO);

        return ResponseEntity.ok().body(produtoDTO);

    }

    @Override
    public List<ProdutoDTO> listar(){

        List<ProdutoModel> produtoModels = produtoService.listar(); // returns List<ProdutoModel>

        List<ProdutoDTO> produtosDTO = new ArrayList<>();

        for(ProdutoModel produto: produtoModels){
            produtosDTO.add(produtoPopulator.populateProdutoDto(produto));
        }

        return produtosDTO;
    }

    public ProdutoDTO consultar(Integer id){
        List<ProdutoModel> produtoModels = produtoService.consultar(id); // returns List<ProdutoModel>

        List<ProdutoDTO> produtosDTO = new ArrayList<>();

        for(ProdutoModel produto: produtoModels){
            produtosDTO.add(produtoPopulator.populateProdutoDto(produto));
        }

        ProdutoDTO produto = new ProdutoDTO();

        if(produtosDTO.size() > 0 ) produto = produtosDTO.get(0);

        return produto;
    }

    @Override
    public void atualizar(ProdutoDTO produto, Integer id){

        ProdutoModel produtoModel = produtoPopulator.populateProdutoModel(produto);

        produtoService.atualizar(produtoModel, id);
    }

    @Override
    public void deletar(Integer id){

        produtoService.deletar(id);

    }

}