<%--
  Created by IntelliJ IDEA.
  User: leand
  Date: 19/07/2021
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
    <h2>Register Page</h2>
    <form action="" method="post">
        <div class="row">
            <label for="name" >Insira seu nome</label>
            <input type="text" name="name" placeholder="Nome">

        </div>
        <div class="row">
            <label for="last-name" >Insira seu sobrenome</label>
            <input type="email" name="last-name" placeholder="Sobrenome">

        </div>
        <div class="row">
            <label for="age" >Insira sua idade</label>
            <input type="number" name="age" placeholder="Idade">

        </div>
        <input type="submit" value="Enviar">
    </form>
</body>
</html>
