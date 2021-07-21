package br.com.nttdata.controllers;

import br.com.nttdata.data.CadastroForm;
import br.com.nttdata.models.PessoaFisica;
import br.com.nttdata.models.PessoaJuridica;
import br.com.nttdata.service.impl.PessoaFisicaService;
import br.com.nttdata.service.impl.PessoaJuridicaService;
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
    private PessoaJuridicaService empresaService;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public Viewable getPage() {
        final Viewable viewable = new Viewable("/WEB-INF/jsp/register.jsp");
        return viewable;
    }

    @POST
    public Response register(@BeanParam CadastroForm form, @Context HttpServletRequest request) throws URISyntaxException {




        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<CadastroForm>> constraintValidators = validator.validate(form);

        if(!constraintValidators.isEmpty()) {
            final Map<String, String> errors = new HashMap<>();

            constraintValidators.stream().forEach(item -> {
                errors.put(item.getPropertyPath().toString(), item.getMessage());
            });

            request.setAttribute("formErrors", errors);

            System.out.println(errors);

            return Response.status(Response.Status.OK)
                    .entity(new Viewable("/WEB-INF/jsp/register.jsp"))
                    .type(MediaType.TEXT_HTML)
                    .build();
        }


        pessoaService = new PessoaFisicaService();
        PessoaFisica pessoaFisica = new PessoaFisica();

        UUID id = UUID.randomUUID();

        pessoaFisica.setId(id.toString());
        pessoaFisica.setName(form.getName());
        pessoaFisica.setLastName(form.getLastName());
        pessoaFisica.setEmail(form.getEmail());
        pessoaFisica.setAge(form.getAge());
        pessoaFisica.getAddress().setStreet(form.getStreet());
        pessoaFisica.getAddress().setNumber(form.getNumber());
        pessoaFisica.getAddress().setComplement(form.getComplement());
        pessoaFisica.getAddress().setDistrict(form.getDistrict());
        pessoaFisica.getAddress().setCity(form.getCity());
        pessoaFisica.getAddress().setState(form.getState());
        pessoaFisica.getAddress().setCep(form.getCep());

        pessoaService.criarPessoa(pessoaFisica);

        System.out.println(pessoaFisica);

        return Response.seeOther(new URI("pessoas")).build();
    }

}
