package com.nttdata.academy.service;

import com.nttdata.academy.model.ProdutoModel;
import org.springframework.beans.factory.annotation.Autowired;

public interface ProdutoService {

    void saveProduto(ProdutoModel produto);
}
