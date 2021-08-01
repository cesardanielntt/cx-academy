package com.nttdata.academy.service;

import com.nttdata.academy.model.ProdutoModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface ProdutoService {

    ProdutoModel saveProduto(ProdutoModel produto);
    List<ProdutoModel> getProdutos();
    void deleteProduto(Integer id);
}
