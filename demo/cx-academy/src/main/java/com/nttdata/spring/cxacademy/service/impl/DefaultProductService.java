package com.nttdata.spring.cxacademy.service.impl;

import com.nttdata.spring.cxacademy.dao.ProductDao;
import com.nttdata.spring.cxacademy.model.ProductModel;
import com.nttdata.spring.cxacademy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DefaultProductService implements ProductService {

    @Autowired // vai abrir product dao qndo abrir product service
    private ProductDao productDao;

    //implementa os metodos da interface
    @Override
    public List<ProductModel> getALLProducts() {
        return productDao.findAll();
    }

    @Override
    public void saveProduct(ProductModel product) {

    }

    @Override
    public ProductModel getProductByCode(Integer productCode) {
        return null;
    }

    @Override
    public void deleteProduct(Integer productCode) {

    }
}
