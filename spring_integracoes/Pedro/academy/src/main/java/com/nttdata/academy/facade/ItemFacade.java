package com.nttdata.academy.facade;

import com.nttdata.academy.dto.ItemDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ItemFacade {

    ResponseEntity adicionar(ItemDTO item);

    List<ItemDTO> listar();

    public ItemDTO consultar(Integer id);

    ResponseEntity atualizar(ItemDTO item, Integer id);

    public void deletar(Integer id);

}
