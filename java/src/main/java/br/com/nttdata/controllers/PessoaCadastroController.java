package br.com.nttdata.controllers;

import br.com.nttdata.data.CadastroForm;
import br.com.nttdata.models.PessoaFisica;
import br.com.nttdata.service.PessoaService;
import br.com.nttdata.service.impl.PessoaFisicaService;
import org.glassfish.jersey.server.mvc.Viewable;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.validation.Validator;
import java.net.URISyntaxException;
import java.util.UUID;
import java.net.URI;

@Path("register")
public class PessoaCadastroController {

    private PessoaFisicaService pessoaService;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public Viewable getPage(){
        return new Viewable("/WEB-INF/jsp/register.jsp");
    }

    @POST
    public Response register(@BeanParam CadastroForm form) throws URISyntaxException {
        pessoaService = new PessoaFisicaService();

        VatorFactory validatorFactory = new Validator.buildDefaultValidatorFactory();

        PessoaFisica pf = new PessoaFisica();

        String id = UUID.randomUUID().toString();

        pf.setId(id);
        pf.setNome(form.getNome());
        pf.setSobrenome(form.getSobrenome());
        pf.setIdade(form.getIdade());
        pf.setEmail(form.getEmail());

        pessoaService.criarPessoa(pf);

        System.out.println(form.getNome());

        return Response.seeOther(new URI("pessoas")).build();
    }
}
