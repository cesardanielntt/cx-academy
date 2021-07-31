package com.nttdata.academy.facade;

import com.nttdata.academy.dto.CarrinhoDTO;
import com.nttdata.academy.dto.ProdutoDTO;
import com.nttdata.academy.models.CarrinhoModel;
import com.nttdata.academy.models.ClienteModel;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface CarrinhoFacade {

    CarrinhoDTO adicionar(CarrinhoDTO carrinho);

    ResponseEntity<Optional<CarrinhoModel>> listar(Integer id);

    ResponseEntity<CarrinhoDTO> atualizar(CarrinhoDTO carrinhoDTO, Integer id);

    ResponseEntity deletar(Integer id);
}
