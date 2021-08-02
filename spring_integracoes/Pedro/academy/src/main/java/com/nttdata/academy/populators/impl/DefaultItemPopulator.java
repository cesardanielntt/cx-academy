package com.nttdata.academy.populators.impl;

import com.nttdata.academy.dto.ItemDTO;
import com.nttdata.academy.models.ItemModel;
import com.nttdata.academy.populators.ItemPopulator;
import com.nttdata.academy.service.ModelMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ItemPopulator")
public class DefaultItemPopulator implements ItemPopulator {

    @Autowired
    private ModelMapperService modelMapperService;

    @Override
    public ItemModel populateItemModel(ItemDTO ItemDTO) {
        ItemModel Item = modelMapperService.modelMapper().map(ItemDTO, ItemModel.class);

        return Item;
    }

    @Override
    public ItemDTO populateItemDto(ItemModel Item) {
        ItemDTO ItemDTO = modelMapperService.modelMapper().map(Item, ItemDTO.class);

        return ItemDTO;
    }
}
