package com.nttdata.academy.populators.impl;

import com.nttdata.academy.dto.ItemDto;
import com.nttdata.academy.models.ItemModel;
import com.nttdata.academy.populators.ItemPopulator;
import com.nttdata.academy.service.ModelMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("itemPopulator")
public class DefaultItemPopulator implements ItemPopulator {

    @Autowired
    private ModelMapperService modelMapperService;


    @Override
    public ItemModel populateItemModel(ItemDto itemDto) {
        ItemModel item = modelMapperService.modelMapper().map(itemDto, ItemModel.class);

        return item;
    }

    @Override
    public ItemDto populateItemDto(ItemModel item) {
       ItemDto itemDto = modelMapperService.modelMapper().map(item, ItemDto.class);

        return itemDto;
    }
}
