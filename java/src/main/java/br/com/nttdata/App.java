package br.com.nttdata;


import br.com.nttdata.models.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        Pessoa pessoa = new Pessoa("Ramon");

        pessoa.setNome("Jose");
        pessoa.setSobrenome("Silva");
        pessoa.setEmail("jose@gmail.com");
        pessoa.setIdade(12);

        Pessoa pessoa2 = new Pessoa("Ramons");
        pessoa2.setSobrenome("Chico");
        pessoa2.setEmail("Ramonsilva@gmail.com");
        pessoa2.setIdade(15);

        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(pessoa);
        pessoas.add(pessoa2);



        for(Pessoa item: pessoas) {
            System.out.println(item.getNome());
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
