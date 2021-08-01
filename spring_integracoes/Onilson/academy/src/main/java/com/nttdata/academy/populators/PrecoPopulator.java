package com.nttdata.academy.populators;

import com.nttdata.academy.dto.PrecoDTO;
import com.nttdata.academy.models.PrecoModel;

public interface PrecoPopulator {

    PrecoDTO populatePrecoDTO(PrecoModel preco);

    PrecoModel populatePrecoModel(PrecoDTO precoDTO);

}
