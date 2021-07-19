package br.com.nttdata.controllers;

import br.com.nttdata.data.CadastroForm;
import org.glassfish.jersey.server.mvc.Viewable;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("register")

public class PessoaCadastroContoller {
    @GET
    @Produces(MediaType.TEXT_HTML)
    public Viewable getPage() {
        final Viewable viewable = new Viewable("/WEB-INF/jsp/register.jsp");
        return viewable;
    }

    @POST
    public String register(@BeanParam CadastroForm form) {
        System.out.println(form.getName());
        return "Funcionou";
    }

}
