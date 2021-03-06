package com.nttdata.academy.facade.impl;

import com.nttdata.academy.dto.CarrinhoDTO;
import com.nttdata.academy.facade.CarrinhoFacade;
import com.nttdata.academy.model.CarrinhoModel;
import com.nttdata.academy.populator.CarrinhoPopulator;
import com.nttdata.academy.service.CarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("carrinhoFacade")
public class DefaultCarrinhoFacade implements CarrinhoFacade {

    @Autowired
    private CarrinhoService carrinhoService;

    @Autowired
    private CarrinhoPopulator carrinhoPopulator;

    @Override
    public CarrinhoDTO adicionar(CarrinhoDTO source) {
        CarrinhoModel target = carrinhoService
                .saveToCart(carrinhoPopulator
                        .populateCarrinhoModel(source));

        source = carrinhoPopulator.populateCarrinhoDTO(target);

        return source;
    }

    @Override
    public List<CarrinhoDTO> getCarrinhoByCliente(Integer clienteId) {
        List<CarrinhoModel> carrinhos = carrinhoService.getCarrinhoByCliente(clienteId);

        List<CarrinhoDTO> target = new ArrayList<>();

        for (CarrinhoModel e : carrinhos) {
            target.add(carrinhoPopulator.populateCarrinhoDTO(e));
        }

        return target;
    }
}
