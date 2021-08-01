package com.nttdata.academy.facade;

import com.nttdata.academy.dto.ClienteDTO;
import com.nttdata.academy.dto.ProdutoDTO;
import com.nttdata.academy.models.ClienteModel;
import com.nttdata.academy.models.ProdutoModel;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface ProdutoFacade {

    ProdutoDTO adicionar(ProdutoDTO produto);

    ResponseEntity<Optional<ProdutoModel>> listar(Integer id);

    ResponseEntity<ProdutoDTO> atualizar(ProdutoDTO produtoDTO, Integer id);

    ResponseEntity deletar(Integer id);

}
