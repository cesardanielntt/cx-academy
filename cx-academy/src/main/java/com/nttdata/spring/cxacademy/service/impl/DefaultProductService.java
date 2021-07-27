package com.nttdata.spring.cxacademy.service.impl;

import com.nttdata.spring.cxacademy.dao.ProductDao;
import com.nttdata.spring.cxacademy.model.ProductModel;
import com.nttdata.spring.cxacademy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

<<<<<<< HEAD

=======
>>>>>>> master
@Component
public class DefaultProductService implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<ProductModel> getAllProducts() {
<<<<<<< HEAD

=======
>>>>>>> master
        return productDao.findAll();
    }

    @Override
    public void saveProduct(ProductModel product) {
        if (product != null) {
            productDao.save(product);
<<<<<<< HEAD

        }
=======
        }

>>>>>>> master
    }

    @Override
    public ProductModel getProductByCode(Integer productCode) {
<<<<<<< HEAD
        if (productCode != null) {
            Optional<ProductModel> model = productDao.findById(productCode);
            return model.orElse(null);

=======
        if (productCode != null){
            Optional<ProductModel> model = productDao.findById(productCode);
            return model.orElse(null);
>>>>>>> master
        }

        return null;
    }

    @Override
    public void deleteProduct(Integer productCode) {
        productDao.deleteById(productCode);
<<<<<<< HEAD
    }
}
=======

    }

    @Override
    public List<ProductModel> getOnlineProducts() {
        return productDao.findAllByAvailableOnlineIsTrue();
    }
}
>>>>>>> master
