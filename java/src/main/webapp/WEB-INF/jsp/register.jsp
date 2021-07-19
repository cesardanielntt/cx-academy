<%--
  Created by IntelliJ IDEA.
  User: AlphaPlayerOne
  Date: 19/07/21
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Pagina de Cadastro</h1>
<form> action="${pageContext.servletContext.contextPath}/pages/register" method="POST">
    <div> class="row">
        <label> for="nome">Nome</label>
        <input type="text" name="nome" placeholder="Digite seu Nome"/>
    </div>
    <div> class="row">
        <label> for="sobrenome">sobrenome</label>
        <input type="text" name="Sobrenome" placeholder="Digite seu SobreNome"/>
    </div>
    <div> class="row">
        <label> for="email">email</label>
        <input type="text" name="email" placeholder="Digite email"/>
    </div><div> class="row">
        <label> for="idade">idade</label>
        <input type="text" name="idade" placeholder="Digite sua idade"/>
    </div>
    <button type="submit">Enviar</button>
</form>
</body>
</html>
