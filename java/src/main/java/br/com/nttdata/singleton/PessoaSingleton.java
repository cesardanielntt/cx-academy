package br.com.nttdata.singleton;

import br.com.nttdata.models.PessoaFisica;

import java.util.ArrayList;
import java.util.List;

public class PessoaSingleton {
    private static PessoaSingleton instance;
    private List<PessoaFisica> data;

    public static PessoaSingleton getInstance() {
<<<<<<< HEAD
        if (instance==null) {
        instance = new PessoaSingleton();
=======
        if (instance == null) {
            instance = new PessoaSingleton();
>>>>>>> origin/master
        }

        return instance;
    }

    public PessoaSingleton(){
        data = new ArrayList<>();
    }

    public List<PessoaFisica> getData() {
        return data;
    }

    public void setData(List<PessoaFisica> data) {
        this.data = data;
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> origin/master
