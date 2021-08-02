package com.nttdata.academy.facade;

import com.nttdata.academy.dto.CarrinhoDTO;
import org.springframework.http.ResponseEntity;

public interface CarrinhoFacade {

    ResponseEntity adicionar(CarrinhoDTO carrinhoDTO);

}
