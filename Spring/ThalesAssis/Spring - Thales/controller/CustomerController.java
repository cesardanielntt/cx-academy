package com.nttdata.spring.cxacademy.controller;


import com.nttdata.spring.cxacademy.data.CustomerData;
import com.nttdata.spring.cxacademy.facade.CustomerFacade;
import com.nttdata.spring.cxacademy.form.CustomerForm;
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
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerFacade customerFacade;

    @GetMapping
    public String getCustomers(Model model) {
        model.addAttribute("customers", customerFacade.getAllCustomers());
        return "customerPage";
    }
    @PostMapping("/create")
    public String create(CustomerForm customerForm, RedirectAttributes redirectAttributes){
        if (customerForm.getName().isEmpty()){
            redirectAttributes.addFlashAttribute("error", "O nome do cliente é obrigatorio! ");
            return "redirect:/customers";
        }
        customerFacade.saveCustomer(convert(customerForm));
        redirectAttributes.addFlashAttribute("success", "Cliente salvo com sucesso!");
        return "redirect:/customers";
    }
    @GetMapping(value = "/edit")
    public String editCustomer(@RequestParam Integer code, Model model, RedirectAttributes redirectAttributes) {
        CustomerData customer = customerFacade.getCustomerByCode(code);

        if (customer != null) {
            model.addAttribute("customer", customer);
            return "customerEditPage";
        }

        redirectAttributes.addFlashAttribute("error", "Cliente não encontrado");
        return "redirect:/customers";

    }
    @PostMapping("/edit")
    public String editCustomer(CustomerForm customerForm, RedirectAttributes redirectAttributes){
        if (customerForm.getName().isEmpty()){
            redirectAttributes.addFlashAttribute("error", "O nome do cliente é obrigatorio! ");
            return "redirect:/customers";
        }
        customerFacade.saveCustomer(convert(customerForm));
        redirectAttributes.addFlashAttribute("succes", "Cliente salvo com sucesso!");
        return "redirect:/costumers";
    }
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes) {
        try {
            customerFacade.deleteCustomer(id);
            redirectAttributes.addFlashAttribute("success", "Customer deleted successfully");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error to delete Customer");
        }
        return "redirect:/customers";
    }
    private CustomerData convert(CustomerForm form){
        CustomerData data = new CustomerData();
        data.setCode(form.getCode());
        data.setName(form.getName());
        data.setSobrenome(form.getSobrenome());
        data.setEmail(form.getEmail());
        data.setRua(form.getRua());
        data.setNumero(form.getNumero());
        data.setComplemento(form.getComplemento());
        data.setCep(form.getCep());
        data.setCidade(form.getCidade());
        data.setEstado(form.getEstado());


        return data;

    }

}
