package com.nttdata.academy.service.impl;

import com.nttdata.academy.daos.ItemRepository;
import com.nttdata.academy.models.ItemModel;
import com.nttdata.academy.models.ProdutoModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service("itemService")
public class DefaultItemService {
    private static Logger LOG = LogManager.getLogger(DefaultItemService.class);

    private ItemRepository itemRepository;

    public DefaultItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }


    public ItemModel adicionar(ItemModel item) {
        LOG.debug(item);

        return itemRepository.save(item);
    }
}
