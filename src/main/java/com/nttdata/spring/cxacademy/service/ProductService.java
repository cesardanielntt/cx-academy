package com.nttdata.spring.cxacademy.service;

import com.nttdata.spring.cxacademy.model.ProductModel;

import java.util.List;

//interface  é um "contrato" diz o que a classe faz
public interface ProductService {

     //List<ProductModel> getALLProducts();

     List<ProductModel> getProductOnline();

     void saveProduct(ProductModel product);

     ProductModel getProductByCode(Integer productCode);

     void deleteProduct(Integer productCode);

}
