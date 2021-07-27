package com.nttdata.academy.controller;



import com.nttdata.academy.dto.ProdutoDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/produto")
public class ProdutoController {
    private static Logger LOG = LogManager.getLogger(ClienteController.class);

    @RequestMapping(value = "adicionar", method = RequestMethod.POST)
        public ResponseEntity adicionarProduto(@RequestBody ProdutoDto produto){
           LOG.debug(produto.toString());
           return ResponseEntity.ok().body(produto);
        }
}
