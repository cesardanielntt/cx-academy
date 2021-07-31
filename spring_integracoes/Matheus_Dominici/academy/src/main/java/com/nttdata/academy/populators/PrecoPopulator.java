package com.nttdata.academy.populators;

import com.nttdata.academy.dto.PrecoDto;
import com.nttdata.academy.models.PrecoModel;

public interface PrecoPopulator {

    PrecoModel populatePrecoModel(PrecoDto precoDto);

    PrecoDto populatePrecoDto(PrecoModel preco);
}
