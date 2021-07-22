package com.nttdata.spring.cxacademy.facade.impl;


import com.nttdata.spring.cxacademy.data.ProductData;
import com.nttdata.spring.cxacademy.facade.ProductFacade;
import com.nttdata.spring.cxacademy.model.ProductModel;
import com.nttdata.spring.cxacademy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;

@Component
public class DefaultProductFacade implements ProductFacade {

    @Autowired
    private ProductService productService;

    @Override
    public List<ProductData> getALLProducts() {
        List<ProductModel> productModels = productService.getALLProducts();
        List<ProductData> productDatas = new ArrayList<>();

        for(ProductModel product : productModels) {
            ProductData data = convert(product, new ProductData());
            productDatas.add(data);
        }
        return productDatas;
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

    //converte model para data
    private ProductData convert(ProductModel source , ProductData target) {
        target.setCode(source.getCode());
        target.setName(source.getName());
        target.setPrice("R$" + source.getPrice());
        target.setAvaliableOnline(source.isAvaliableOnline());
        return target;
    }

}
