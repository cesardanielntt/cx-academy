package br.com.nttdata.service;


import br.com.nttdata.models.PessoaFisica;

import java.util.List;

public interface PessoaService {

    public void criarPessoa(PessoaFisica pessoa);

    public List<PessoaFisica> listarPessoas();
}
