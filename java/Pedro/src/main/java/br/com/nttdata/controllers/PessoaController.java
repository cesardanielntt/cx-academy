package br.com.nttdata.controllers;

import br.com.nttdata.service.PessoaService;
import br.com.nttdata.service.impl.PessoaFisicaService;
import org.glassfish.jersey.server.mvc.Viewable;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

@Path("pessoas")
public class PessoaController {

    private PessoaService ps;

    @GET
    public Viewable getPage(@Context HttpServletRequest request){
        ps = new PessoaFisicaService();
        request.setAttribute("pessoas", ps.listarPessoas());

        return new Viewable("/WEB-INF/jsp/pessoas.jsp");
    }




}
