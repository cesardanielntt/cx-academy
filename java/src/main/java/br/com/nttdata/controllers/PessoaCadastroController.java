package br.com.nttdata.controllers;


import br.com.nttdata.data.CadastroForm;
import br.com.nttdata.models.PessoaFisica;
import br.com.nttdata.service.PessoaService;
import br.com.nttdata.service.impl.PessoaFisicaService;
import org.glassfish.jersey.server.mvc.Viewable;

<<<<<<< HEAD
import javax.ws.rs.*;
=======
import javax.servlet.http.HttpServletRequest;
import javax.validation.*;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
>>>>>>> origin/master
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
<<<<<<< HEAD
=======
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
>>>>>>> origin/master
import java.util.UUID;

@Path("register")
public class PessoaCadastroController {

    private PessoaService pessoaService;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public Viewable getPage() {
<<<<<<< HEAD
        return new Viewable("/WEB-INF/jsp/register.jsp");

    }
    @POST
    public Response register(@BeanParam CadastroForm form) throws URISyntaxException {
        pessoaService = new PessoaFisicaService();

=======

        return new Viewable("/WEB-INF/jsp/register.jsp");
    }

    @POST
    public Response register(@BeanParam CadastroForm form, @Context HttpServletRequest request) throws URISyntaxException {
        pessoaService = new PessoaFisicaService();


        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<CadastroForm>> constraintViolations = validator.validate(form);

        if (!constraintViolations.isEmpty()) {
            final Map<String, String> errors = new HashMap<>();


            // For de exemplo
//            for (ConstraintViolation<CadastroForm> item : constraintViolations) {
//                errors.put(item.getPropertyPath().toString(), item.getMessage());
//            }

            constraintViolations.stream().forEach(item -> {
                errors.put(item.getPropertyPath().toString(), item.getMessage());
            });

            request.setAttribute("formErrors", errors);

            return Response.status(Response.Status.OK)
                    .entity(new Viewable("/WEB-INF/jsp/register.jsp"))
                    .type(MediaType.TEXT_HTML)
                    .build();
        }


>>>>>>> origin/master
        PessoaFisica pessoaFisica = new PessoaFisica();

        String id = UUID.randomUUID().toString();

        pessoaFisica.setId(id);
        pessoaFisica.setNome(form.getNome());
        pessoaFisica.setSobrenome(form.getSobrenome());
        pessoaFisica.setIdade(form.getIdade());
        pessoaFisica.setEmail(form.getEmail());
<<<<<<< HEAD
=======
        pessoaFisica.setRua(form.getRua());
        pessoaFisica.setNumero(form.getNumero());
        pessoaFisica.setComplemento(form.getComplemento());
        pessoaFisica.setBairro(form.getBairro());
        pessoaFisica.setCidade(form.getCidade());
        pessoaFisica.setEstado(form.getEstado());
        pessoaFisica.setCep(form.getCep());
>>>>>>> origin/master

        pessoaService.criarPessoa(pessoaFisica);

        System.out.println(form.getNome());
<<<<<<< HEAD
        Response pessoas = Response.seeOther(new URI("pessoas")).build();
        return pessoas;
        }

=======
        return Response.seeOther(new URI("pessoas")).build();
    }
>>>>>>> origin/master
}
