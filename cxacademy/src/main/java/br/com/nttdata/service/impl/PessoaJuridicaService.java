package br.com.nttdata.service.impl;

import br.com.nttdata.models.PessoaFisica;
import br.com.nttdata.models.PessoaJuridica;
import br.com.nttdata.service.EmpresaService;
import br.com.nttdata.service.PessoaService;
import br.com.nttdata.singleton.EmpresaSingleton;

import java.util.List;

public class PessoaJuridicaService implements EmpresaService {

    @Override
    public void criarPessoa(PessoaJuridica person) {
        EmpresaSingleton.getInstance().getData().add(person);
    }

    @Override
    public List<PessoaJuridica> listarPessoas() {
        return EmpresaSingleton.getInstance().getData();
    }
}
