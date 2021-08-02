package com.nttdata.academy.populator;

import com.nttdata.academy.dto.ProdutoDTO;


public interface ProdutoPopulator {
    com.nttdata.academy.models.ProdutoModel populateProdutoModel(ProdutoDTO produtoDTO);

    ProdutoDTO populateProdutoDto(com.nttdata.academy.models.ProdutoModel produto);
}
