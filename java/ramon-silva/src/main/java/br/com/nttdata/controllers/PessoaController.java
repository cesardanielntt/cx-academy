package br.com.nttdata.controllers;

import br.com.nttdata.services.PessoaService;
import br.com.nttdata.services.impl.PessoaFisicaService;
import org.glassfish.jersey.server.mvc.Viewable;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

@Path("pessoas")
public class PessoaController {

    private PessoaService pessoaService;

    @GET
    public Viewable getPage(@Context HttpServletRequest request) {
        pessoaService = new PessoaFisicaService();
        request.setAttribute("pessoas", pessoaService.listarPessoa());


        return new Viewable("/WEB-INF/jsp/pessoas.jsp");
    }

}
