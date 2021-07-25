package com.nttdata.spring.cxacademy.controller;

import com.nttdata.spring.cxacademy.data.AddressData;
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

import java.util.Collections;

@Controller
@RequestMapping(value = "/customers")
public class CustomerPageController {

    @Autowired
    private CustomerFacade customerFacade;

    @GetMapping()
    public String getCustomers(Model model) {
        model.addAttribute("customers", customerFacade.getAllCustomers());
        return "customerPage";
    }

    @PostMapping("/create")
    public String create(final CustomerForm form, Model model, RedirectAttributes redirectAttributes) {
        return getString(form, redirectAttributes);
    }

    @GetMapping(value = "/edit")
    public String editCustomer(@RequestParam final String email, Model model, RedirectAttributes redirectAttributes) {

        CustomerData customer = customerFacade.getCustomerByEmail(email);

        if (customer != null) {
            model.addAttribute("customer", customer);
            return "customerEditPage";
        }

        redirectAttributes.addFlashAttribute("error", "Erro: Identificador de cliente inválido");
        return "redirect:/customers";
    }

    @PostMapping(value = "/edit")
    public String editCustomer(final CustomerForm form, Model model, RedirectAttributes redirectAttributes) {
        return getString(form, redirectAttributes);
    }

    private String getString(CustomerForm form, RedirectAttributes redirectAttributes) {
        if (form == null || form.getEmail().isEmpty() || form.getName().isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "Erro: Nome ou Email não podem ficar vazios");
            return "redirect:/customers";
        }

        customerFacade.saveCustomer(convert(form));
        redirectAttributes.addFlashAttribute("success", "Cliente salvo com sucesso");
        return "redirect:/customers";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes) {
        try {
            customerFacade.deleteCustomer(id);
            redirectAttributes.addFlashAttribute("success", "Cliente deletado com sucesso");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Erro ao deletar cliente");
        }
        return "redirect:/customers";
    }

    private CustomerData convert(CustomerForm form) {
        CustomerData data = new CustomerData();
        data.setId(form.getId());
        data.setName(form.getName());
        data.setEmail(form.getEmail());

        if (form.getStreetName() != null && !form.getStreetName().isEmpty() && form.getStreetNumber() != null && !form.getStreetNumber().isEmpty() && form.getCity() != null && !form.getCity().isEmpty()) {
            AddressData address = new AddressData();
            address.setId(form.getAddressID());
            address.setStreetName(form.getStreetName());
            address.setStreetNumber(form.getStreetNumber());
            address.setCity(form.getCity());
            data.setAddresses(Collections.singletonList(address));
        }

        return data;
    }
}