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
import javax.print.attribute.standard.PresentationDirection;

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
    public String create(CustomerForm customerForm, RedirectAttributes redirectAttributes) {
        if (customerForm.getName().isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "O nome é obrigatório");
            return "redirect:/customers";
        }
        if (customerForm.getSurname().isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "O sobrenome é obrigatório");
            return "redirect:/customers";
        }
        if (customerForm.getEmail().isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "O e-mail é obrigatório");
            return "redirect:/customers";
        }
        if (customerForm.getStreet().isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "A rua é obrigatório");
            return "redirect:/customers";
        }
        if (customerForm.getNumber().isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "O número é obrigatório");
            return "redirect:/customers";
        }
        if (customerForm.getComplement().isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "O complemento é obrigatório");
            return "redirect:/customers";
        }
        if (customerForm.getCep().isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "O cep é obrigatório");
            return "redirect:/customers";
        }
        if (customerForm.getCity().isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "A cidade é obrigatório");
            return "redirect:/customers";
        }
        if (customerForm.getState().isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "O Estado é obrigatório");
            return "redirect:/customers";
        }

        customerFacade.saveCustomers(convert(customerForm));
        redirectAttributes.addFlashAttribute("success", "Produto salvo com sucesso!");
        return "redirect:/customers";
    }

    @GetMapping(value = "/edit")
    public String editCustomer(@RequestParam Integer code, Model model, RedirectAttributes redirectAttributes) {
        CustomerData customer = customerFacade.getCustomerByCode(code);

        if (customer != null) {
            model.addAttribute("customer", customer);
            return "customerEditPage";
        }
        redirectAttributes.addFlashAttribute("error", "Nome não encontrado");
        return "redirect:/customers";
    }

    @PostMapping("/edit")
    public String editCustomer(CustomerForm customerForm, RedirectAttributes redirectAttributes){
        if (customerForm.getName().isEmpty()){
            redirectAttributes.addFlashAttribute("error", "O nome é obrigatório");
            return "redirect:/customers";
        }
        customerFacade.saveCustomers(convert(customerForm));
        redirectAttributes.addFlashAttribute("success", "Nome salvo com sucesso!");
        return "redirect:/customers";
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

    private CustomerData convert(CustomerForm form) {
        CustomerData data = new CustomerData();
        data.setCode(form.getCode());
        data.setName(form.getName());
        data.setSurname(form.getSurname());
        data.setEmail(form.getEmail());
        data.setStreet(form.getStreet());
        data.setNumber(form.getNumber());
        data.setComplement(form.getComplement());
        data.setCep(form.getCep());
        data.setCity(form.getCity());
        data.setState(form.getState());
        data.setAvailableOnline(form.isAvailableOnline());

        return data;
    }
}