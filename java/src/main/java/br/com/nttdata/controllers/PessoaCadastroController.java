package br.com.nttdata.controllers;

import br.com.nttdata.data.CadastroForm;
import org.glassfish.jersey.server.mvc.Viewable;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("register")
public class PessoaCadastroController {
    @GET
    @Produces(MediaType.TEXT_HTML)
    public Viewable getPage(){
    return new Viewable("/WEB-INF/jsp/register.jsp");
    }

    @POST
    public String register(@BeanParam CadastroForm form){
        System.out.println(form.getNome());
        return "Funcionou";


    }
}
