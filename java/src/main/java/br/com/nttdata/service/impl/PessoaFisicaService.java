package br.com.nttdata.service.impl;

<<<<<<< HEAD

=======
>>>>>>> origin/master
import br.com.nttdata.models.PessoaFisica;
import br.com.nttdata.service.PessoaService;
import br.com.nttdata.singleton.PessoaSingleton;

import java.util.List;

public class PessoaFisicaService implements PessoaService {

<<<<<<< HEAD

=======
>>>>>>> origin/master
    @Override
    public void criarPessoa(PessoaFisica pessoa) {
        PessoaSingleton.getInstance().getData().add(pessoa);
    }

    @Override
<<<<<<< HEAD
    public List<PessoaFisica> listarPessoa() {
=======
    public List<PessoaFisica> listarPessoas() {
>>>>>>> origin/master
        return PessoaSingleton.getInstance().getData();
    }
}
