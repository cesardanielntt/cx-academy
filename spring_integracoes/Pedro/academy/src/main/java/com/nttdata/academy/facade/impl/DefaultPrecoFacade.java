package com.nttdata.academy.facade.impl;

import com.nttdata.academy.dto.ClienteDTO;
import com.nttdata.academy.dto.PrecoDTO;
import com.nttdata.academy.dto.ProdutoDTO;
import com.nttdata.academy.facade.ClienteFacade;
import com.nttdata.academy.facade.PrecoFacade;
import com.nttdata.academy.facade.ProdutoFacade;
import com.nttdata.academy.models.ClienteModel;
import com.nttdata.academy.models.PrecoModel;
import com.nttdata.academy.models.ProdutoModel;
import com.nttdata.academy.populators.ClientePopulator;
import com.nttdata.academy.populators.PrecoPopulator;
import com.nttdata.academy.populators.ProdutoPopulator;
import com.nttdata.academy.service.PrecoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("precoFacade")
public class DefaultPrecoFacade implements PrecoFacade {

    private static final Logger LOG = LogManager.getLogger(DefaultPrecoFacade.class);

    @Autowired
    private PrecoPopulator precoPopulator;

    @Autowired
    private ClientePopulator clientePopulator;

    @Autowired
    private ProdutoPopulator produtoPopulator;

    @Autowired
    private PrecoService precoService;

    @Autowired
    private ClienteFacade clienteFacade;

    @Autowired
    private ProdutoFacade produtoFacade;

    @Override
    public ResponseEntity adicionar(PrecoDTO precoDTO) {

        ClienteDTO cliente = clienteFacade.consultar(precoDTO.getIdCliente()); // criando objeto com id solicitado

        ProdutoDTO produto = produtoFacade.consultar(precoDTO.getIdProduto()); // criando objeto com id solicitado

        ClienteModel clienteM = clientePopulator.populateClienteModel(cliente);
        ProdutoModel produtoM = produtoPopulator.populateProdutoModel(produto);

        PrecoModel preco = precoPopulator.populatePrecoModel(precoDTO);

        preco.setCliente(clienteM);
        preco.setProduto(produtoM);

        System.out.println("Antes de chamar produtoService");

        preco = precoService.adicionar(preco);

        System.out.println("Id do preco: " + preco.getId());

        precoDTO = precoPopulator.populatePrecoDto(preco);

        LOG.debug(precoDTO);

        return ResponseEntity.ok().body(precoDTO);

    }

    @Override
    public List<PrecoDTO> listar(){

        List<PrecoModel> precoModels = precoService.listar(); // returns List<PrecoModel>

        List<PrecoDTO> precosDTO = new ArrayList<>();

        for(PrecoModel preco: precoModels){
            precosDTO.add(precoPopulator.populatePrecoDto(preco));
        }

        return precosDTO;
    }

    public PrecoDTO consultar(Integer id){
        List<PrecoModel> precoModels = precoService.consultar(id); // returns List<PrecoModel>

        List<PrecoDTO> precosDTO = new ArrayList<>();

        for(PrecoModel preco: precoModels){
            precosDTO.add(precoPopulator.populatePrecoDto(preco));
        }

        PrecoDTO preco = new PrecoDTO();

        if(precosDTO.size() > 0 ) preco = precosDTO.get(0);

        return preco;
    }

    @Override
    public ResponseEntity atualizar(PrecoDTO preco, Integer id){

        PrecoModel precoModel = precoPopulator.populatePrecoModel(preco);

        PrecoModel precoAtualizado = precoService.atualizar(precoModel, id);

        return ResponseEntity.ok().body(preco);
    }

    @Override
    public void deletar(Integer id){

        precoService.deletar(id);

    }

}