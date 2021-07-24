package br.com.nttdata.controllers;

<<<<<<< HEAD
=======

>>>>>>> origin/master
import br.com.nttdata.data.CadastroForm;
import br.com.nttdata.models.PessoaFisica;
import br.com.nttdata.service.PessoaService;
import br.com.nttdata.service.impl.PessoaFisicaService;
import org.glassfish.jersey.server.mvc.Viewable;

<<<<<<< HEAD

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.ws.rs.*;
=======
import javax.servlet.http.HttpServletRequest;
import javax.validation.*;
import javax.ws.rs.*;
import javax.ws.rs.Path;
>>>>>>> origin/master
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

<<<<<<< HEAD

=======
>>>>>>> origin/master
@Path("register")
public class PessoaCadastroController {

    private PessoaService pessoaService;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public Viewable getPage() {

        return new Viewable("/WEB-INF/jsp/register.jsp");
    }

    @POST
    public Response register(@BeanParam CadastroForm form, @Context HttpServletRequest request) throws URISyntaxException {
        pessoaService = new PessoaFisicaService();


        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<CadastroForm>> constraintViolations = validator.validate(form);

<<<<<<< HEAD
        //se a lista for diferente de vazia..
        if(!constraintViolations.isEmpty()){
            Map<String,String> errors = new HashMap<>();

            constraintViolations.stream().forEach( item ->{
                errors.put(item.getPropertyPath().toString(),item.getMessage() );
=======
        if (!constraintViolations.isEmpty()) {
            final Map<String, String> errors = new HashMap<>();


            // For de exemplo
//            for (ConstraintViolation<CadastroForm> item : constraintViolations) {
//                errors.put(item.getPropertyPath().toString(), item.getMessage());
//            }

            constraintViolations.stream().forEach(item -> {
                errors.put(item.getPropertyPath().toString(), item.getMessage());
>>>>>>> origin/master
            });

            request.setAttribute("formErrors", errors);

            return Response.status(Response.Status.OK)
                    .entity(new Viewable("/WEB-INF/jsp/register.jsp"))
                    .type(MediaType.TEXT_HTML)
                    .build();
        }


        PessoaFisica pessoaFisica = new PessoaFisica();

        String id = UUID.randomUUID().toString();

        pessoaFisica.setId(id);
        pessoaFisica.setNome(form.getNome());
<<<<<<< HEAD
        pessoaFisica.setSobreNome(form.getSobrenome());
        pessoaFisica.setIdade(form.getIdade());
        pessoaFisica.setEmail(form.getEmail());
        pessoaFisica.setRua(form.getRua());
        pessoaFisica.setNumero(form.getNumero());
        pessoaFisica.setComplemento(form.getComplemento());
        pessoaFisica.setBairro(form.getBairro());
        pessoaFisica.setCidade(form.getCidade());
        pessoaFisica.setEstado(form.getEstado());
        pessoaFisica.setCep(form.getCep());
=======
        pessoaFisica.setSobrenome(form.getSobrenome());
        pessoaFisica.setIdade(form.getIdade());
        pessoaFisica.setEmail(form.getEmail());
>>>>>>> origin/master

        pessoaService.criarPessoa(pessoaFisica);

        System.out.println(form.getNome());
        return Response.seeOther(new URI("pessoas")).build();
    }
<<<<<<< HEAD

=======
>>>>>>> origin/master
}
