package com.nttdata.spring.cxacademy.facade;

import com.nttdata.spring.cxacademy.data.ProductData;

import java.util.List;

public interface ProductFacade {

    List<ProductData> getAllProducts();

    void saveProduct(ProductData product);

    ProductData getProductByCode(Integer productCode);

    void deleteProduct(Integer productCode);

    List<ProductData> getOnlineProducts();

}
