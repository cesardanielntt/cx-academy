package com.nttdata.spring.service;

import com.nttdata.spring.model.ProductModel;

import java.util.List;

public interface ProductService {

    List<ProductModel> getAllProducts();

    void saveProduct(ProductModel product);

    ProductModel getProductByCode(final Integer productCode);

    void deleteProduct(final Integer productCode);
}
