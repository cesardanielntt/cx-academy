package br.com.nttdata;

import br.com.nttdata.models.Pessoa;

import java.awt.peer.SystemTrayPeer;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String args[]) {

        Pessoa p = new Pessoa("Pedro", "Alves", "pedro@gmail.com",21);

        Pessoa p2 = new Pessoa("Lucas", "Oliveira", "lucas@gmail.com", 19);

        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(p);
        pessoas.add(p2);

        for(Pessoa pe: pessoas){
            System.out.println(pe.toString());
        }
    }
}
