package com.nttdata.academy.controller;

import com.nttdata.academy.dto.ClienteDTO;
import com.nttdata.academy.dto.PrecoDTO;
import com.nttdata.academy.facade.ClienteFacade;
import com.nttdata.academy.facade.PrecoFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity getPrecoByCliente(@PathVariable(name = "id") Integer id) {

        return ResponseEntity.ok().body(precoFacade.getPrecoByCliente(id));

    }

}
