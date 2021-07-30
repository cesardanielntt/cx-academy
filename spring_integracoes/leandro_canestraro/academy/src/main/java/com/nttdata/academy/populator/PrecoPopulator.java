package com.nttdata.academy.populator;

import com.nttdata.academy.dto.PrecoDTO;
import com.nttdata.academy.model.PrecoModel;

public interface PrecoPopulator {

    PrecoModel populatePrecoModel(PrecoDTO source);

    PrecoDTO populatePrecoDTO(PrecoModel source);
}
