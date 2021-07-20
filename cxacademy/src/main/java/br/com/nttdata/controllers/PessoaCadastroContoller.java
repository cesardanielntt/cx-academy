package br.com.nttdata.controllers;

import br.com.nttdata.data.CadastroForm;
import br.com.nttdata.models.PessoaFisica;
import br.com.nttdata.service.impl.PessoaFisicaService;
import org.glassfish.jersey.server.mvc.Viewable;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

@Path("register")

public class PessoaCadastroContoller {

    private PessoaFisicaService pessoaService;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public Viewable getPage() {
        final Viewable viewable = new Viewable("/WEB-INF/jsp/register.jsp");
        return viewable;
    }

    @POST
    public Response register(@BeanParam CadastroForm form) throws URISyntaxException {

        pessoaService = new PessoaFisicaService();
        PessoaFisica pessoaFisica = new PessoaFisica();

        UUID id = UUID.randomUUID();

        pessoaFisica.setId(id.toString());
        pessoaFisica.setName(form.getName());
        pessoaFisica.setLastName(form.getLastName());
        pessoaFisica.setEmail(form.getEmail());
        pessoaFisica.setAge(form.getAge());

        pessoaService.criarPessoa(pessoaFisica);

        return Response.seeOther(new URI("pessoas")).build();
    }

}
