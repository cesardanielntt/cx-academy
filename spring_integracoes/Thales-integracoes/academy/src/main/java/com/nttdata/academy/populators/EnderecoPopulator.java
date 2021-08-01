package com.nttdata.academy.populators;

import com.nttdata.academy.dto.EnderecoDTO;
import com.nttdata.academy.dto.ProdutoDTO;
import com.nttdata.academy.models.EnderecoModel;
import com.nttdata.academy.models.ProdutoModel;

public interface EnderecoPopulator {
    EnderecoModel populateEnderecoModel(EnderecoDTO enderecoDTO);

    EnderecoDTO populateEnderecoDTO(EnderecoModel endereco);
}

