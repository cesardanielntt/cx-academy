package com.nttdata.academy.populators.impl;

import com.nttdata.academy.dto.EnderecoDTO;
import com.nttdata.academy.models.EnderecoModels;
import com.nttdata.academy.populators.EnderecoPopulator;
import org.springframework.stereotype.Service;

@Service("enderecoPopulator")
public class DefaultEnderecoPopulator implements EnderecoPopulator {
    @Override
    public EnderecoModels populateEnderecoModel(EnderecoModels enderecoDTO) {
        return null;
    }

    @Override
    public EnderecoDTO populateEnderecoDTO(EnderecoModels cliente) {
        return null;
    }
}
