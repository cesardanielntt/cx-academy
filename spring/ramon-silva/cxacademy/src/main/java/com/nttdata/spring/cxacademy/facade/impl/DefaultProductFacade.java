package com.nttdata.spring.cxacademy.facade.impl;

import com.nttdata.spring.cxacademy.dao.ProductDao;
import com.nttdata.spring.cxacademy.data.ProductData;
import com.nttdata.spring.cxacademy.facade.ProductFacade;
import com.nttdata.spring.cxacademy.model.ProductModel;
import com.nttdata.spring.cxacademy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class DefaultProductFacade implements ProductFacade {

    @Autowired
    private ProductService productService;

    @Override
    public List<ProductData> getAllProducts() {

        List<ProductModel> productModels = productService.getAllProducts();
        List<ProductData> productDatas = new ArrayList<>();

        for (ProductModel product : productModels) {
            ProductData data = convert(product, new ProductData());
            productDatas.add(data);
        }

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

    private ProductData convert(ProductModel source, ProductData target) {
        target.setCode(source.getCode());
        target.setName(source.getName());
        target.setPrice("R$" + source.getPrice());
        target.setAvaliableOnline(source.getAvaliableOnline());
        return target;
    }

}