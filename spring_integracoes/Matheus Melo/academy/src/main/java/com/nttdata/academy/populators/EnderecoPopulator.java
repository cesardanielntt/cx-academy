package com.nttdata.academy.populators;

import com.nttdata.academy.dto.EnderecoDTO;
import com.nttdata.academy.models.EnderecoModels;

public interface EnderecoPopulator {
    EnderecoModels populateEnderecoModel(EnderecoModels enderecoDTO);

    EnderecoDTO populateEnderecoDTO(EnderecoModels cliente);
}
