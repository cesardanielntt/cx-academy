package com.nttdata.spring.facade;

import com.nttdata.spring.data.ProductData;

import java.util.List;

public interface ProductFacade {

    List<ProductData> getAllProducts();

    void saveProduct(ProductData product);

    ProductData getProductByCode(final Integer productCode);

    void deleteProduct(final Integer productCode);
}
