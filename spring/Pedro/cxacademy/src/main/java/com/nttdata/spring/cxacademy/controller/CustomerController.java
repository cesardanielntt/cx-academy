package com.nttdata.spring.cxacademy.controller;

import com.nttdata.spring.cxacademy.data.AdressData;
import com.nttdata.spring.cxacademy.data.CustomerData;
import com.nttdata.spring.cxacademy.facade.AdressFacade;
import com.nttdata.spring.cxacademy.facade.CustomerFacade;
import com.nttdata.spring.cxacademy.form.AdressForm;
import com.nttdata.spring.cxacademy.form.CustomerForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerFacade customerFacade;
    @Autowired
    private AdressFacade adressFacade;

    @GetMapping
    public String getCustomers(Model model){
        model.addAttribute("customers", customerFacade.getAllCustomers());
        return "customerPage";
    }

    @PostMapping("/create")
    public String create(CustomerForm customerForm, AdressForm adressForm, RedirectAttributes redirectAttributes){
        if(customerForm.getName().isEmpty()){
            redirectAttributes.addFlashAttribute("error", "O nome do cliente é obrigatório!");
            return "redirect:/customers";
        }
        //System.out.println("cliente cadastrado com sucesso!");

        int idAdress = adressFacade.saveAdress(convertAdress(adressForm)); // inseriu o endereço na tabela

        adressForm.setCode(idAdress); //atualiza code do endereço

        customerForm.setEndereco(adressForm);

      //  System.out.println("id do endereco do mano: " + customerForm.getEndereco().getCode());

        customerFacade.saveCustomer(convert(customerForm));

        redirectAttributes.addFlashAttribute("sucess", "Cliente salvo com sucesso!");

        return "redirect:/customers";
    }

    @GetMapping("/edit")
    public String editProduct(@RequestParam int code, Model model, RedirectAttributes redirectAttributes){
        CustomerData customer = customerFacade.getCustomerByCode(code);

        if(customer != null){
            model.addAttribute("costumer", customer);
            return "customerEditPage";
        }

        redirectAttributes.addFlashAttribute("error", "Cliente não encontrado!");
        return "redirect:/customers";
    }

        @PostMapping("/edit")
        public String editCustomer(CustomerForm customerForm, RedirectAttributes redirectAttributes){
            if(customerForm.getName().isEmpty()){
                redirectAttributes.addFlashAttribute("error", "O nome do cliente é obrigatório!");
                return "redirect:/customers";
            }

            customerFacade.saveCustomer(convert(customerForm));
            redirectAttributes.addFlashAttribute("sucess", "Cliente salvo com sucesso!");

            return "redirect:/products";
        }

        @PostMapping("/delete/{id}")
        public String delete(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes) {
            try {
                customerFacade.deleteCustomer(id);
                redirectAttributes.addFlashAttribute("success", "Cliente deletado com sucesso!");
            } catch (Exception e) {
                redirectAttributes.addFlashAttribute("error", "Erro na deleção do cliente!");
            }
            return "redirect:/products";
        }

    private CustomerData convert(CustomerForm form){
        CustomerData data = new CustomerData();
        data.setCode(form.getCode());
        data.setName(form.getName());
        data.setSobrenome(form.getSobrenome());
        data.setEmail(form.getEmail());
        data.setEndereco(form.getEndereco());

        return data;
    }

    private AdressData convertAdress(AdressForm form){

        AdressData data = new AdressData();

        data.setCode(form.getCode());
        data.setRua(form.getRua());
        data.setNumero(form.getNumero());
        data.setComplemento(form.getComplemento());
        data.setCep(form.getCep());
        data.setEstado(form.getEstado());
        data.setCidade(form.getCidade());

        return data;
    }

}
