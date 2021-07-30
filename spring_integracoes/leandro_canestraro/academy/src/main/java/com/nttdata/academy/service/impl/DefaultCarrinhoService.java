package com.nttdata.academy.service.impl;

import com.nttdata.academy.dao.CarrinhoDAO;
import com.nttdata.academy.dao.ClienteDAO;
import com.nttdata.academy.dao.PrecoDAO;
import com.nttdata.academy.dao.ProdutoDAO;
import com.nttdata.academy.model.CarrinhoModel;
import com.nttdata.academy.model.ItemModel;
import com.nttdata.academy.service.CarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class DefaultCarrinhoService implements CarrinhoService {

    private Double total = 0.0;

    @Autowired
    private CarrinhoDAO carrinhoDAO;

    @Autowired
    private PrecoDAO precoDAO;

    @Autowired
    private ClienteDAO clienteDAO;

    @Autowired
    private ProdutoDAO produtoDAO;


    @Override
    public CarrinhoModel saveToCart(CarrinhoModel source) {
        if (source != null) {

            for (ItemModel item : source.getItems()) {

                Integer clienteId = item.getCliente().getId();
                Integer produtoId = item.getProduto().getId();

                item.setPreco(precoDAO.getPrecoByClienteAndProduto(clienteId, produtoId));

                item.setCliente(clienteDAO.getById(clienteId));

                item.setProduto(produtoDAO.getById(produtoId));

                item.setTotal(item.getQuantidade()*item.getPreco().getValor());

                total += item.getTotal();
            }
            source.setTotal(total);
            return carrinhoDAO.save(source);
        }
        return null;
    }
}
