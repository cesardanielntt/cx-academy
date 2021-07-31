package com.nttdata.academy.facade;

import com.nttdata.academy.dto.CarrinhoDto;
import org.springframework.http.ResponseEntity;

public interface CarrinhoFacade {
    ResponseEntity adicionar(CarrinhoDto carrinho);
}
