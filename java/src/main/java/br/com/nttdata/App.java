package br.com.nttdata;


import java.util.ArrayList;
import java.util.List;
import br.com.nttdata.models.Pessoa;


public class App {
    final static String meuNome = "Douglas";


    public static void main(String[] args){

        Pessoa pessoa = new Pessoa("Douglas");
        pessoa.setSobrenome("Almeida");
        pessoa.setEmail("douglas.almeida02@hotmail.com");
        pessoa.setIdade(24);
        System.out.println(pessoa.toString());


        Pessoa pessoa2 = new Pessoa("Ricardo");
        pessoa.setSobrenome("De Paula");
        pessoa.setEmail("ricardo_de_paula@hotmail.com");
        pessoa.setIdade(32);
        System.out.println(pessoa.toString());

    List<Pessoa> pessoas = new ArrayList<>();
    pessoas.add(pessoa);
    pessoas.add(pessoa2);

    for(Pessoa item: pessoas){
        System.out.println(item.getNome());
    }






   /*  String sobrenome = "Almeida";

        List<String> numerais = new ArrayList<>();
        numerais.add(meuNome);
        numerais.add(sobrenome);
        numerais.add("Posição 2");

//        for(int i = 0; i < numerais.size(); i++){
//            System.out.println(numerais.get(i));
//        }


        for(String item: numerais){
            System.out.println(item);
        }
        for(int i = 0; i<=100;i++){
            int valor = (i % 2);
            if(valor == 0){
                System.out.println(i + " é par");
            }else{
                System.out.println(i + " é ímpar");
            }

        }



       System.out.println(meuNome+" "+sobrenome);
        System.out.println("Idade: "+idade);
       System.out.println("Preço: "+preco);

        double preco1 = 10.00;
       double preco2 = 20.00;

       double total = soma(preco1, preco2);

               System.out.println("Total: "+total);

    }

      public static double soma(double valor1, double valor2){
        return valor1 + valor2;
*/
    }
        }




