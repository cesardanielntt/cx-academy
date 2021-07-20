<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title> Title </title>
</head>
<body>


<h1>Página de Cadastro</h1>
<form action="${pageContext.servletContext.contextPath}" method="POST">


    <div class="row">
        <label for="nome">Nome</label>
        <input type="text" name="nome" placeholder="Digite seu Nome"/>
    </div>


    <div class="row">
        <label for="sobrenome">Sobrenome</label>
        <input type="text" name="sobrenome" placeholder="Digite seu Sobrenome"/>
    </div>

    <div class="row">
        <label for="idade">Idade</label>
        <input type="text" name="idade" placeholder="Digite sua idade"/>
    </div>


    <div class="row">
        <label for="email">E-mail</label>
        <input type="text" name="email" placeholder="Digite seu e-mail"/>
    </div>


    <button type="submit">Enviar</button>


</form>
</body>
</html>