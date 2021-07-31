package com.nttdata.academy.populators;


import com.nttdata.academy.dto.ItemDto;
import com.nttdata.academy.models.ItemModel;

public interface ItemPopulator {
    ItemModel populateItemModel(ItemDto item);

    ItemDto populateItemDto(ItemModel itemModel);
}
