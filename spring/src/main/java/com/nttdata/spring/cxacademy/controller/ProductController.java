package com.nttdata.spring.cxacademy.controller;


import com.nttdata.spring.cxacademy.facade.ProductFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductFacade productFacade;

    @GetMapping
    public String getProducts(Model model){
        model.addAttribute("products", productFacade.getAllProducts());
        return "productPage";
    }
}
