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

@Controller
@RequestMapping("/products")// similar ao Path
public class ProductController {

    @Autowired
    private ProductFacade productFacade;

//    @GetMapping
//    public String getProducts(Model model) {//retorna os dados para o front
//        model.addAttribute("products",productFacade.getALLProducts());
//        return "productPage";
//    }

    @GetMapping
    public String getProductsOnline(Model model) {
        model.addAttribute("products",productFacade.getProductsOnline());
        return "productPage";
    }


    @PostMapping("/create")
    public String create(ProductForm productForm, RedirectAttributes redirectAttributes) {
        if (productForm.getName().isEmpty()){//se o nome do product form for vazio
            redirectAttributes.addFlashAttribute("error", "O nome do produto é obrigatóriro!");
            return "redirect:/products";
        }

        productFacade.saveProduct(convert(productForm));
        redirectAttributes.addFlashAttribute("success", "Produto salvo com sucesso!");
        return "redirect:/products";
    }

    @GetMapping(value = "/edit")
    public String editProduct(@RequestParam Integer code, Model model, RedirectAttributes redirectAttributes){
        ProductData product = productFacade.getProductByCode(code);
        //vai buscar o produto no BD através do código

        if(product != null) {
            model.addAttribute("product", product);
            return "productEditPage";
        }
        redirectAttributes.addFlashAttribute("error", "produto não encontrado");
        return "redirect:/products";
    }

    @PostMapping("/edit")
    public String editProduct(ProductForm productForm, RedirectAttributes redirectAttributes) {
        if (productForm.getName().isEmpty()){//se o nome do product form for vazio
            redirectAttributes.addFlashAttribute("error", "O nome do produto é obrigatóriro!");
            return "redirect:/products";
        }

        productFacade.saveProduct(convert(productForm));
        redirectAttributes.addFlashAttribute("success", "Produto salvo com sucesso!");
        return "redirect:/products";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes) {
        try { //se durante a execução der algum erro,o catch vai retornar a mensagem de erro
            productFacade.deleteProduct(id);
            redirectAttributes.addFlashAttribute("success", "Product deleted successfully");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error to delete Product");
        }
        return "redirect:/products";
    }

    //converte um dado form vindo do front para um data para o back reconhecer
    private ProductData convert(ProductForm form) {
        ProductData data = new ProductData();
        data.setCode(form.getCode());
        data.setName(form.getName());
        data.setPrice(form.getPrice());
        data.setAvaliableOnline(form.isAvaliableOnline());

        return data;
    }

}
