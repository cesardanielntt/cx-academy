package br.com.nttdata.singleton;

import br.com.nttdata.models.PessoaFisica;
import br.com.nttdata.models.PessoaJuridica;

import java.util.ArrayList;
import java.util.List;

public class EmpresaSingleton {
    private static EmpresaSingleton instance;
    private List<PessoaJuridica> data;


    public static EmpresaSingleton getInstance() {
        if (instance == null) {
            instance = new EmpresaSingleton();
        }

        return instance;
    }

    public EmpresaSingleton() {
        data = new ArrayList<>();
    }

    public List<PessoaJuridica> getData() {
        return data;
    }

    public void setData(List<PessoaJuridica> data) {
        this.data = data;
    }
}

