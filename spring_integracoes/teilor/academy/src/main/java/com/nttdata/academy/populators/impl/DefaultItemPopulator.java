package com.nttdata.academy.populators.impl;

import com.nttdata.academy.dto.ItemDTO;
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
    public ItemModel populateItemModel(ItemDTO itemDTO) {
        ItemModel item = modelMapperService.modelMapper().map(itemDTO, ItemModel.class);
        return item;
    }

    @Override
    public ItemDTO populateItemDto(ItemModel item) {
        ItemDTO itemDTO = modelMapperService.modelMapper().map(item, ItemDTO.class);
        return itemDTO;
    }
}
