package br.com.nttdata;

import br.com.nttdata.models.Pessoa;
import br.com.nttdata.models.PessoaFisica;
import br.com.nttdata.models.PessoaJuridica;

import java.util.ArrayList;
import java.util.List;

public class App {

//    static String meuNome = "Leandro";
//    static String sobreNome = "Rocha";

    // metodo de inicialização do projeto
    //declarar um metodo puclico estatico não retorna nada e tem o nome main

    public static void main(String[] args){

        PessoaFisica pessoa = new PessoaFisica();
        pessoa.setNome("Lucas");
        pessoa.setSobreNome("Silva");
        pessoa.setEmail("teste@gmail.com");
        pessoa.setIdade(16);
        //System.out.println(pessoa.toString());

        PessoaFisica pessoa2 = new PessoaFisica();
        pessoa2.setNome("Leandro");
        pessoa2.setSobreNome("Rocha");
        pessoa2.setEmail("leandro.r327@gmail.com");
        pessoa2.setIdade(19);

        PessoaJuridica pj1 = new PessoaJuridica();
        pj1.setNome("Pessoa juridica");
        pj1.setEmail("pj1@teste.com");
        pj1.setCnpj("45.3423.11243.114");

        //criar uma lista de pessoas
        //vai mostrar os campos em comum das classes
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(pessoa);
        pessoas.add(pessoa2);
        pessoas.add(pj1); //adicionou pessoa juridica à lista pesoas

        for (Pessoa item: pessoas){
            System.out.println(item);
            //se o item vier da instancia pessoa fisica
            if(item instanceof PessoaFisica){
                System.out.println(((PessoaFisica) item).getSobreNome());
            }else if(item instanceof PessoaJuridica){
                System.out.println(((PessoaJuridica) item).getCnpj());
            }
        }

    }

    /*
    //metodo publico e estatico que vai retornar um valor double
    public static double soma(double valor1, double valor2){
        return valor1 + valor2;
    }

    soma = +
    subtração = -
    divisão = /
    multiplicação = *
     */

    public static void fors(){
        /*
        //declarar variavel, seu tipo e valor
        //String meuNome = null; variável vazia
        String meuNome = "Leandro";
        String sobreNome = "Rocha";

        //variavel tipo int
        int idade = 19;

        //variavel que recebe numeros decimais
        double preco = 25.30;
        */


        /*
        // na saida do sistema, escrever em uma linha(" ")
        System.out.println(meuNome+" "+sobreNome);
        System.out.println("idade " +idade);
        System.out.println("preco " +preco);
        System.out.println(meuNome);
        meuNome = "Murillo";
        System.out.println(meuNome);
        */


        /*
        double preco1 = 10.00;
        double preco2 = 20.00;
        double total =soma(preco1, preco2);

        System.out.println("preco " +total);
        System.out.println("preco " +soma(preco1, preco2));
        */

        /*
        //criar uma array e adicionar o nome e o sobrenome
        List<String> numerais = new ArrayList<>();
        numerais.add(meuNome);
        numerais.add(sobreNome);
        */

        /*
        //estrutura de repetição
        //iniciar com i =0, terminar qndo i= a quantidade de linhas da array
        for(int i=0; i<numerais.size(); i++){
            //System.out.println(i); mostra o numero da linha
            System.out.print(numerais.get(i)); //mostra o valor da linha i
        }
         */


        /*
        // declara a string item e mandar percorrer o array numerais
        for(String item: numerais){
            if(item.equals("Rocha")){// se o item for igual(equals):
                System.out.println(item);
            }else{// ou então:
                System.out.println(("não é Rocha"));
            }
        }
        */

        /*
        for(int i=1; i<=100; i++){
            if(i%2 ==0){
                System.out.println(i+" é par");
            }else{
                System.out.println(i+" é impar");
            }
        }
        */

        /*
        for(int i=0; i<100; i++){
            if (i<50){
                System.out.println(i);
            }
        }
         */
    }
}















