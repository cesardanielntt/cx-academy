package br.com.nttdata.controllers;

import org.glassfish.jersey.server.mvc.Viewable;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("register")

public class PessoaCadastroController {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public Viewable getPage(){
        return new Viewable("/WEB-INF/jsp/register.jsp");
    }

}
