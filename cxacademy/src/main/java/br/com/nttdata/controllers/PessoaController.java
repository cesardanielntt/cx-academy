package br.com.nttdata.controllers;

import br.com.nttdata.service.impl.PessoaFisicaService;
import org.glassfish.jersey.server.mvc.Viewable;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import java.net.URISyntaxException;

@Path("pessoas")
public class PessoaController {

    private PessoaFisicaService pessoaService;

    @GET
    public Viewable getPage(@Context HttpServletRequest request) throws URISyntaxException {
        pessoaService = new PessoaFisicaService();
        request.setAttribute("pessoas", pessoaService.listarPessoas());

        final Viewable viewable = new Viewable("/WEB-INF/jsp/pessoas.jsp");
        return viewable;
    }
}
