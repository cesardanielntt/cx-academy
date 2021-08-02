package com.nttdata.academy.facade.impl;

import com.nttdata.academy.dto.*;
import com.nttdata.academy.dto.CarrinhoDTO;
import com.nttdata.academy.dto.CarrinhoDTO;
import com.nttdata.academy.facade.CarrinhoFacade;
import com.nttdata.academy.models.CarrinhoModel;
import com.nttdata.academy.models.CarrinhoModel;
import com.nttdata.academy.models.CarrinhoModel;
import com.nttdata.academy.models.PrecoModel;
import com.nttdata.academy.populators.CarrinhoPopulator;
import com.nttdata.academy.service.CarrinhoService;
import com.nttdata.academy.service.PrecoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("carrinhoFacade")
public class DefaultCarrinhoFacade implements CarrinhoFacade {

    private static final Logger LOG = LogManager.getLogger(DefaultCarrinhoFacade.class);

    @Autowired
    private CarrinhoPopulator carrinhoPopulator;

    @Autowired
    private CarrinhoService carrinhoService;

    @Autowired
    private PrecoService precoService;

    @Override
    public ResponseEntity criar(CarrinhoDTO carrinhoDTO) {

        List<ItemDTO> items = carrinhoDTO.getItems();

        Double totalCarrinho = 0.0;

        for(ItemDTO item: items){
            List<PrecoModel> precos = precoService.consultar(item.getPrecoId());

            Double valor = 0.0;

            if(precos.size() == 1) valor = precos.get(0).getValor(); // Só vai existir um preço para cada cliente e produto

            item.setTotal(valor * item.getQuantidade());

            totalCarrinho += item.getTotal();
        }

        carrinhoDTO.setTotal(totalCarrinho);

        LOG.debug(carrinhoDTO);

        CarrinhoModel carrinho = carrinhoPopulator.populateCarrinhoModel(carrinhoDTO);

        carrinho = carrinhoService.criar(carrinho);

        carrinhoDTO = carrinhoPopulator.populateCarrinhoDto(carrinho);

        LOG.debug(carrinhoDTO);

        return ResponseEntity.ok().body(carrinhoDTO);

    }

    @Override
    public List<CarrinhoDTO> listar(){

        List<CarrinhoModel> carrinhoModels = carrinhoService.listar(); // returns List<CarrinhoModel>

        List<CarrinhoDTO> carrinhosDTO = new ArrayList<>();

        for(CarrinhoModel carrinho: carrinhoModels){
            carrinhosDTO.add(carrinhoPopulator.populateCarrinhoDto(carrinho));
        }

        return carrinhosDTO;
    }

    public CarrinhoDTO consultar(Integer id){
        List<CarrinhoModel> carrinhoModels = carrinhoService.consultar(id); // returns List<CarrinhoModel>

        List<CarrinhoDTO> carrinhosDTO = new ArrayList<>();

        for(CarrinhoModel carrinho: carrinhoModels){
            carrinhosDTO.add(carrinhoPopulator.populateCarrinhoDto(carrinho));
        }

        CarrinhoDTO carrinho = new CarrinhoDTO();

        if(carrinhosDTO.size() > 0 ) carrinho = carrinhosDTO.get(0);

        return carrinho;
    }

    @Override
    public ResponseEntity atualizar(CarrinhoDTO carrinho, Integer id){

        CarrinhoModel carrinhoModel = carrinhoPopulator.populateCarrinhoModel(carrinho);

        return ResponseEntity.ok().body(carrinhoService.atualizar(carrinhoModel, id));
    }

    @Override
    public void deletar(Integer id){

        carrinhoService.deletar(id);

    }

}