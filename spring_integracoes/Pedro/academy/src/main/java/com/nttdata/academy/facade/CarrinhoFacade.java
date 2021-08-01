package com.nttdata.academy.facade;

import com.nttdata.academy.dto.CarrinhoDTO;
import com.nttdata.academy.dto.ClienteDTO;
import com.nttdata.academy.dto.ProdutoDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CarrinhoFacade {

    ResponseEntity criar(CarrinhoDTO carrinho);

    public List<CarrinhoDTO> listar();

    public CarrinhoDTO consultar(Integer id);

    ResponseEntity atualizar(CarrinhoDTO carrinho, Integer id);

    public void deletar(Integer id);

}
