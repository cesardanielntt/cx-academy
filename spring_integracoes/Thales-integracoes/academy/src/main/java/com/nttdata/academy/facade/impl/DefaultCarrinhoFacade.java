package com.nttdata.academy.facade.impl;


import com.nttdata.academy.dto.CarrinhoDTO;
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
    private static final Logger LOG = LogManager.getLogger(DefaultCarrinhoFacade.class);

    @Autowired
    private CarrinhoPopulator carrinhoPopulator;

    @Autowired
    private CarrinhoService carrinhoService;



    @Override
    public CarrinhoDTO adicionar(CarrinhoDTO carrinhoDTO) {

        LOG.debug(carrinhoDTO);

        CarrinhoModel carrinhoModel = carrinhoPopulator.populateCarrinhoModel(carrinhoDTO);
        carrinhoModel = carrinhoService.adicionar(carrinhoModel);

        carrinhoDTO = carrinhoPopulator.populateCarrinhoDTO(carrinhoModel);
        return carrinhoDTO;


    }
}


