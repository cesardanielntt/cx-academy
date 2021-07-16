package br.com.nttdata;

import br.com.nttdata.Models.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class App {
    final static String meuNome = "karol";
    public static void main(String[] args){

        Pessoa pessoa = new Pessoa( "karol");
        pessoa.setSobrenome("Penteado");
        pessoa.setEmail("karol@nttdata.com");
        pessoa.setIdade(24);
        System.out.println(pessoa.toString());

        Pessoa pessoa2 = new Pessoa( "joao");
        pessoa2.setSobrenome("Gomes");
        pessoa2.setEmail("joao@nttdata.com");
        pessoa2.setIdade(26);
        System.out.println(pessoa2.toString());

        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(pessoa);
        pessoas.add(pessoa2);

        for (Pessoa item: pessoas){
            System.out.println(item.getNome());
        }
    }


}

