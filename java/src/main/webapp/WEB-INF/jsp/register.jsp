<%--
  Created by IntelliJ IDEA.
  User: ramon
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
    <h1>Pagina de cadastro</h1>

    <form action="" method="post">
        <div class="row">
            <label for="nome">Nome</label>
            <input type="text" name="nome" placeholder="Digite seu nome" />
        </div>
        <div class="row">
            <label for="sobrenome">Sobrenoe</label>
            <input type="text" name="sobrenome" placeholder="Digite seu sobrenome" />
        </div>
        <div class="row">
            <label for="email">Email</label>
            <input type="email" name="email" placeholder="Digite seu email" />
        </div>
        <div class="row">
            <label for="idade">Idade</label>
            <input type="number" name="email" placeholder="Digite sua idade" />
        </div>

        <button type="submit">Enviar</button>
    </form>
</body>
</html>
