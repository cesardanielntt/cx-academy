package br.com.nttdata;

import br.com.nttdata.models.Pessoa;
import br.com.nttdata.models.PessoaFisica;
import br.com.nttdata.models.PessoaJuridica;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String args[]) {

        PessoaFisica pf = new PessoaFisica();
        Pessoa a = new PessoaJuridica();

        pf.setNome("Pedro");
        pf.setSobrenome("Alves");
        pf.setEmail("pedro@email.com");
        pf.setIdade(21);

        PessoaJuridica pj = new PessoaJuridica();

        pj.setNome("Pessoa Juridica");
        pj.setEmail("email@teste.com");
        pj.setCnpj("123456789");

        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(pf);
        pessoas.add(pj);

        for(Pessoa p: pessoas){
            System.out.println(p.toString());
        }
    }
}
