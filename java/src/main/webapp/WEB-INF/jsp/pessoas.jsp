<%--
  Created by IntelliJ IDEA.
<<<<<<< HEAD
  User: Leandro Rocha
=======
  User: lucas
>>>>>>> origin/master
  Date: 20/07/2021
  Time: 09:57
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
<<<<<<< HEAD
<h1 style="text-align: center">Pessoas</h1>
=======

<h1 style="text-align: center">Pessoas</h1>

>>>>>>> origin/master
<div class="content">
    <div style="display: block">
        <a href="register">
            <button class="register-button" type="button">Novo Cadastro</button>
        </a>
    </div>
<<<<<<< HEAD
    <div class="table">
        <table cellspacing="0", cellpadding="0">
=======

    <div class="table">
        <table cellspacing="0" cellpadding="0">
>>>>>>> origin/master
            <thead>
            <tr>
                <th class="id-collum">ID</th>
                <th>Nome</th>
                <th>Sobrenome</th>
                <th>E-mail</th>
                <th>Idade</th>
<<<<<<< HEAD
                <th>Endereço</th>
=======
>>>>>>> origin/master
            </tr>
            </thead>

            <tbody>
            <c:forEach items="${pessoas}" var="pessoa">
                <tr>
                    <td>${pessoa.id}</td>
                    <td>${pessoa.nome}</td>
<<<<<<< HEAD
                    <td>${pessoa.sobreNome}</td>
                    <td>${pessoa.email}</td>
                    <td>${pessoa.idade} anos</td>
                    <td>${pessoa.rua}, ${pessoa.numero}, ${pessoa.complemento}, ${pessoa.bairro}, ${pessoa.cidade},
                            ${pessoa.estado}, ${pessoa.cep}</td>
=======
                    <td>${pessoa.sobrenome}</td>
                    <td>${pessoa.email}</td>
                    <td>${pessoa.idade} anos</td>
>>>>>>> origin/master
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<<<<<<< HEAD
=======


>>>>>>> origin/master
</body>
</html>
