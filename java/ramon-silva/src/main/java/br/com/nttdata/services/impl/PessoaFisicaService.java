package br.com.nttdata.services.impl;

import br.com.nttdata.models.PessoaFisica;
import br.com.nttdata.services.PessoaService;
import br.com.nttdata.singleton.PessoaSingleton;

import java.util.List;

public class PessoaFisicaService implements PessoaService {
    @Override
    public void criarPessoa(PessoaFisica pessoa) {
        PessoaSingleton.getInstance().getData().add(pessoa);
    }

    @Override
    public List<PessoaFisica> listarPessoa() {
        return PessoaSingleton.getInstance().getData();
    }
}
