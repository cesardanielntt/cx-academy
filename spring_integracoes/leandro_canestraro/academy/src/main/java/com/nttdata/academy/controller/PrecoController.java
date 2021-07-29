package com.nttdata.academy.controller;

import com.nttdata.academy.dto.ClienteDTO;
import com.nttdata.academy.dto.PrecoDTO;
import com.nttdata.academy.facade.ClienteFacade;
import com.nttdata.academy.facade.PrecoFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/preco")
public class PrecoController {

    @Resource(name = "precoFacade")
    private PrecoFacade precoFacade;


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity adicionarPreco(@RequestBody PrecoDTO preco){


//        LOG.debug(cliente.toString());

        preco = precoFacade.adicionar(preco);

        return ResponseEntity.ok().body(preco);
    }
}
