<%--
  Created by IntelliJ IDEA.
  User: dougl
  Date: 20/07/2021
  Time: 09:58
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Pessoas</title>
    <jsp:include page="header.jsp"/>
</head>
<body>


<h1 style="text-align: center">Página de Cadastro</h1>


<div class="content">
    <div style="display: block">
        <a href="register">
            <button class="register-button" type="button">Novo Cadastro</button>
        </a>
    </div>


    <table cellspacing="0" cellpadding="0">
        <thead>
        <tr>
            <th class="id-collum">ID</th>
            <th>Nome</th>
            <th>Sobrenome</th>
            <th>E-mail</th>
            <th>Idade</th>
        </tr>
        </thead>


        <tbody>
        <c:forEach items="${pessoas}" var="pessoa">
        <tr>
            <td>${pessoa.id}</td>
            <td>${pessoa.nome}</td>
            <td>${pessoa.sobrenome}</td>
            <td>${pessoa.email}</td>
            <td>${pessoa.idade}</td>
        </tr>
        </c:forEach>


        <tbody/>
    </table>
</div>
</body>
</html>