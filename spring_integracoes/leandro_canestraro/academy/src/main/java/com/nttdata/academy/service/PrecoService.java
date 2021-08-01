package com.nttdata.academy.service;

import com.nttdata.academy.model.PrecoModel;

import java.util.List;
import java.util.Optional;

public interface PrecoService {

    PrecoModel savePreco(PrecoModel preco);

    List<PrecoModel> getPrecoByCliente(Integer id);
}
