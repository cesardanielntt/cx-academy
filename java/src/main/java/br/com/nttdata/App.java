package br.com.nttdata;

import br.com.nttdata.models.Pessoa;
import br.com.nttdata.models.PessoaFisica;
import br.com.nttdata.models.PessoaJuridica;
import br.com.nttdata.singleton.PessoaSingleton;

public class App {
    final static String meuNome = "Maiara";

    public static void main(String[] args) {

        PessoaFisica pessoa = new PessoaFisica();
        pessoa.setNome("Maiara");
        pessoa.setSobrenome("Alves");
        pessoa.setEmail("mama@hotmail.com");
        pessoa.setIdade(24);


        PessoaFisica pessoa2 = new PessoaFisica();
        pessoa2.setNome("Julia");
        pessoa2.setSobrenome("Rios");
        pessoa2.setEmail("juju@hotmail.com");
        pessoa2.setIdade(20);

        PessoaSingleton.getInstance().getData().add(pessoa);
        PessoaSingleton.getInstance().getData().add(pessoa2);

        lerPessoas();


    }

    public static void lerPessoas() {
        for (PessoaFisica item : PessoaSingleton.getInstance().getData()) {
            System.out.println(item.getNome());
        }

    }
}































//         PessoaJuridica pj1 = new PessoaJuridica();
//         pj1.setNome("Pessoa Juridica");
//         pj1.setEmail("pj@teste.com");
//         pj1.setCpnj("87.564.987/0001-65");


//         List<Pessoa> pessoas = new ArrayList<>();
//         pessoas.add(pessoa);
//         pessoas.add(pessoa2);
//         pessoas.add(pj1);

//         for (Pessoa item : pessoas) {
//             if(item instanceof PessoaFisica){
//                 System.out.println(((PessoaFisica) item) .getSobrenome());
//             }else if(item instanceof PessoaJuridica){
//                System.out.println(((PessoaJuridica) item) .getCpnj());
//            }
//
//        }














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





