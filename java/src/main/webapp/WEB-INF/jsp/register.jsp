<%--
  Created by IntelliJ IDEA.
  User: Leandro Rocha
  Date: 19/07/2021
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pagina de cadastro</title>
</head>
<body>
        <h1>Página de Cadastro</h1>

<form action="" method="POST">
    <div class="row">
        <label for="nome">Nome</label>
        <input type="teste" name="nome" placeholder="Digite seu nome">
    </div>
    <div class="row">
        <label for="sobrenome">sobrenome</label>
        <input type="text" name="sobrenome" placeholder="sobrenome">
    </div>
    <div class="row">
        <label for="email">email</label>
        <input type="email" name="email" placeholder="email">
    </div>
    <div class="row">
        <label for="idade">idade</label>
        <input type="number" name="idade" placeholder="idade">
    </div>
    <button type="submit">Enviar</button>
</form>
</body>
</html>
