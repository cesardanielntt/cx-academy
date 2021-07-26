/*package br.com.nttdata;

import br.com.nttdata.models.Pessoa;
import br.com.nttdata.models.PessoaFisica;
import br.com.nttdata.models.PessoaJuridica;

import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD:java/src/main/java/br/com/nttdata/App.java
//public class App {
//    final static String meuNome = "Onilson";
//
//    public static void main(String[] args) {
//
//        PessoaFisica pessoa = new PessoaFisica();
//        pessoa.setNome("Onilson");
//        pessoa.setSobrenome("Cardoso");
//        pessoa.setEmail("onilson@gmail.com");
//        pessoa.setIdade(33);
//
//        PessoaFisica pessoa2 = new PessoaFisica();
//        pessoa2.setNome("Maria");
//        pessoa2.setSobrenome("Maia");
//        pessoa2.setEmail("teste@teste.com");
//        pessoa2.setIdade(50);
//
//        PessoaJuridica pj1 = new PessoaJuridica();
//        pj1.setNome("teste");
//        pj1.setEmail("teste1@teste.com");
//        pj1.setCnpj("53.178.531/0001-35");
//
//        List<Pessoa> pessoas = new ArrayList<>();
//        pessoas.add(pessoa);
//        pessoas.add(pessoa2);
//        pessoas.add(pj1);
//
//        for (Pessoa item : pessoas) {
//            if(item instanceof PessoaFisica){
//                System.out.println(((PessoaFisica) item).getSobrenome());
//            }else if(item instanceof PessoaJuridica){
//                System.out.println(((PessoaJuridica) item).getCnpj());
//            }
//        }
//
//
//        //fors();
//    }
//
//
//    public static double soma(double valor1, double valor2) {
//        return valor1 + valor2;
//    }
//
//    public static void fors() {
//        String sobrenome = "Cardoso";
//
//        List<String> numerais = new ArrayList<>();
//        numerais.add(meuNome);
//        numerais.add(sobrenome);
//        numerais.add("Posição 2");
//
//        for (int i = 0; i < numerais.size(); i++) {
//            System.out.println(i);
//        }
//
//        for (String item : numerais) {
//            System.out.println(item);
//        }
//
//        for (int i = 0; i <= 100; i++) {
//
//            int valor = (i % 2);
//
//            if (valor == 0) {
//                System.out.println(i + " é par");
//            } else {
//                System.out.println(i + " é ímpar");
//            }
//        }
//    }
//
//}
=======
public class App {
    final static String meuNome = "Douglas";

    public static void main(String[] args) {

        PessoaFisica pessoa = new PessoaFisica ();
        pessoa.setEmail("teste@teste.com");
        pessoa.setIdade(29);
        pessoa.setSobrenome("Alves");
        pessoa.setNome("Lucas");

        PessoaFisica pessoa2 = new PessoaFisica();
        pessoa2.setIdade(19);
        pessoa2.setSobrenome("Melo");
        pessoa2.setEmail("matheusmelo@gmail.com");
        pessoa2.setNome("Matheus");

        PessoaJuridica pj1 = new PessoaJuridica();
        pj1.setNome("Pessoa Juridica");
        pj1.setEmail("pj@teste.com");
        pj1.setCnpj("53.414134.14314/01111-35");

        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(pessoa);
        pessoas.add(pessoa2);
        pessoas.add(pj1);

        for(Pessoa item: pessoas){
            if(item instanceof PessoaFisica){
                System.out.println(((PessoaFisica) item) .getSobrenome());
            }else if(item instanceof PessoaJuridica){
                System.out.println(((PessoaJuridica) item) .getCnpj());
            }
        }

        //fors();
    }


















    public static double soma(double valor1, double valor2) {
        return valor1 + valor2;
    }
    public static void fors() {
        String sobrenome = "Kulik";
        List<String> numerais = new ArrayList<>();
        numerais.add(meuNome);
        numerais.add(sobrenome);
        numerais.add("Posição 2");
        for (int i = 0; i < numerais.size(); i++) {
            System.out.println(i);
        }
        for (String item : numerais) {
            System.out.println(item);
        }
        for (int i = 0; i <= 100; i++) {
            int valor = (i % 2);
            if (valor == 0) {
                System.out.println(i + " é par");
            } else {
                System.out.println(i + " é ímpar");
            }
        }
    }
}
>>>>>>> master:java/DouglasAlmeida/src/main/java/br/com/nttdata/App.java
