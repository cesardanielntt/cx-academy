package com.nttdata.academy.populators;

import com.nttdata.academy.dto.ProdutoDTO;
import com.nttdata.academy.models.ProdutoModels;

public interface ProdutoPopulator {
    ProdutoModels populateProdutoModels(ProdutoDTO produtoDTO);

    ProdutoDTO populateProdutoDTO(ProdutoModels produtoModels);
}
