<%--
  Created by IntelliJ IDEA.
  User: lucas
  Date: 19/07/2021
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Página de Cadastro</h1>
<form action="" method="POST">
    <div class="row">
        <label for="nome">Nome</label>
        <input type="text" name="nome" placeholder="Digite seu Nome"/>
    </div>
    <div class="row">
        <label for="sobrenome">Sobrenome</label>
        <input type="text" name="sobrenome" placeholder="Digite seu Sobrenome"/>
    </div>

    <div class="row">
        <label for="email">E-mail</label>
        <input type="text" name="email" placeholder="Digite seu e-mail"/>
    </div>
    <div class="row">
        <label for="idade">Idade</label>
        <input type="text" name="idade" placeholder="Digite sua idade"/>
    </div>

    <button type="submit">Enviar</button>
</form>
</body>
</html>