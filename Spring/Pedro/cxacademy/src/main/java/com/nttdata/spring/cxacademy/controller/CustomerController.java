package com.nttdata.spring.cxacademy.controller;

import com.nttdata.spring.cxacademy.data.AddressData;
import com.nttdata.spring.cxacademy.data.CustomerData;
import com.nttdata.spring.cxacademy.facade.CustomerFacade;
import com.nttdata.spring.cxacademy.form.AddressForm;
import com.nttdata.spring.cxacademy.form.CustomerForm;
import com.nttdata.spring.cxacademy.model.AddressModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerFacade customerFacade;

    @GetMapping
    public String getCustomers(Model model){
        model.addAttribute("customers", customerFacade.getAllCustomers());

        List<CustomerData> dados;

        dados = customerFacade.getAllCustomers();

        return "customerPage";
    }

    @PostMapping("/create")
    public String create(CustomerForm customerForm, RedirectAttributes redirectAttributes){
        if(customerForm.getName().isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "O nome do cliente é obrigatório!");
            return "redirect:/customers";
        }

        if(customerForm.getSobrenome().isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "O sobrenome do cliente é obrigatório!");
            return "redirect:/customers";
        }

        if(customerForm.getEmail().isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "O email do cliente é obrigatório!");
            return "redirect:/customers";
        }

        if(customerForm.getEnderecos().get(0).getRua().isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "A rua do endereço é obrigatório!");
            return "redirect:/customers";
        }

        if(customerForm.getEnderecos().get(0).getComplemento().isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "O complemento do endereço é obrigatório!");
            return "redirect:/customers";
        }

        if(customerForm.getEnderecos().get(0).getCidade().isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "A cidade do endereço é obrigatório!");
            return "redirect:/customers";
        }

        if(customerForm.getEnderecos().get(0).getEstado().isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "O estado do endereço é obrigatório!");
            return "redirect:/customers";
        }

        if(customerForm.getEnderecos().get(0).getCep().isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "O CEP do endereço é obrigatório!");
            return "redirect:/customers";
        }

        if(customerForm.getEnderecos().get(0).getNumero().isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "O número do endereço é obrigatório!");
            return "redirect:/customers";
        }

        CustomerData customerData = convert(customerForm);

        customerFacade.save(customerData); // inseriu o customer o na tabela

        System.out.println("cliente cadastrado com sucesso!");

        redirectAttributes.addFlashAttribute("sucess", "Cliente salvo com sucesso!");

        return "redirect:/customers";
    }

    @GetMapping("/edit")
    public String editProduct(@RequestParam int code, Model model, RedirectAttributes redirectAttributes){
        CustomerData customer = customerFacade.getCustomerByCode(code);

        if(customer != null){
            model.addAttribute("customer", customer);
            return "customerEditPage";
        }

        redirectAttributes.addFlashAttribute("error", "Cliente não encontrado!");
        return "redirect:/customers";
    }

        @PostMapping("/edit")
        public String editCustomer(CustomerForm customerForm, RedirectAttributes redirectAttributes){
            if(customerForm.getName().isEmpty()) {
                redirectAttributes.addFlashAttribute("error", "O nome do cliente é obrigatório!");
                return "redirect:/customers";
            }

            if(customerForm.getSobrenome().isEmpty()) {
                redirectAttributes.addFlashAttribute("error", "O sobrenome do cliente é obrigatório!");
                return "redirect:/customers";
            }

            if(customerForm.getEmail().isEmpty()) {
                redirectAttributes.addFlashAttribute("error", "O email do cliente é obrigatório!");
                return "redirect:/customers";
            }

            if(customerForm.getEnderecos().get(0).getRua().isEmpty()) {
                redirectAttributes.addFlashAttribute("error", "A rua do endereço é obrigatório!");
                return "redirect:/customers";
            }

            if(customerForm.getEnderecos().get(0).getComplemento().isEmpty()) {
                redirectAttributes.addFlashAttribute("error", "O complemento do endereço é obrigatório!");
                return "redirect:/customers";
            }

            if(customerForm.getEnderecos().get(0).getCidade().isEmpty()) {
                redirectAttributes.addFlashAttribute("error", "A cidade do endereço é obrigatório!");
                return "redirect:/customers";
            }

            if(customerForm.getEnderecos().get(0).getEstado().isEmpty()) {
                redirectAttributes.addFlashAttribute("error", "O estado do endereço é obrigatório!");
                return "redirect:/customers";
            }

            if(customerForm.getEnderecos().get(0).getCep().isEmpty()) {
                redirectAttributes.addFlashAttribute("error", "O CEP do endereço é obrigatório!");
                return "redirect:/customers";
            }

            if(customerForm.getEnderecos().get(0).getNumero().isEmpty()) {
                redirectAttributes.addFlashAttribute("error", "O número do endereço é obrigatório!");
                return "redirect:/customers";
            }

            CustomerData customerData = convert(customerForm);

            customerFacade.save(customerData); // atualiza o customer o na tabela

            redirectAttributes.addFlashAttribute("sucess", "Cliente atualizado com sucesso!");

            return "redirect:/customers";
        }

        @PostMapping("/delete/{id}")
        public String delete(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes) {
            try {
                customerFacade.deleteCustomer(id);
                redirectAttributes.addFlashAttribute("success", "Cliente deletado com sucesso!");
            } catch (Exception e) {
                redirectAttributes.addFlashAttribute("error", "Erro na deleção do cliente!");
            }
            return "redirect:/customers";
        }

    private CustomerData convert(CustomerForm form){
        CustomerData data = new CustomerData();

        data.setCode(form.getCode());
        data.setName(form.getName());
        data.setSobrenome(form.getSobrenome());
        data.setEmail(form.getEmail());

        List<AddressData> enderecos = new ArrayList<>();
        List<AddressForm> enderecosF = new ArrayList<>();

        enderecosF = form.getEnderecos();

        for(AddressForm address: enderecosF){

            AddressData addressData = new AddressData();

            addressData.setRua(address.getRua());
            addressData.setNumero(address.getNumero());
            addressData.setComplemento(address.getComplemento());
            addressData.setCidade(address.getCidade());
            addressData.setEstado(address.getEstado());
            addressData.setCep(address.getCep());

            enderecos.add(addressData);

            data.setEnderecos(enderecos);

        }

        return data;
    }

}
