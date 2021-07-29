package com.nttdata.academy.service.impl;

import com.nttdata.academy.dao.CarrinhoDAO;
import com.nttdata.academy.model.CarrinhoModel;
import com.nttdata.academy.service.CarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class DefaultCarrinhoService implements CarrinhoService {

    @Autowired
    private CarrinhoDAO carrinhoDAO;

    @Override
    public CarrinhoModel saveToCart(CarrinhoModel source) {
        if (source != null) {
            return carrinhoDAO.save(source);
        }
    }
}
