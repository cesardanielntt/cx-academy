package com.nttdata.academy.facade;

import com.nttdata.academy.dto.ProdutoDTO;

import java.util.List;

public interface ProdutoFacade {
    ProdutoDTO adicionar(ProdutoDTO produto);

    List<ProdutoDTO> getProdutos();
}
