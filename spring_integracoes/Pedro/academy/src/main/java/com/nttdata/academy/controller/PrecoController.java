package com.nttdata.academy.controller;

import com.nttdata.academy.dto.ClienteDTO;
import com.nttdata.academy.dto.PrecoDTO;
import com.nttdata.academy.dto.ProdutoDTO;
import com.nttdata.academy.facade.ClienteFacade;
import com.nttdata.academy.facade.PrecoFacade;
import com.nttdata.academy.facade.ProdutoFacade;
import org.springframework.http.ResponseEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/preco")
public class PrecoController {

    private static final Logger LOG = LogManager.getLogger(PrecoController.class);

    @Resource(name = "precoFacade")
    private PrecoFacade precoFacade;

    @RequestMapping(value = "/adicionar", method = RequestMethod.POST)
    public ResponseEntity adicionarPreco(@RequestBody PrecoDTO preco){

        LOG.debug(preco.toString());
        return precoFacade.adicionar(preco);

    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    @ResponseBody
    public List<PrecoDTO> getPrecosById(){
        List<PrecoDTO> precos = precoFacade.listar();

        System.out.println("Precos: " + precos);

        return precos;

    }

    @RequestMapping(value = "/consultar/{id}", method = RequestMethod.GET)
    @ResponseBody
    public PrecoDTO getPrecosById(@PathVariable Integer id){
        PrecoDTO preco = precoFacade.consultar(id);

        System.out.println("Precos: " + preco);

        return preco;

    }

    @RequestMapping(value = "/atualizar/{id}", method = RequestMethod.POST)
    public ResponseEntity atualizarPreco(@RequestBody PrecoDTO preco, @PathVariable Integer id){

        LOG.debug(preco.toString());

        return precoFacade.atualizar(preco, id);

    }

    @RequestMapping(value = "/deletar/{id}", method = RequestMethod.DELETE)
    public void deletarPreco(@PathVariable Integer id){

        precoFacade.deletar(id);

        System.out.println("Preco de ID " + id + " deletado!");
    }
}
