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
<<<<<<< HEAD

    private PessoaService pessoaService;

    @GET
    public Viewable getPage(@Context HttpServletRequest request){
        pessoaService = new PessoaFisicaService();
        System.out.println(pessoaService.listarPessoas());
=======
    private PessoaService pessoaService;


    @GET
    public Viewable getPage(@Context HttpServletRequest request){
        pessoaService = new PessoaFisicaService();
>>>>>>> master
        request.setAttribute("pessoas", pessoaService.listarPessoas());

        return new Viewable("/WEB-INF/jsp/pessoas.jsp");
    }

<<<<<<< HEAD
}
=======
}
>>>>>>> master
