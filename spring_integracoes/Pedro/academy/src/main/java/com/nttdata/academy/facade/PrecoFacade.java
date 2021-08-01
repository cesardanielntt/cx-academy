package com.nttdata.academy.facade;

import com.nttdata.academy.dto.PrecoDTO;
import com.nttdata.academy.models.PrecoModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PrecoFacade {

    ResponseEntity adicionar(PrecoDTO preco);

    ResponseEntity atualizar(PrecoDTO preco, Integer id);

    public List<PrecoDTO> listar();

    public PrecoDTO consultar(Integer id);

    public void deletar(Integer id);

}
