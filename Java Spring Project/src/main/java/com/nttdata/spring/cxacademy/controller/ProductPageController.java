package com.nttdata.spring.cxacademy.controller;

import com.nttdata.spring.cxacademy.data.ProductData;
import com.nttdata.spring.cxacademy.facade.ProductFacade;
import com.nttdata.spring.cxacademy.form.ProductForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Collections;

@Controller
@RequestMapping("/products")
public class ProductPageController {

    @Autowired
    private ProductFacade productFacade;

    @GetMapping
    public String getProducts(Model model) {
        model.addAttribute("products", productFacade.getAllProducts());
        return "productPage";
    }

    @PostMapping("/create")
    public String create(final ProductForm form, Model model, RedirectAttributes redirectAttributes) {
        if (form == null || form.getName().isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "Erro: Código ou Nome não podem ficar vazios");
            return "redirect:/products";
        }

        productFacade.saveProduct(convert(form));
        redirectAttributes.addFlashAttribute("success", "Produto salvo com sucesso");
        return "redirect:/products";
    }

    @GetMapping(value = "/edit")
    public String editProduct(@RequestParam final Integer code, Model model, RedirectAttributes redirectAttributes) {

        ProductData product = productFacade.getProductByCode(code);

        if (product != null) {
            model.addAttribute("product", product);
            return "productEditPage";
        }

        redirectAttributes.addFlashAttribute("error", "Erro: Código de produto inválido");
        return "redirect:/products";
    }

    @PostMapping(value = "/edit")
    public String editProduct(final ProductForm form, Model model, RedirectAttributes redirectAttributes) {
        if (form == null || form.getName().isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "Erro: Código ou Nome não podem ficar vazios");
            return "redirect:/products";
        }

        productFacade.saveProduct(convert(form));
        redirectAttributes.addFlashAttribute("success", "Produto salvo sucesso");
        return "redirect:/products";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes) {
        try {
            productFacade.deleteProduct(id);
            redirectAttributes.addFlashAttribute("success", "Produto deletado com sucesso");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Erro ao deletar produto");
        }
        return "redirect:/products";
    }

    private ProductData convert(ProductForm form) {
        ProductData data = new ProductData();
        data.setCode(form.getCode());
        data.setName(form.getName());
        data.setPrice(form.getPrice());
        data.setAvailableOnline(form.isAvailableOnline());

        return data;
    }
}