package com.nttdata.academy.facade;

import com.nttdata.academy.dto.ItemDTO;
import org.springframework.http.ResponseEntity;

public interface ItemFacade {

    ResponseEntity adicionar(ItemDTO item);

}
