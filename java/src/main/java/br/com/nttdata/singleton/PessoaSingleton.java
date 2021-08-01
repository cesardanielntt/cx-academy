package br.com.nttdata.singleton;

import br.com.nttdata.models.PessoaFisica;

<<<<<<< HEAD
=======

>>>>>>> master
import java.util.ArrayList;
import java.util.List;

public class PessoaSingleton {
    private static PessoaSingleton instance;
    private List<PessoaFisica> data;

<<<<<<< HEAD
    public static PessoaSingleton getInstance() {
        if (instance == null) {
=======
    public static PessoaSingleton getInstance(){
        if (instance == null){
>>>>>>> master
            instance = new PessoaSingleton();
        }

        return instance;
    }

    public PessoaSingleton(){
        data = new ArrayList<>();
<<<<<<< HEAD
=======

    }

    public static void setInstance(PessoaSingleton instance) {
        instance = instance;
>>>>>>> master
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
>>>>>>> master
