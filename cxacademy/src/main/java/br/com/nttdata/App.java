package br.com.nttdata;
import br.com.nttdata.models.Pessoa;
import br.com.nttdata.models.PessoaFisica;
import br.com.nttdata.models.PessoaJuridica;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main (String[] args) {


        PessoaFisica person = new PessoaFisica();
        person.setId("1");
        person.setName("Leandro");
        person.setLastName("Rowling");
        person.setEmail("teste@gmail.com");
        person.setCpf("11111111111");
        person.setAge(19);

        PessoaFisica person2 = new PessoaFisica();
        person2.setId("2");
        person2.setName("Mateus");
        person2.setLastName("Vinular");
        person2.setEmail("teste2@gmail.com");
        person2.setCpf("22222222222");
        person2.setAge(51);

        PessoaJuridica person3 = new PessoaJuridica();
        person3.setName("Empresa Boa Mesmo ltda.");
        person3.setCnpj("11111111111111");
        person3.setEmail("hr@empresa.com");
        person3.setId("3");

        List<Pessoa> peopleList = new ArrayList<>();
        peopleList.add(person);
        peopleList.add(person2);
        peopleList.add(person3);

        for(Pessoa item: peopleList){
            if (item instanceof PessoaFisica) {
                System.out.println(((PessoaFisica)item).getLastName());
            }else if(item instanceof PessoaJuridica) {
                System.out.println(((PessoaJuridica)item).getCnpj());
            }
        }



    }

    public static double sumNumbers(double a, double b){
        return a+b;
    }

    public static void forLoops(){
        String nome = "Leandro";
        String lastName = "Canestraro";


        List<String> arrayNum = new ArrayList<>();
        arrayNum.add(nome);
        arrayNum.add(lastName);

        for(int i=0; i<arrayNum.size(); i++){
            System.out.println(arrayNum.get(i));
        }

        for (String item: arrayNum) {
            System.out.println(item);
        }

        for(int i=0; i<100; i++) {
            boolean value = i%2 == 0;
            if (value){
                System.out.println(i+" is even");
            } else {
                System.out.println(i+" is odd");
            }
        }
    }
}
