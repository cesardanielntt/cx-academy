package com.nttdata.academy.service.impl;

import com.nttdata.academy.daos.ProdutoRepository;
import com.nttdata.academy.models.ItemModel;
import com.nttdata.academy.models.PrecoModel;
import com.nttdata.academy.models.ProdutoModel;
import com.nttdata.academy.service.ProdutoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("produtoService")
public class DefaultProdutoService implements ProdutoService {

    private static final Logger LOG = LogManager.getLogger(ProdutoService.class);

    private ProdutoRepository produtoRepository;

    @Autowired
    public DefaultProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public Optional<ProdutoModel> listar(Integer id) {
        return produtoRepository.findById(id);
    }

    @Override
    public ProdutoModel adicionar(ProdutoModel produto) {

        Integer quantidade;
        Double valor = null;

        for (PrecoModel preco : produto.getPrecos()) {
            valor = preco.getValor();
        }
        for(ItemModel item : produto.getItems()) {
            quantidade = item.getQuantidade();
            
            item.setTotal(valor * quantidade);
        }


        return produtoRepository.save(produto);
    }

    @Override
    public ProdutoModel atualizar(ProdutoModel produto, Integer id) {

        Integer quantidade;
        Double valor = null;

        for (PrecoModel preco : produto.getPrecos()) {
            valor = preco.getValor();
        }
        for(ItemModel item : produto.getItems()) {
            quantidade = item.getQuantidade();

            item.setTotal(valor * quantidade);
        }

        produto.setId(id);

        return produtoRepository.save(produto);
    }

    @Override
    public ProdutoModel deletar(Integer id) {
        produtoRepository.deleteById(id);
        return null;
    }
}
