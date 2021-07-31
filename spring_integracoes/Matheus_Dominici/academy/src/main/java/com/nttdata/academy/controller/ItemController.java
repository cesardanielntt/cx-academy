package com.nttdata.academy.controller;


import com.nttdata.academy.dto.ItemDto;
import com.nttdata.academy.facade.ItemFacade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/item")
public class ItemController {
    private static final Logger LOG = LogManager.getLogger(ItemController.class);

    @Resource(name="itemFacade")
    private ItemFacade itemFacade;

    @RequestMapping(value = "/item", method = RequestMethod.POST)
    public ResponseEntity adicionarItem(@RequestBody ItemDto item){
        LOG.debug(item.toString());
        item = itemFacade.adicionar(item);

        return itemFacade.adicionar(item);
    }

}
