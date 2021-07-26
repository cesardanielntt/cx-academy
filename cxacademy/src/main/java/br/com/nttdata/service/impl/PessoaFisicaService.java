package br.com.nttdata.service.impl;

import br.com.nttdata.models.PessoaFisica;
import br.com.nttdata.service.PessoaService;
import br.com.nttdata.singleton.PessoaSingleton;

import java.util.List;

public class PessoaFisicaService implements PessoaService {

    @Override
    public void criarPessoa(PessoaFisica person) {
        PessoaSingleton.getInstance().getData().add(person);
    }

    @Override
    public List<PessoaFisica> listarPessoas() {
        return PessoaSingleton.getInstance().getData();
    }
}
