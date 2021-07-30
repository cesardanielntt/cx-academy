package com.nttdata.academy.facade;

import com.nttdata.academy.dto.ProdutoDTO;
import org.springframework.http.ResponseEntity;

public interface ProdutoFacade {

    ResponseEntity adicionar(ProdutoDTO produto);

}
