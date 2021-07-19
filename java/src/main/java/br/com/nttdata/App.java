package br.com.nttdata;

import br.com.nttdata.models.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class App {
    static String meuNome = "Thales";

    public static void main(String[] args){
        Pessoa pessoa = new Pessoa("Thales");
        pessoa.setSobrenome("Assis");
        pessoa.setEmail("thalesgc2011@hotmail.com");
        pessoa.setIdade(18);


        pessoa pessoa2 = new Pessoa("Cleber");
        pessoa2.setSobreNome("teste");
        pessoa2.set.Email("teste@teste.com");
        pessoa2.set.Idade("32");



        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(pessoa);
        pessoas.add(pessoa2);

        for(Pessoa item: pessoas){
            System.out.println(item.getNome());
        }







//        pessoa.setNome("Thales");

//        System.out.println(pessoa.);


    }

//
//
//    }
//    public static double soma(double valor1, double valor2){
//        return valor1 +valor2;
//    }

//    public static void fors(){

    }

