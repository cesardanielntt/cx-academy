<%--
  Created by IntelliJ IDEA.
  User: tiago
  Date: 19/07/2021
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="header.jsp"/>
</head>
<h1 style="text-align: center">Página de cadastro</h1>

<body action="${pageContext.servletContext.contextPath}/pages/register" method=POST">
    <div class="row">
        <%--@declare id="nome"--%><label for="nome">Nome</label>
        <input type="text" name="nome" placeholder="Digite seu Nome"/>
    </div>
    <div class="row">
        <%--@declare id="sobrenome"--%><label for="sobrenome">Sobrenome</label>
        <input type="text" name="sobrenome" placeholder="Digite seu Sobrenome"/>
    </div>
    <div class="row">
        <%--@declare id="email"--%><label for="email">E-mail</label>
        <input type="text" name="email" placeholder="Digite seu E-mail"/>
    </div>
    <div class="row">
        <%--@declare id="idade"--%><label for="idade">Idade</label>
        <input type="text" name="idade" placeholder="Digite sua idade"/>
    </div>
    <h2 style="...">Endereço</h2>
    <div class="row">
        <%--@declare id="rua"--%><label for="rua">Rua</label>
        <input type="text" name="Rua" placeholder="Digite sua Rua"/>
    </div>
    <div class="row">
        <%--@declare id="numero"--%><label for="numero">Número</label>
        <input type="text" name="Número" placeholder="Digite seu Número"/>
    </div>
    <div class="row">
        <%--@declare id="complemento"--%><label for="complemento">Complemento</label>
        <input type="text" name="Complemento" placeholder="Digite seu Complemento"/>
    </div>
    <div class="row">
        <%--@declare id="bairro"--%><label for="bairro">Bairro</label>
        <input type="text" name="Bairro" placeholder="Digite seu Bairro"/>
    </div>
    <div class="row">
        <%--@declare id="cidade"--%><label for="cidade">Cidade</label>
        <input type="text" name="Cidade" placeholder="Digite sua Cidade"/>
    </div>
    <div class="row">
        <%--@declare id="estado"--%><label for="Estado">Estado</label>
        <input type="text" name="Estado" placeholder="Digite seu Estado"/>
    </div>
    <div class="row">
        <%--@declare id="cep"--%><label for="cep">CEP</label>
        <input type="text" name="CEP" placeholder="Digite seu CEP"/>
    </div>
</body>
</html>
