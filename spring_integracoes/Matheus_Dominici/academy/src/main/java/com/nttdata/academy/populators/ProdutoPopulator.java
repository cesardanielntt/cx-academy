package com.nttdata.academy.populators;

import com.nttdata.academy.dto.ProdutoDto;
import com.nttdata.academy.models.ProdutoModel;

public interface ProdutoPopulator {


    ProdutoModel populateProdutoModel(ProdutoDto produtoDto);

    ProdutoDto populateProdutoDto(ProdutoModel produto);
}
