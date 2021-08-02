package com.nttdata.academy.service.impl;

import com.nttdata.academy.daos.ItemRepository;
import com.nttdata.academy.models.ItemModel;
import com.nttdata.academy.service.ItemService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("itemService")
public class DefaultItemService implements ItemService {

    private static final Logger LOG = LogManager.getLogger(DefaultItemService.class);

    private ItemRepository itemRepository;

    @Autowired
    public DefaultItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public ItemModel adicionar(ItemModel item) {

        LOG.debug(item);

        return itemRepository.save(item);

    }

}
