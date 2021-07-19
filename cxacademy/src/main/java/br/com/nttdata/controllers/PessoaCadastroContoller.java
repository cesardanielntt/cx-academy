package br.com.nttdata.controllers;

import org.glassfish.jersey.server.mvc.Viewable;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("register")

public class PessoaCadastroContoller {
    @GET
    @Produces(MediaType.TEXT_HTML)
    public Viewable getPage() {
        final Viewable viewable = new Viewable("/WEB-INF/jsp/register.jsp");
        return viewable;
    }

}
