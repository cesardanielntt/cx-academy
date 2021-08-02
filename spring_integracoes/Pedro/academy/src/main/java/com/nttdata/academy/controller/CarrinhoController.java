package com.nttdata.academy.controller;

import com.nttdata.academy.dto.CarrinhoDTO;
import com.nttdata.academy.facade.CarrinhoFacade;
import org.springframework.http.ResponseEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

    private static final Logger LOG = LogManager.getLogger(CarrinhoController.class);

    @Resource(name = "carrinhoFacade")
    private CarrinhoFacade carrinhoFacade;

    @RequestMapping(value = "/criar", method = RequestMethod.POST)
    public ResponseEntity adicionarCarrinho(@RequestBody CarrinhoDTO carrinho){

        LOG.debug(carrinho.toString());
        return carrinhoFacade.criar(carrinho);

    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    @ResponseBody
    public List<CarrinhoDTO> getCarrinhosById(){
        List<CarrinhoDTO> carrinhos = carrinhoFacade.listar();

        System.out.println("Carrinhos: " + carrinhos);

        return carrinhos;

    }

    @RequestMapping(value = "/consultar/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CarrinhoDTO getCarrinhosById(@PathVariable Integer id){
        CarrinhoDTO carrinho = carrinhoFacade.consultar(id);

        System.out.println("Carrinhos: " + carrinho);

        return carrinho;

    }

    @RequestMapping(value = "/atualizar/{id}", method = RequestMethod.POST)
    public ResponseEntity atualizarCarrinho(@RequestBody CarrinhoDTO carrinho, @PathVariable Integer id){

        LOG.debug(carrinho.toString());

        return carrinhoFacade.atualizar(carrinho, id);

    }

    @RequestMapping(value = "/deletar/{id}", method = RequestMethod.DELETE)
    public void deletarCarrinho(@PathVariable Integer id){

        carrinhoFacade.deletar(id);

        System.out.println("Carrinho de ID " + id + " deletado!");
    }
}
