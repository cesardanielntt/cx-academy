package com.nttdata.academy.service;

import com.nttdata.academy.model.ProdutoModel;
import org.springframework.beans.factory.annotation.Autowired;

public interface ProdutoService {

    ProdutoModel saveProduto(ProdutoModel produto);
}
