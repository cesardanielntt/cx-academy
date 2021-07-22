package com.nttdata.spring.cxacademy.facade.impl;

import com.nttdata.spring.cxacademy.data.ProductData;
import com.nttdata.spring.cxacademy.facade.ProductFacade;
import com.nttdata.spring.cxacademy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DefaultProductFacade implements ProductFacade {

    @Autowired
    private ProductService productService;

    @Override
    public List<ProductData> getAllProducts() {
        List<>
        return null;
    }

    @Override
    public void saveProduct(ProductData product) {

    }

    @Override
    public ProductData getProductByCode(Integer productCode) {
        return null;
    }

    @Override
    public void deleteProduct(Integer productCode) {

    }
}
