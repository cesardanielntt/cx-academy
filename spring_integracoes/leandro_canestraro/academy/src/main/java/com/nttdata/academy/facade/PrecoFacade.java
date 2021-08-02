package com.nttdata.academy.facade;

import com.nttdata.academy.dto.PrecoDTO;

import java.util.List;

public interface PrecoFacade {

    PrecoDTO adicionar(PrecoDTO preco);

    List<PrecoDTO> getPrecoByCliente(Integer clienteId);
}
