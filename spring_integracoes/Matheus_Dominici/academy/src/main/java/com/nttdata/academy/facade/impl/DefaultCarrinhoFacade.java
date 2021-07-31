package com.nttdata.academy.facade.impl;

import com.nttdata.academy.dto.CarrinhoDto;
import com.nttdata.academy.facade.CarrinhoFacade;
import com.nttdata.academy.models.CarrinhoModel;
import com.nttdata.academy.populators.CarrinhoPopulator;
import com.nttdata.academy.service.CarrinhoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("carrinhoFacade")
public class DefaultCarrinhoFacade implements CarrinhoFacade {
    private static Logger LOG = LogManager.getLogger(DefaultCarrinhoFacade.class);

    @Autowired
    private CarrinhoPopulator carrinhoPopulator;


    private CarrinhoService carrinhoService;



    @Override
    public CarrinhoDto adicionar(CarrinhoDto carrinhoDto) {
        LOG.debug(carrinhoDto);

        CarrinhoModel carrinho = carrinhoPopulator.populateCarrinhoModel(carrinhoDto);


        carrinho = carrinhoService.adicionar(carrinho);

        carrinhoDto = carrinhoPopulator.populateCarrinhoDto(carrinho);

        return carrinhoDto;
    }
}
