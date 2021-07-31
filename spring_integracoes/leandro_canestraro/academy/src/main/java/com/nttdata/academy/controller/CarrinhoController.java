package com.nttdata.academy.controller;


import com.nttdata.academy.dto.CarrinhoDTO;
import com.nttdata.academy.dto.PrecoDTO;
import com.nttdata.academy.facade.CarrinhoFacade;
import com.nttdata.academy.facade.PrecoFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {


    @Resource(name = "carrinhoFacade")
    private CarrinhoFacade carrinhoFacade;


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity adicionarAoCarrinho(@RequestBody CarrinhoDTO carrinho){


//        LOG.debug(cliente.toString());

//     JSON structure to make a request (values may be changed to make request, these are the ones I used to test)
//        {
//            "items": [
//            {
//                "quantidade": 10,
//                    "cliente": {
//                "id": 2
//            },
//                "produto": {
//                "id": 5
//            }
//            }
//    ]
//        }

        //Preco is retrievied via query and added to item registry

        carrinho = carrinhoFacade.adicionar(carrinho);

        return ResponseEntity.ok().body(carrinho);
    }

    @GetMapping("/{id}")
    public ResponseEntity getCarrinhosByCliente(@PathVariable Integer id) {


        return ResponseEntity.ok().body(carrinhoFacade.getCarrinhoByCliente(id));

    }

}
