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
@RequestMapping("/customers")
public class CustomerPageController {

    @Autowired
    private CustomerFacade customerFacade;

    @GetMapping()
    public String getCustomers(Model model) {
        model.addAttribute("customers", customerFacade.getAllCustomers());
        return "customerPage";
    }

    @PostMapping("/create")
    public String create(CustomerForm customerForm, RedirectAttributes redirectAttributes) {
        if (customerForm.getName().isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "Error: Name / Email cannot be empty");
            return "redirect:/customers";
        }

        customerFacade.saveCustomer(convert(customerForm));
        redirectAttributes.addFlashAttribute("success", "Customer saved successfully");
        return "redirect:/customers";
    }

    @GetMapping(value = "/edit")
    public String editCustomer(@RequestParam String email, Model model, RedirectAttributes redirectAttributes) {

        CustomerData customer = customerFacade.getCustomerByEmail(email);

        if (customer != null) {
            model.addAttribute("customer", customer);
            return "customerEditPage";
        }

        redirectAttributes.addFlashAttribute("error", "Error: Invalid Customer ID");
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
