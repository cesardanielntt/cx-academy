package com.nttdata.spring.cxacademy.controller;


import com.nttdata.spring.cxacademy.data.ProductData;
import com.nttdata.spring.cxacademy.facade.ProductFacade;
import com.nttdata.spring.cxacademy.form.ProductForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductFacade productFacade;


    @GetMapping
    public String getProducts(Model model) {
        model.addAttribute("products", productFacade.getAllProducts());
        return "productPage";

    }

    @PostMapping("/create")
    public String create(ProductForm productForm, RedirectAttributes redirectAttributes) {
        if (productForm.getName().isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "O nome é obrigatório");
            return "redirect:/products";

        }

        productFacade.saveProduct(convert(productForm));
        redirectAttributes.addFlashAttribute("success", "Produto salvo com sucesso");
        return "redirect:/products";
    }

    @GetMapping(value = "/edit")
    public String editProduct(@RequestParam Integer code, Model model, RedirectAttributes redirectAttributes) {
        ProductData product = productFacade.getProductByCode(code);

        if (product != null) {
            model.addAttribute("product", product);
            return "productEditPage";
        }

        redirectAttributes.addFlashAttribute("error", "Produto não encontrado");
        return "redirect:/products";

    }

    @PostMapping("/edit")
        public String editProduct(ProductForm productForm, RedirectAttributes redirectAttributes) {
        if (productForm.getName().isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "O nome do produto é obrigatório");
            return "redirect:/products";
        }

        productFacade.saveProduct(convert(productForm));
        redirectAttributes.addFlashAttribute("success", "Produto salvo com sucesso");
        return "redirect:/products";

    }

        @PostMapping("/delete/{id}")
        public String delete(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes) {
            try {
                productFacade.deleteProduct(id);
                redirectAttributes.addFlashAttribute("success", "Product deleted successfully");
            } catch (Exception e) {
                redirectAttributes.addFlashAttribute("error", "Error to delete Product");
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





