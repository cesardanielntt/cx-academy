package com.nttdata.spring.cxacademy.facade.impl;

import com.nttdata.spring.cxacademy.data.ProductData;
import com.nttdata.spring.cxacademy.facade.ProductFacade;
import com.nttdata.spring.cxacademy.model.ProductModel;
import com.nttdata.spring.cxacademy.service.ProductService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DefaultProductFacade implements ProductFacade {

    @Autowired
    private ProductService productService;

    @Override
    public List<ProductData> getAllProducts() {
        List<ProductModel> products = productService.getAllProducts();
        if (CollectionUtils.isNotEmpty(products)) {
            return products.stream().map(product -> convert(product, new ProductData())).collect(Collectors.toList());
        }

        return Collections.emptyList();
    }

    @Override
    public void saveProduct(ProductData product) {
        ProductModel productModel = reverseConvert(product, new ProductModel());
        productService.saveProduct(productModel);
    }

    @Override
    public ProductData getProductByCode(Integer productCode) {
        ProductModel product = productService.getProductByCode(productCode);
        if (product != null) {
            return convert(product, new ProductData());
        }

        return null;
    }

    @Override
    public void deleteProduct(Integer productCode) {
        productService.deleteProduct(productCode);
    }

    private ProductModel reverseConvert(ProductData source, ProductModel target) {
        target.setCode(source.getCode());
        target.setName(source.getName());
        target.setPrice(source.getPrice());
        target.setAvailableOnline(source.isAvailableOnline());
        return target;
    }

    private ProductData convert(ProductModel source, ProductData target) {
        target.setCode(source.getCode());
        target.setName(source.getName());
        target.setPrice(source.getPrice());
        target.setAvailableOnline(source.isAvailableOnline());
        return target;
    }
}