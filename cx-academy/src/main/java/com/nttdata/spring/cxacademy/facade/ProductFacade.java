package com.nttdata.spring.cxacademy.facade;

import com.nttdata.spring.cxacademy.data.ProductData;
<<<<<<< HEAD
=======

>>>>>>> master
import java.util.List;

public interface ProductFacade {

<<<<<<< HEAD
    List<ProductData> getAllProducts();

=======
>>>>>>> master
    void saveProduct(ProductData product);

    ProductData getProductByCode(Integer productCode);

    void deleteProduct(Integer productCode);
<<<<<<< HEAD
=======

    List<ProductData> getOnlineProducts();
>>>>>>> master
}
