package com.nttdata.academy.facade.impl;

import com.nttdata.academy.dto.ItemDTO;
import com.nttdata.academy.facade.ItemFacade;
import com.nttdata.academy.models.ItemModel;
import com.nttdata.academy.populators.ItemPopulator;
import com.nttdata.academy.service.ItemService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service("itemFacade")
public class DefaultItemFacade implements ItemFacade {

    private static final Logger LOG = LogManager.getLogger(DefaultItemFacade.class);

    @Autowired
    private ItemPopulator itemPopulator;

    @Autowired
    private ItemService itemService;

    @Override
    public ResponseEntity adicionar(ItemDTO itemDTO) {

        LOG.debug(itemDTO);

        ItemModel item = itemPopulator.populateItemModel(itemDTO);

        item = itemService.adicionar(item);

        itemDTO = itemPopulator.populateItemDto(item);

        LOG.debug(itemDTO);

        return ResponseEntity.ok().body(itemDTO);

    }

}