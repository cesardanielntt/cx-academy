package com.nttdata.academy.populators;

import com.nttdata.academy.dto.PrecoDTO;
import com.nttdata.academy.models.PrecoModel;

public interface PrecoPopulator {

    PrecoModel populatePrecoModel(PrecoDTO precoDTO);

    PrecoDTO populatePrecoDto(PrecoModel preco);
}
