package com.nttdata.academy.service;

import com.nttdata.academy.models.PrecoModel;

import java.util.List;

public interface PrecoService {

    PrecoModel adicionar(PrecoModel preco);

    PrecoModel atualizar(PrecoModel preco, Integer id);

    public List<PrecoModel> consultar(Integer id);

    public List<PrecoModel> listar();

    public void deletar(Integer id);
}
