package com.nttdata.spring.cxacademy.service.impl;

import com.nttdata.spring.cxacademy.dao.ProductDao;
import com.nttdata.spring.cxacademy.model.ProductModel;
import com.nttdata.spring.cxacademy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DefaultProductService implements ProductService {

    @Autowired // vai abrir product dao qndo abrir product service
    private ProductDao productDao;

      //implementa os metodos da interface
//    @Override
//    public List<ProductModel> getALLProducts() {
//        return productDao.findAll();
//    }

    @Override
    public List<ProductModel> getProductOnline() {
        return productDao.findAllByAvaliableOnlineIsTrue();
    }

    @Override
    public void saveProduct(ProductModel product) {
        if (product != null) {
            productDao.save(product);
        }
    }

    @Override
    public ProductModel getProductByCode(Integer productCode) {
        if (productCode != null) {
            Optional<ProductModel> model = productDao.findById(productCode);
            return model.orElse(null);
            //se existir algo no model ele retorna, se não existir retorna algo pre determinado
            //no caso retorna nulo
        }
        return null;
    }

    @Override
    public void deleteProduct(Integer productCode) {
        productDao.deleteById(productCode);
    }
}
