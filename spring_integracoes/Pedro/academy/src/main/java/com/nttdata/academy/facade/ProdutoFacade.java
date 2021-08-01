package com.nttdata.academy.facade;

import com.nttdata.academy.dto.ProdutoDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProdutoFacade {

    ResponseEntity adicionar(ProdutoDTO produto);

    List<ProdutoDTO> listar();

    public ProdutoDTO consultar(Integer id);

    void atualizar(ProdutoDTO produto, Integer id);

    public void deletar(Integer id);

}
