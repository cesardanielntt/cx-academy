package com.nttdata.spring.cxacademy.controller;

import com.nttdata.spring.cxacademy.data.ClientData;
import com.nttdata.spring.cxacademy.facade.ClientFacade;
import com.nttdata.spring.cxacademy.form.ClientForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/customers")
public class ClientController {

    @Autowired
    private ClientFacade clientFacade;

    @GetMapping
    public String getClients(Model model) {
        model.addAttribute("customers", clientFacade.getAllClients());
        return "clientPage";
    }

    @PostMapping("/create")
    public String create(ClientForm clientForm, RedirectAttributes redirectAttributes) {
        if(clientForm.getName().isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "O nome do cliente é obrigatório!");
            return "redirect:/customers";
        }

        clientFacade.saveClient(convert(clientForm));
        redirectAttributes.addFlashAttribute("success", "cliente salvo com sucesso!");
        return "redirect:/customers";
    }

    @GetMapping(value = "/edit")
    public String editClient(@RequestParam Integer code, Model model, RedirectAttributes redirectAttributes) {
       ClientData client = clientFacade.getClientByCode(code);

       if(client != null) {
           model.addAttribute("client", client);
           return "clientEditPage";
       }

       redirectAttributes.addFlashAttribute("error", "Cliente não encontrado!");
       return "redirect:/customers";

    }

    @PostMapping("/edit")
    public String editClient(ClientForm clientForm, RedirectAttributes redirectAttributes) {
        if(clientForm.getName().isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "O campo nome não pode ficar vazio!");
            return "redirect:/customers";
        }

        clientFacade.saveClient(convert(clientForm));
        redirectAttributes.addFlashAttribute("success", "Cliente atualizado com successo!");
        return "redirect:/customers";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes) {
        try {
            clientFacade.deleteClient(id);
            redirectAttributes.addFlashAttribute("success", "Cliente excluido com sucesse");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Erro ao excluir cliente!");
        }

        return "redirect:/customers";
    }


    private ClientData convert(ClientForm form) {
        ClientData data = new ClientData();
        data.setCode(form.getCode());
        data.setName(form.getName());
        data.setSurname(form.getSurname());
        data.setEmail(form.getEmail());
        data.setNameStreet(form.getNameStreet());
        data.setNumberStreet(form.getNumberStreet());
        data.setComplement(form.getComplement());
        data.setCep(form.getCep());
        data.setUf(form.getUf());
        data.setCity(form.getCity());
        data.setCep(form.getCep());

        return data;
    }



}
