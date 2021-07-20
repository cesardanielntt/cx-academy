<%--
  Created by IntelliJ IDEA.
  User: Pedro
  Date: 19/07/2021
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registro</title>
    <jsp:include page="header.jsp"/>
</head>
<body>
    <h1>Página de Cadastro</h1>

    <form action="${pageContext.servletContext.contextPath}/pages/register" method="post">
        <div class="row">
            <label for="name">Nome</label>
            <input type="text" name="nome" placeholder="Digite seu nome">
        </div>

        <div class="row">
            <label for="sobrenome">Sobrenome</label>
            <input type="text" name="sobrenome" placeholder="Digite seu sobrenome">
        </div>

        <div class="row">
            <label for="email">E-mail</label>
            <input type="email" name="email" placeholder="Digite seu email">
        </div>

        <div class="row">
            <label for="email">Idade</label>
            <input type="number" name="idade" placeholder="Digite sua idade">
        </div>

        <div class="row">
            <label for="estado">Estado</label>
            <input type="text" name="estado" placeholder="Digite o estado">
        </div>

        <div class="row">
            <label for="cidade">Cidade</label>
            <input type="text" name="cidade" placeholder="Digite a cidade">
        </div>

        <div class="row">
            <label for="bairro">Bairro</label>
            <input type="text" name="bairro" placeholder="Digite o bairro">
        </div>

        <div class="row">
            <label for="rua">Rua</label>
            <input type="text" name="rua" placeholder="Digite a rua">
        </div>

        <div class="row">
            <label for="cep">Cep</label>
            <input type="text" name="cep" placeholder="Digite o CEP">
        </div>

        <div class="row">
            <label for="numero">Rua</label>
            <input type="number" name="numero" placeholder="Digite o numero">
        </div>

        <button type="submit">Enviar</button>
    </form>
</body>
</html>
