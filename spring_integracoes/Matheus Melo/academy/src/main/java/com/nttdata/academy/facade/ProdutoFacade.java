package com.nttdata.academy.facade;

import com.nttdata.academy.dto.ProdutoDTO;
import com.nttdata.academy.models.ProdutoModels;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface ProdutoFacade {

    ProdutoDTO adicionar(ProdutoDTO produto);

    ResponseEntity<Optional<ProdutoModels>> listar(Integer id);

    ResponseEntity deletar(Integer id);

    ResponseEntity<ProdutoDTO> atualizar(ProdutoDTO produtoDTO, Integer id);
}
