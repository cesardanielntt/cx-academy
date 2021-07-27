package br.com.nttdata.controllers;


import br.com.nttdata.data.CadastroForm;
import br.com.nttdata.models.PessoaFisica;
import br.com.nttdata.service.PessoaService;
import br.com.nttdata.service.impl.PessoaFisicaService;
import org.glassfish.jersey.server.mvc.Viewable;

import javax.servlet.http.HttpServletRequest;
import javax.validation.*;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
<<<<<<< HEAD
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
=======
import java.util.UUID;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
>>>>>>> master

@Path("register")
public class PessoaCadastroController {

    private PessoaService pessoaService;

<<<<<<< HEAD
=======


>>>>>>> master
    @GET
    @Produces(MediaType.TEXT_HTML)
    public Viewable getPage() {

        return new Viewable("/WEB-INF/jsp/register.jsp");
    }

    @POST
    public Response register(@BeanParam CadastroForm form, @Context HttpServletRequest request) throws URISyntaxException {
        pessoaService = new PessoaFisicaService();

<<<<<<< HEAD

=======
>>>>>>> master
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<CadastroForm>> constraintViolations = validator.validate(form);

<<<<<<< HEAD
        if (!constraintViolations.isEmpty()) {
            final Map<String, String> errors = new HashMap<>();

            constraintViolations.stream().forEach(item -> {
                errors.put(item.getPropertyPath().toString(), item.getMessage());
            });
            request.setAttribute("formErrors", errors);

            return Response.status(Response.Status.OK)
                    .entity(new Viewable("/WEB-INF/jsp/register.jsp"))
                    .type(MediaType.TEXT_HTML)
                    .build();
        }
=======
        if(!constraintViolations.isEmpty()) {
            final Map<String,String> errors = new HashMap<>();


            constraintViolations.stream().forEach(item -> {
                errors.put(item.getPropertyPath().toString(), item.getMessage());
            
            });

            request.setAttribute("formErrors", errors);
            return Response.status(Response.Status.OK)
                    .entity(new Viewable("/WEB-INF/jsp/register/jsp"))
                    .type(MediaType.TEXT_HTML)
                    .build();
        }

>>>>>>> master
        PessoaFisica pessoaFisica = new PessoaFisica();

        String id = UUID.randomUUID().toString();

        pessoaFisica.setId(id);
        pessoaFisica.setNome(form.getNome());
<<<<<<< HEAD
        pessoaFisica.setSobrenome(form.getSobrenome());
=======
        pessoaFisica.setSobrenome((form.getSobrenome()));
>>>>>>> master
        pessoaFisica.setIdade(form.getIdade());
        pessoaFisica.setEmail(form.getEmail());
        pessoaFisica.setRua(form.getRua());
        pessoaFisica.setNumero(form.getNumero());
        pessoaFisica.setComplemento(form.getComplemento());
<<<<<<< HEAD
        pessoaFisica.setBairro(form.getBairro());
=======
        pessoaFisica.setBairro((form.getBairro()));
>>>>>>> master
        pessoaFisica.setCidade(form.getCidade());
        pessoaFisica.setEstado(form.getEstado());
        pessoaFisica.setCep(form.getCep());

<<<<<<< HEAD
=======

>>>>>>> master
        pessoaService.criarPessoa(pessoaFisica);

        System.out.println(form.getNome());
        return Response.seeOther(new URI("pessoas")).build();
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> master
