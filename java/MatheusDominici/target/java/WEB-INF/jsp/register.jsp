<%--
  Created by IntelliJ IDEA.
  User: madom
  Date: 19/07/2021
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="header.jsp"/>
    <h1>Página de Cadastros</h1>

<form action="${pageContext.servletContext.contextPath}/pages/register" method="POST">
    <div class="row">
        <label for="nome">Nome</label>
        <input type="text" name="nome" placeholder="Digite seu Nome">
        <jsp:include page="error.jsp">
            <jsp:param name="path" value="nome"/>
        </jsp:include>
    </div>

    <div class="row">
        <label for="sobrenome">Sobrenome</label>
        <input type="text" name="sobrenome" placeholder="Digite seu Sobrenome">
        <jsp:include page="error.jsp">
            <jsp:param name="path" value="sobrenome"/>
        </jsp:include>
    </div>

    <div class="row w70">
        <label for="email">E-mail</label>
        <input type="email" name="email" placeholder="Digite seu E-mail">
        <jsp:include page="error.jsp">
            <jsp:param name="path" value="email"/>
        </jsp:include>
    </div>

    <div class="row w30">
        <label for="idade">Idade</label>
        <input type="number" name="idade" placeholder="Digite sua Idade">
    </div>


    <div class="row w70">
        <label for="rua">Rua</label>
        <input type="text" name="rua" placeholder="Digite sua rua">
        <jsp:include page="error.jsp">
            <jsp:param name="path" value="rua"/>
        </jsp:include>
    </div>

    <div class="row w30">
        <label for="numero">Numero</label>
        <input type="number" name="numero" placeholder="Digite o Numero da residencia">
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

    <div class="row w70">
        <label for="cidade">Cidade</label>
        <input type="text" name="cidade" placeholder="Digite o cidade">
        <jsp:include page="error.jsp">
            <jsp:param name="path" value="cidade"/>
        </jsp:include>
    </div>

    <div class="row w30">
        <label for="estado">Estado</label>
        <input type="text" name="estado" placeholder="Digite o estado">
        <jsp:include page="error.jsp">
            <jsp:param name="path" value="estado"/>
        </jsp:include>
    </div>

    <div class="row">
        <label for="cep">CEP</label>
        <input type="text" name="cep" placeholder="Digite o CEP">
    </div>

    <button type="submit">Enviar</button>
    </form>
</head>
<body>

</body>
</html>
