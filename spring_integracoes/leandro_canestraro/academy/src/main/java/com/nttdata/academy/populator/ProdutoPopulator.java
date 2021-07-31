package com.nttdata.academy.populator;

import com.nttdata.academy.dto.ProdutoDTO;
import com.nttdata.academy.model.ProdutoModel;

public interface ProdutoPopulator {

    ProdutoModel populateProdutoModel(ProdutoDTO source);

    ProdutoDTO populateProdutoDTO(ProdutoModel source);



}
