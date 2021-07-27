package com.nttdata.academy.service.impl;

import com.nttdata.academy.dao.ProdutoDAO;
import com.nttdata.academy.model.ProdutoModel;
import com.nttdata.academy.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultProdutoService implements ProdutoService {

    @Autowired
    private ProdutoDAO produtoDAO;

    @Override
    public void saveProduto(ProdutoModel produto) {
        if (produto != null) {
            produtoDAO.save(produto);
        }
    }
}
