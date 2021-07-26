<%--
  Created by IntelliJ IDEA.
  User: Onilson
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
<body>
<h1 style="text-align: center">Página de Cadastro</h1>

<form action="${pageContext.servletContext.contextPath}/pages/register" method="POST">
    <div class="row">
        <label for="nome">Nome</label>
        <input type="text" name="nome" placeholder="Digite seu Nome"/>
        <jsp:include page="error.jsp">
            <jsp:param name="path" value="nome"/>
        </jsp:include>
    </div>
    <div class="row">
        <label for="sobrenome">Sobrenome</label>
        <input type="text" name="sobrenome" placeholder="Digite seu Sobrenome"/>
        <jsp:include page="error.jsp">
            <jsp:param name="path" value="sobrenome"/>
        </jsp:include>
    </div>
    <div class="row">
        <label for="email">E-mail</label>
        <input type="email" name="email" placeholder="Digite seu E-mail"/>
        <jsp:include page="error.jsp">
            <jsp:param name="path" value="email"/>
        </jsp:include>
    </div>
    <div class="row">
        <label for="idade">Idade</label>
        <input type="number" name="idade" placeholder="Digite sua Idade"/>
    </div>

    <div class="row">
        <label for="rua">Rua</label>
        <input type="text" name="rua" placeholder="Digite a rua">
        <jsp:include page="error.jsp">
            <jsp:param name="path" value="rua"/>
        </jsp:include>
    </div>
    <div class="row">
        <label for="numero">Numero</label>
        <input type="number" name="numero" placeholder="Digite o número ">
    </div>
    <div class="row">
        <label for="complemento">Complemento</label>
        <input type="text" name="complemento" placeholder="Digite o complemento">
        <jsp:include page="error.jsp">
            <jsp:param name="path" value="complemento"/>
        </jsp:include>
    </div>
    <div class="row">
        <label for="bairro">Bairro</label>
        <input type="text" name="bairro" placeholder="Digite o bairro">
        <jsp:include page="error.jsp">
            <jsp:param name="path" value="bairro"/>
        </jsp:include>
    </div>
    <div class="row">
        <label for="cidade">Cidade</label>
        <input type="text" name="cidade" placeholder="Digite a cidade">
        <jsp:include page="error.jsp">
            <jsp:param name="path" value="cidade"/>
        </jsp:include>
    </div>
    <div class="row">
        <label for="estado">Estado</label>
        <input type="text" name="estado" placeholder="Digite o estado">
        <jsp:include page="error.jsp">
            <jsp:param name="path" value="estado"/>
        </jsp:include>
    </div>
    <div class="row">
        <label for="cep">Cep</label>
        <input type="text" class="cep" name="cep" placeholder="Digite o cep">
    </div>

    <button type="submit">Enviar</button>
</form>
</body>
</html>
