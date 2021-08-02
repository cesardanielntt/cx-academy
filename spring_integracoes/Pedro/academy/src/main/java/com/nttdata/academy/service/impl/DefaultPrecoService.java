package com.nttdata.academy.service.impl;

import com.nttdata.academy.daos.PrecoRepository;
import com.nttdata.academy.models.PrecoModel;
import com.nttdata.academy.service.PrecoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service("precoService")
public class DefaultPrecoService implements PrecoService {

    private static final Logger LOG = LogManager.getLogger(DefaultPrecoService.class);

    private PrecoRepository precoRepository;

    @Autowired
    public DefaultPrecoService(PrecoRepository precoRepository) {
        this.precoRepository = precoRepository;
    }

    @Override
    public PrecoModel adicionar(PrecoModel preco) {

        LOG.debug(preco);
        System.out.println("Adicionando preco ao banco...");
        return precoRepository.save(preco);

    }

    public PrecoModel atualizar(PrecoModel preco, Integer id){

        System.out.println("Atualizando preco...");

        preco.setId(id);

        precoRepository.save(preco);

        return preco;
    }

    @Override
    public List<PrecoModel> listar(){

        System.out.println("Pegando os precos do banco...");

        return precoRepository.findAll();

    }

    @Override
    public List<PrecoModel> consultar(Integer id) {

        System.out.println("Pegando os precos do banco...");

        return precoRepository.findAllById(Collections.singleton(id));

    }

    @Override
    public void deletar(Integer id){

        precoRepository.removePrecoModelById(id);
    }

}
