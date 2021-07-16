package br.com.nttdata;

import br.com.nttdata.models.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        Pessoa pessoa = new Pessoa("Tiago");
        pessoa.setSobrenome("Schlogl");
        pessoa.setEmail("tiago.schlogl@hotmail.com");
        pessoa.setIdade(31);

        Pessoa pessoa2 = new Pessoa("Teste");
        pessoa2.setSobrenome("Teste");
        pessoa2.setEmail("teste@teste.com");
        pessoa2.setIdade(99);


        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(pessoa);
        pessoas.add(pessoa2);

        for(Pessoa item: pessoas){
            System.out.println(item.getNome());
        }




    }

}
