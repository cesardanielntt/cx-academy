package com.nttdata.academy.facade.impl;

import com.nttdata.academy.controller.ClienteController;
import com.nttdata.academy.dto.CarrinhoDTO;
import com.nttdata.academy.dto.ItemDTO;
import com.nttdata.academy.dto.ProdutoDTO;
import com.nttdata.academy.facade.CarrinhoFacade;
import com.nttdata.academy.models.CarrinhoModel;
import com.nttdata.academy.models.ClienteModel;
import com.nttdata.academy.models.ItemModel;
import com.nttdata.academy.models.ProdutoModel;
import com.nttdata.academy.populators.CarrinhoPopulator;
import com.nttdata.academy.populators.ProdutoPopulator;
import com.nttdata.academy.service.CarrinhoService;
import com.nttdata.academy.service.ProdutoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("carrinhoFacade")
public class DefaultCarrinhoFacade implements CarrinhoFacade {
    private static final Logger LOG = LogManager.getLogger(ClienteController.class);

    @Autowired
    public CarrinhoPopulator carrinhoPopulator;

    @Autowired
    private CarrinhoService carrinhoService;

    @Override
    public CarrinhoDTO adicionar(CarrinhoDTO carrinhoDTO) {
        CarrinhoModel carrinho = carrinhoPopulator.populateCarrinhoModel(carrinhoDTO);

        carrinho = carrinhoService.adicionar(carrinho);

        carrinhoDTO = carrinhoPopulator.populateCarrinhoDTO(carrinho);

        return carrinhoDTO;
    }

    @Override
    public ResponseEntity<Optional<CarrinhoModel>> listar(Integer id) {

        Optional<CarrinhoModel> carrinho = carrinhoService.listar(id);;


        return ResponseEntity.ok().body(carrinho);
    }

    @Override
    public ResponseEntity<CarrinhoDTO> atualizar(CarrinhoDTO carrinhoDTO, Integer id) {

        CarrinhoModel carrinho = carrinhoPopulator.populateCarrinhoModel(carrinhoDTO);

        carrinho = carrinhoService.atualizar(carrinho, id);

        carrinhoDTO = carrinhoPopulator.populateCarrinhoDTO(carrinho);

        return ResponseEntity.ok().body(carrinhoDTO);
    }
}
