package com.nttdata.spring.cxacademy.facade;

import com.nttdata.spring.cxacademy.data.ProductData;
import com.nttdata.spring.cxacademy.model.ProductModel;
import com.nttdata.spring.cxacademy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DefaultProductsFacade implements ProductFacade{

    @Autowired
    private ProductService productService;

    @Override
    public List<ProductData> getAllProduts() {
        List<ProductModel> productModels = productService.getAllProduts();
        List<ProductData> productDatas = new ArrayList<>();

        for(ProductModel product: productModels){
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

    private ProductData convert(ProductModel source, ProductData target){
        target.setCode(source.getCode());
        target.setName(source.getNome());
        target.setPrice("R$ " + source.getPrice());
        target.setAvailableOnline(source.isAvailableOnline());
        return target;
    }
}
