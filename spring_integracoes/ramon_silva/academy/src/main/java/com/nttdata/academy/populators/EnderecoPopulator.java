package com.nttdata.academy.populators;

import com.nttdata.academy.dto.ClienteDTO;
import com.nttdata.academy.dto.EnderecoDTO;
import com.nttdata.academy.models.ClienteModel;
import com.nttdata.academy.models.EnderecoModel;

public interface EnderecoPopulator {

    EnderecoModel populateEnderecoModel(EnderecoModel enderecoDTO);

    EnderecoDTO populateEnderecoDTO(EnderecoModel cliente);

}
