package br.com.nttdata.service;

import br.com.nttdata.models.PessoaJuridica;

import java.util.List;

public interface EmpresaService {
    public void criarPessoa(PessoaJuridica person);

    public List<PessoaJuridica> listarPessoas();
}
