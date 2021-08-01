package com.nttdata.academy.facade.impl;

import com.nttdata.academy.dto.ProdutoDTO;
import com.nttdata.academy.facade.ProdutoFacade;
import com.nttdata.academy.model.ProdutoModel;
import com.nttdata.academy.populator.ProdutoPopulator;
import com.nttdata.academy.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//Communication between Controller and Service layers
@Service("produtoFacade")
public class DefaultProdutoFacade implements ProdutoFacade {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ProdutoPopulator produtoPopulator;

    //Call service to insert on db
    @Override
    public ProdutoDTO adicionar(ProdutoDTO source) {

        ProdutoModel produto = produtoService.saveProduto(produtoPopulator.populateProdutoModel(source));

        source = produtoPopulator.populateProdutoDTO(produto);

        return source;
    }

    @Override
    public List<ProdutoDTO> getProdutos() {

        List<ProdutoDTO> target = new ArrayList<>();
        List<ProdutoModel> produtos = produtoService.getProdutos();

        for(ProdutoModel produto : produtos) {
            target.add(produtoPopulator.populateProdutoDTO(produto));
        }
        return target;
    }

    @Override
    public String deleteProduto(Integer id) {

        try {
            produtoService.deleteProduto(id);
        } catch (Exception e) {
            return "Erro ao deletar produto: " + e.getMessage();
        }
        return "Produto deletado com sucesso (precos relacionados ao produto tambem foram deletados)";
    }
}
