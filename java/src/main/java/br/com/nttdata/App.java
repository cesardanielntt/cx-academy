package br.com.nttdata;

import br.com.nttdata.models.Pessoa;
import br.com.nttdata.models.PessoaFisica;
import br.com.nttdata.models.PessoaJuridica;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        PessoaFisica pessoa = new PessoaFisica();

        pessoa.setNome("Jose");
        pessoa.setSobrenome("Silva");
        pessoa.setEmail("jose@gmail.com");
        pessoa.setIdade(12);

        PessoaFisica pessoa2 = new PessoaFisica();
        pessoa2.setNome("hehe");
        pessoa2.setSobrenome("Chico");
        pessoa2.setEmail("Ramonsilva@gmail.com");
        pessoa2.setIdade(15);

        PessoaJuridica pj1 = new PessoaJuridica();
        pj1.setNome("Pessoa Juridica");
        pj1.setEmail("pj1@teste.com");
        pj1.setCnpj("185.8258.258.255");



        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(pessoa);
        pessoas.add(pessoa2);
        pessoas.add(pj1);

        for(Pessoa item: pessoas) {
            if(item instanceof PessoaFisica) {
                System.out.println(((PessoaFisica) item).getSobrenome());
            } else {
                System.out.println(((PessoaJuridica) item).getCnpj());
            }
        }
    }

    public static double soma(double valor1, double valor2) {
        return valor1 + valor2;
    }

    public static void fors() {

        String meuNome = "Ramon";
        String meuSobrenome = "Silva";
        int idade = 19;
        double peso = 68.23;

//        System.out.println(meuNome + " " + meuSobrenome);
//        System.out.println("Idade: " + idade );
//        System.out.println("peso: " + peso );

        double preco1 = 10.00;
        double preco2 = 15.00;

        double total  = soma(preco1, preco2);

        System.out.println("total: " + total );

        List<String> numerais = new ArrayList<>();
        numerais.add(meuNome);
        numerais.add(meuSobrenome);


        List<Integer> numeros = new ArrayList<>();
        numeros.add(2);
        numeros.add(10);

        System.out.println(numeros.get(1) + " Ramon");


        for(String item: numerais) {
            if(item.equals("Ramon")) {
                System.out.println(item);
            }

        }

        for(int i = 0; i<=100; i++) {
            if(i%2 == 0) {
                System.out.println(i + " PAR");
            } else {
                System.out.println(i + " IMPAR");
            }

        }
    }
}
