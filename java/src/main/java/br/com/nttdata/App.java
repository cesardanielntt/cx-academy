package br.com.nttdata;


import br.com.nttdata.models.Pessoa;

import java.util.ArrayList;
import java.util.List;


public class App {
    final static String meuNome = "Maiara";

    public static void main(String[] args) {

        Pessoa pessoa = new Pessoa( "Maiara");
        pessoa.setSobrenome("Alves");
        pessoa.setEmail("mama@hotmail.com");
        pessoa.setIdade(24);
        System.out.println(pessoa.toString());


        Pessoa pessoa2 = new Pessoa ("Julia");
        pessoa2.setSobrenome("Rios");
        pessoa2.setEmail("juju@hotmail.com");
        pessoa2.setIdade(20);
        System.out.println(pessoa2.toString());

        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(pessoa);
        pessoas.add(pessoa2);

        for (Pessoa item : pessoas) {
            System.out.println(item.getNome());
        }


    }
}











//        String sobrenome = "Alves";

//        List<String> numerais = new ArrayList<>();
//        numerais.add(meuNome);
//        numerais.add(sobrenome);
//        numerais.add("Posição 2");

//        String meuNome = "Maiara";
//        String sobrenome = "Alves";
//        String espaco = " ";
//        int idade = 24;
//        double preco = 25.30;



//        for (int i = 0; i < numerais.size(); i++) {
//            System.out.println(i);
//        }

//      for (String item : numerais) {
//            System.out.println(item);
//    }


//        for (int i = 0; i <= 100; i++) {
//
//            int valor = (i % 2);

//            if (valor == 0) {
//                System.out.println(i + " é par");
//            } else {
//                System.out.println(i + " é impar");
//            }
//        }



//    public static double soma(double valor1, double valor2){
//        return valor1 + valor2;
//    }


//            if ((i % 2) != 0) {
//                System.out.println(i);
//            }







//        System.out.println(meuNome+espaco+sobrenome);
//        System.out.println("idade: "+idade);
//        System.out.println(Preço: "+preco);

//        double preco1 = 10.00;
//        double preco2 = 20.00;

//        double total = soma(preco1, preco2);


//        System.out.println("Total: "+total);

//        System.out.println(meuNome);
//        meuNome= "Julia";
//        System.out.println(meuNome);





