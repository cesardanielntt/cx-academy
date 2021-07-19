<%--
  Created by IntelliJ IDEA.
  User: teilor.miotto
  Date: 19/07/2021
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Pagina de Cadastro</h1>

<form action="${pageContext.servletContext.contextPath}/pages/register" method="POST">
    <div class="row">
        <label for="nome">Nome</label>
        <input type="text" name="nome" placeholder="Digite seu nome"/>
    </div>
    <div class="row">
        <label for="sobrenome">Sobrenome</label>
        <input type="text" name="sobrenome" placeholder="Digite seu sobrenome"/>
    </div>
    <div class="row">
        <label for="email">Email</label>
        <input type="email" name="email" placeholder="Digite seu email"/>
    </div>
    <div class="row">
        <label for="idade">Idade</label>
        <input type="number" name="idade" placeholder="Digite sua idade"/>
    </div>

    <button type="submit">Enviar</button>
</form>

</body>
</html>
