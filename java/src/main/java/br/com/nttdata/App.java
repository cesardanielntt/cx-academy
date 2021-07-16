package br.com.nttdata;
import br.com.nttdata.models.Pessoa;
import java.util.ArrayList;
import java.util.List;

public class App {
    final static String meuNome = "Teilor";
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa("Teilor");
        pessoa.setSobrenome("Miotto");
        pessoa.setEmail("teilor_miotto@hotmail.com");
        pessoa.setIdade(24);
        System.out.println(pessoa.toString());

        Pessoa pessoa2 = new Pessoa("Cleber");
        pessoa2.setSobrenome("Teste");
        pessoa2.setEmail("teste@teste.com");
        pessoa2.setIdade(99);
        System.out.println(pessoa2.toString());

        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(pessoa);
        pessoas.add(pessoa2);

        for (Pessoa item : pessoas){
            System.out.println(item.getNome());
        }

        //fors();
    }

    public static double soma(double valor1, double valor2) {
        return valor1 + valor2;
    }
    public static void fors() {
        String sobrenome = "Miotto";
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