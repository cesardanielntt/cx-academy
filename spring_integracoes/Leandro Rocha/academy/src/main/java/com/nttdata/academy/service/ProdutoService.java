package com.nttdata.academy.service;

import com.nttdata.academy.models.ProdutoModel;

public interface ProdutoService {
   default ProdutoModel adicionar(ProdutoModel produto){
       return null;
   }
}
