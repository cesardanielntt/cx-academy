//package br.com.nttdata;
//
//import br.com.nttdata.models.Pessoa;
//import br.com.nttdata.models.PessoaFisica;
//import br.com.nttdata.models.PessoaJuridica;
//
//import java.util.ArrayList;
//import java.util.List;
//@@ -10,22 +12,34 @@
//
//public static void main(String[] args) {
//
//        Pessoa pessoa = new Pessoa("Lucas");
//        PessoaFisica pessoa = new PessoaFisica();
//        pessoa.setNome("Lucas");
//        pessoa.setSobrenome("Kulik");
//        pessoa.setEmail("lucas.chropacz@nttdata.com");
//        pessoa.setIdade(24);
//
//        Pessoa pessoa2 = new Pessoa("Cleber");
//        PessoaFisica pessoa2 = new PessoaFisica();
//        pessoa2.setNome("Cleber");
//        pessoa2.setSobrenome("Teste");
//        pessoa2.setEmail("teste@teste.com");
//        pessoa2.setIdade(32);
//
//        PessoaJuridica pj1 = new PessoaJuridica();
//        pj1.setNome("Pessoa Jurídica");
//        pj1.setEmail("pj@teste.com");
//        pj1.setCnpj("53.178.531/0001-35");
//
//        List<Pessoa> pessoas = new ArrayList<>();
//        pessoas.add(pessoa);
//        pessoas.add(pessoa2);
//        pessoas.add(pj1);
//
//        for (Pessoa item : pessoas) {
//        System.out.println(item.getNome());
//        if(item instanceof PessoaFisica){
//        System.out.println(((PessoaFisica) item).getSobrenome());
//        }else if(item instanceof PessoaJuridica){
//        System.out.println(((PessoaJuridica) item).getCnpj());
//        }
//        }