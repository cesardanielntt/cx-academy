package com.nttdata.spring.service.impl;

import com.nttdata.spring.dao.ProductDao;
import com.nttdata.spring.model.ProductModel;
import com.nttdata.spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DefaultProductService implements ProductService {

    @Autowired
    private ProductDao productDao;


    @Override
    public List<ProductModel> getAllProducts() {
        return productDao.findAll();
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
            Optional<ProductModel> productModel = productDao.findById(productCode);
            return productModel.orElse(null);
        }
        return null;
    }

    @Override
    public void deleteProduct(Integer productCode) {
        productDao.deleteById(productCode);
    }
}
