package com.nttdata.academy.service.impl;

import com.nttdata.academy.daos.CarrinhoRepository;
import com.nttdata.academy.models.CarrinhoModel;
import com.nttdata.academy.service.CarrinhoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.lang.Integer;

@Service("carrinhoService")
@Transactional
public class DefaultCarrinhoService implements CarrinhoService {

    private static final Logger LOG = LogManager.getLogger(DefaultCarrinhoService.class);

    private CarrinhoRepository carrinhoRepository;

    @Autowired
    public DefaultCarrinhoService(CarrinhoRepository carrinhoRepository) {
        this.carrinhoRepository = carrinhoRepository;
    }

    @Override
    public CarrinhoModel criar(CarrinhoModel carrinho) {

        LOG.debug(carrinho);
        System.out.println("Carrinho adicionado ao banco!");

        return carrinhoRepository.save(carrinho);

    }

    @Override
    public List<CarrinhoModel> listar() {

        System.out.println("Pegando os carrinhos do banco...");

        return carrinhoRepository.findAll();

    }

    @Override
    public List<CarrinhoModel> consultar(Integer id) {

        System.out.println("Pegando os carrinhos do banco...");

        return carrinhoRepository.findAllById(Collections.singleton(id));

    }

    @Override
    public CarrinhoModel atualizar(CarrinhoModel carrinho, Integer id){

        System.out.println("Atualizando carrinho...");

        carrinho.setId(id);

        carrinhoRepository.save(carrinho);

        return carrinho;
    }

    @Override
    public void deletar(Integer id){

        carrinhoRepository.removeCarrinhoModelById(id);
    }


}
