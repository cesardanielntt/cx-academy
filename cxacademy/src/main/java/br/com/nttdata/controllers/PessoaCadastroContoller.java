package br.com.nttdata.controllers;

import br.com.nttdata.data.CadastroForm;
import br.com.nttdata.models.PessoaFisica;
import br.com.nttdata.service.impl.PessoaFisicaService;
import org.glassfish.jersey.server.mvc.Viewable;

import javax.servlet.http.HttpServletRequest;
import javax.validation.*;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
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
    public Response register(@BeanParam CadastroForm form, @Context HttpServletRequest request) throws URISyntaxException {

        pessoaService = new PessoaFisicaService();


        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<CadastroForm>> constraintValidators = validator.validate(form);

        if(!constraintValidators.isEmpty()) {
            final Map<String, String> errors = new HashMap<>();

            constraintValidators.stream().forEach(item -> {
                errors.put(item.getPropertyPath().toString(), item.getMessage());
            });

            request.setAttribute("formErrors", errors);

            return Response.status(Response.Status.OK)
                    .entity(new Viewable("/WEB-INF/jsp/register.jsp"))
                    .type(MediaType.TEXT_HTML)
                    .build();
        }



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
