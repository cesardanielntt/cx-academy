package com.nttdata.academy.controller;

import com.nttdata.academy.daos.PrecoRepository;
import com.nttdata.academy.daos.ProdutoRepository;
import com.nttdata.academy.dto.ProdutoDTO;
import com.nttdata.academy.facade.ProdutoFacade;
import com.nttdata.academy.models.PrecoModel;
import com.nttdata.academy.models.ProdutoModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private static final Logger LOG = LogManager.getLogger(ProdutoController.class);


    @PostMapping(produces="application/json")
    public ResponseEntity<PrecoModel> createProduto(@Validated @RequestBody ProdutoDTO produto) {
        ProdutoModel produto = new PrecoModel();

        var newProdutoDTO = ProdutoRepository.save(produto);
        produto.setProdutoDTO(newProdutoDTO);
        produto.setMessage("Successo!");
        return new ResponseEntity<>(produto, HttpStatus.CREATED);
    }



    @PutMapping(path = "/{id}")
    public ResponseEntity<ProdutoModel> updateProdutoDTO(@RequestBody ProdutoDTO produto, @PathVariable int id) {
        boolean data = ProdutoRepository.existsById(id);
        ProdutoModel produto = new ProdutoModel();
        if(data){
            produto.setId(id);
            PrecoRepository.save(produto);
            produto.setProduto(produto);
            produto.setMessage("Successo");
            return new ResponseEntity<>(produto, HttpStatus.OK);
        }else{
            produto.setMessage("Preço de ID: "+id+" não encontrado.");
            return new ResponseEntity<>(produto, HttpStatus.NO_CONTENT);
        }


        @GetMapping(path = "/{id}")
        public ResponseEntity<ProdutoModel> getProdutoById(@PathVariable int id) {
            var produto = ProdutoRepository.findById(id);
            ProdutoModel produto = new PrecoModel();
            if(produto.isPresent()){
                produto.setProdutoModel(produto.get());
                produto.setMessage("Successo");
                return new ResponseEntity<>(produto, HttpStatus.OK);
            }
            produto.setMessage("Produto de ID: \"+id+\" não encontrado.");
            return new ResponseEntity<>(produto, HttpStatus.NO_CONTENT);
        }


        @DeleteMapping(path = "/{id}")
        public ResponseEntity<ProdutoModel> deleteProdutoDTO(@PathVariable int id) {
            Optional<ProdutoDTO> data = ProdutoRepository.findById(id);
            ProdutoModel carrinho = new ProdutoModel();
            if(data.isPresent()){
                ProdutoRepository.delete(data.get());
                produto.setMessage("Produto deletado");
                return new ResponseEntity<>(carrinho, HttpStatus.OK);
            }
            produto.setMessage("Produto de ID: \"+id+\" não encontrado.");
            return new ResponseEntity<>(carrinho, HttpStatus.NO_CONTENT);
        }



    @Resource(name ="produtoFacade")
    private ProdutoFacade produtoFacade;


    @RequestMapping(value = "/adicionar", method = RequestMethod.POST)
    public ResponseEntity adicionarProduto(@RequestBody ProdutoDTO produto){

        LOG.debug(produto.toString());

        produtoFacade.adicionar(produto);

        LOG.debug(produto.toString());

        return ResponseEntity.ok().body(produto);

    }
}

