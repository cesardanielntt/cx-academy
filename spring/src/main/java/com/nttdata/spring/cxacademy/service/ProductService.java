package com.nttdata.spring.cxacademy.service;

import com.nttdata.spring.cxacademy.model.ProductModel;

import java.util.List;

public interface ProductService {

    List<ProductModel> getAllProducts();

    void saveProduct(ProductModel product);

    ProductModel getProductByCode(Integer productCode);

    void deleteProduct(Integer productCode);

}
