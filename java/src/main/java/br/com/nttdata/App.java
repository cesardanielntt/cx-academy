package br.com.nttdata;

import br.com.nttdata.models.Pessoa;
import br.com.nttdata.models.PessoaFisica;
import br.com.nttdata.models.PessoaJuridica;
import br.com.nttdata.singleton.PessoaSingleton;

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

        PessoaFisica pf2 = new PessoaFisica();

        pf2.setNome("Ana");
        pf2.setSobrenome("Oliveira");
        pf2.setEmail("ana@email.com");
        pf2.setIdade(20);

        PessoaJuridica pj = new PessoaJuridica();

        pj.setNome("Pessoa Juridica");
        pj.setEmail("email@teste.com");
        pj.setCnpj("123456789");

        PessoaSingleton.getInstance().getData().add(pf);
        PessoaSingleton.getInstance().getData().add(pf2);

        List<PessoaFisica> data = PessoaSingleton.getInstance().getData();

        for(PessoaFisica p: data){
            System.out.println(p);
        }
/*
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(pf);
        pessoas.add(pj);

        for(Pessoa p: pessoas){
            System.out.println(p.toString());
        } */
    }
}
