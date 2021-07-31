package com.nttdata.academy.service.impl;

import com.nttdata.academy.dao.ClienteDAO;
import com.nttdata.academy.dao.PrecoDAO;
import com.nttdata.academy.dao.ProdutoDAO;
import com.nttdata.academy.model.CarrinhoModel;
import com.nttdata.academy.model.ClienteModel;
import com.nttdata.academy.model.PrecoModel;
import com.nttdata.academy.model.ProdutoModel;
import com.nttdata.academy.service.ModelMapperService;
import com.nttdata.academy.service.PrecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class DefaultPrecoService implements PrecoService {

    @Autowired
    private ModelMapperService modelMapperService;

    @Autowired
    private PrecoDAO precoDAO;

    @Autowired
    private ProdutoDAO produtoDAO;

    @Autowired
    private ClienteDAO clienteDAO;

    @Override
    public PrecoModel savePreco(PrecoModel preco) {
        if (preco != null) {

            ClienteModel cliente = clienteDAO.getById(preco.getCliente().getId());

            ProdutoModel produto = produtoDAO.getById(preco.getProduto().getId());

            preco.setProduto(produto);

            preco.setCliente(cliente);

            return precoDAO.save(preco);
        }
        return null;
    }

    @Override
    public List<PrecoModel> getPrecoByCliente(Integer id) {
        return precoDAO.getPrecoByCliente(id);
    }
}
