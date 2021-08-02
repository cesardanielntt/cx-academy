package com.nttdata.academy.populators;

import com.nttdata.academy.dto.ItemDTO;
import com.nttdata.academy.models.ItemModel;

public interface ItemPopulator {

    ItemModel populateItemModel(ItemDTO itemDTO);

    ItemDTO populateItemDto(ItemModel item);
}
