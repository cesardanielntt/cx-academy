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
    public ItemModel populateItemModel(ItemDTO item) {
        return modelMapperService.modelMapper().map(item, ItemModel.class);
    }
    @Override
    public ItemDTO populateItemDTO(ItemModel item) {
        return modelMapperService.modelMapper().map(item, ItemDTO.class);
    }
}
