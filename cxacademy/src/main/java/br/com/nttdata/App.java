package br.com.nttdata;

import br.com.nttdata.models.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main (String[] args) {


        Pessoa person = new Pessoa("Leandro");
        person.setLastName("Rowling");
        person.setEmail("teste@gmail.com");
        person.setAge(19);
        System.out.println(person.toString());

        Pessoa person2 = new Pessoa("Lucas");
        person2.setLastName("Vinular");
        person2.setEmail("teste2@gmail.com");
        person2.setAge(51);
        System.out.println(person2.toString());



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
