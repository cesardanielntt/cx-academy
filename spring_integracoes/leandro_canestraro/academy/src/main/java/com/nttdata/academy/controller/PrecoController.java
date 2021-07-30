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



//        JSON structure to make a request (values may be changed to make request, these are the ones I used to test)
//        {
//            "valor": 78,
//                "cliente": {
//            "id": 3
//        },
//            "produto":
//            {
//                "id": 6
//            }
//        }
//
//
//        All objects are filled in the Service layer via query;
//

        preco = precoFacade.adicionar(preco);

        return ResponseEntity.ok().body(preco);
    }
}
