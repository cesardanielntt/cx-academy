package com.nttdata.academy.populators;

import com.nttdata.academy.dto.ProdutoDTO;
import com.nttdata.academy.models.ProdutoModel;

public interface ProdutoPopulator {
    ProdutoModel populateProdutoModel(ProdutoDTO produtoDTO);
    ProdutoDTO populateProdutoDTO(ProdutoModel produto);
}
