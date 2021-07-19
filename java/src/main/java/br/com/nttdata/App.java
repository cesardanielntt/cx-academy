package br.com.nttdata;

import br.com.nttdata.models.Pessoa;
import br.com.nttdata.models.PessoaFisica;
import br.com.nttdata.models.PessoaJuridica;

import java.util.ArrayList;
import java.util.List;

public class App {
    static String meuNome = "Thales";

    public static void main(String[] args){
        PessoaFisica pessoa = new PessoaFisica();
        pessoa.setNome("thales");
        pessoa.setSobrenome("Assis");
        pessoa.setEmail("thalesgc2011@hotmail.com");
        pessoa.setIdade(18);


        PessoaFisica pessoa2 = new PessoaFisica();
        pessoa2.setNome("Cleber");
        pessoa2.setSobrenome("Teste");
        pessoa2.setEmail("teste@teste.com");
        pessoa2.setIdade("32");

        PessoaJuridica pj1 = new PessoaJuridica();
        pj1.setNome("Pessoa Juridica");
        pj1.setEmail("pj1@teste.com");
        pj1.setCnpj("53.178.531/0001-35");



        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(pessoa);
        pessoas.add(pessoa2);
        pessoas.add(pj1);

        for(Pessoa item: pessoas){
            if(item instanceof PessoaFisica){
                System.out.println(((PessoaFisica)item).getSobrenome());
            }else if (item instanceof PessoaJuridica){
                System.out.println(((PessoaJuridica) item).getCnpj);
            }
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

