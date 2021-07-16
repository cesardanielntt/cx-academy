package br.com.nttdata;

import br.com.nttdata.models.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class App {
    final static String meuNome = "Lucas";

    public static void main(String[] args) {

        Pessoa pessoa = new Pessoa("Lucas");
        pessoa.setSobrenome("Kulik");
        pessoa.setEmail("lucas.chropacz@nttdata.com");
        pessoa.setIdade(24);

        Pessoa pessoa2 = new Pessoa("Cleber");
        pessoa2.setSobrenome("Teste");
        pessoa2.setEmail("teste@teste.com");
        pessoa2.setIdade(32);

        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(pessoa);
        pessoas.add(pessoa2);

        for (Pessoa item : pessoas) {
            System.out.println(item.getNome());
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
