package br.com.nttdata.service.impl;

import br.com.nttdata.models.PessoaFisica;
import br.com.nttdata.singleton.PessoaSingleton;
import br.com.nttdata.service.PessoaService;

import java.util.List;

public class PessoaFisicaService implements PessoaService {

    @Override
    public void criarPessoa(PessoaFisica pf){
        PessoaSingleton.getInstance().getData().add(pf);
    }

    @Override
    public List<PessoaFisica> listarPessoas(){
        return PessoaSingleton.getInstance().getData();
    }
}
