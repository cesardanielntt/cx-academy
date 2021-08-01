package com.nttdata.academy.controller;
import com.nttdata.academy.dto.CarrinhoDTO;
import com.nttdata.academy.dto.ClienteDTO;
import com.nttdata.academy.dto.ProdutoDTO;
import com.nttdata.academy.facade.CarrinhoFacade;
import com.nttdata.academy.facade.ProdutoFacade;
import com.nttdata.academy.models.CarrinhoModel;
import com.nttdata.academy.models.ClienteModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Optional;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {
    private static final Logger LOG = LogManager.getLogger(ProdutoController.class);


    @Resource(name = "carrinhoFacade")
    private CarrinhoFacade carrinhoFacade;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<CarrinhoModel>> receberCarrinhoPeloId(@PathVariable Integer id) {
        return carrinhoFacade.listar(id);
    }

    @RequestMapping(value = "/adicionar", method = RequestMethod.POST)
    public ResponseEntity adicionarCarrinho(@RequestBody CarrinhoDTO carrinho) {

        LOG.debug(carrinho.toString());

        carrinho = carrinhoFacade.adicionar(carrinho);

        return ResponseEntity.ok().body(carrinho);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<CarrinhoDTO> atualizarCarrinho(@RequestBody CarrinhoDTO carrinho, @PathVariable Integer id) {
        return carrinhoFacade.atualizar(carrinho, id);
    }

    @DeleteMapping (path = "/{id}")
    public ResponseEntity<ClienteModel> deletarCliente(@PathVariable Integer id) {
        return carrinhoFacade.deletar(id);

    }
}
