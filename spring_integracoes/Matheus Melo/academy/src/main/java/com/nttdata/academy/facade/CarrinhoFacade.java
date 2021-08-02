package com.nttdata.academy.facade;

import com.nttdata.academy.dto.CarrinhoDTO;
import com.nttdata.academy.models.CarrinhoModels;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface CarrinhoFacade {

    CarrinhoDTO adicionar(CarrinhoDTO carrinho);

    ResponseEntity<Optional<CarrinhoModels>> listar(Integer id);

    ResponseEntity<CarrinhoDTO> atualizar(CarrinhoDTO carrinhoDTO, Integer id);

    ResponseEntity deletar(Integer id);
}
