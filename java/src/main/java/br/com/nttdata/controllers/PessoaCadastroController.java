package br.com.nttdata.controllers;

import br.com.nttdata.data.CadastroForm;
import br.com.nttdata.models.PessoaFisica;
import br.com.nttdata.service.PessoaService;
import br.com.nttdata.service.impl.PessoaFisicaService;
import org.glassfish.jersey.server.mvc.Viewable;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

@Path("register")
public class PessoaCadastroController {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public Viewable getPage() {
        return new Viewable("/WEB-INF/jsp/register.jsp");

    }

    

    @POST
    public Response register(@BeanParam CadastroForm form) throws URISyntaxException {
        PessoaService pessoaService = new PessoaFisicaService();

        PessoaFisica pessoaFisica = new PessoaFisica();

        String id = UUID.randomUUID().toString();

        pessoaFisica.setId(id);
        pessoaFisica.setNome(form.getNome());
        pessoaFisica.setSobrenome(form.getSobrenome());
        pessoaFisica.setIdade(form.getIdade());
        pessoaFisica.setEmail(form.getEmail());


        pessoaService.criarPessoa(pessoaFisica);

    System.out.println(form.getNome());
    return Response.seeOther(new URI("pessoas")).build();

    }


}
