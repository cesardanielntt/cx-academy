<%--
  Created by IntelliJ IDEA.
  User: lucas
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

<h1 style="text-align: center">Pessoas</h1>

<div class="content">
    <div style="display: block">
        <a href="register">
            <button class="register-button" type="button">Novo Cadastro</button>
        </a>
    </div>

    <div class="table">
        <table cellspacing="0" cellpadding="0">
            <thead>
            <tr>
                <th class="id-collum">ID</th>
                <th>Nome</th>
                <th>Sobrenome</th>
                <th>E-mail</th>
                <th>Idade</th>
                <th>Logradouro</th>
                <th>Numero</th>
                <th>Complemento</th>
                <th>Bairro</th>
                <th>Cidade</th>
                <th>Estado</th>
                <th>CEP</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach items="${pessoas}" var="pessoa">
                <tr>
                    <td>${pessoa.id}</td>
                    <td>${pessoa.name}</td>
                    <td>${pessoa.lastName}</td>
                    <td>${pessoa.email}</td>
                    <td>${pessoa.age} anos</td>
                    <td>${pessoa.address.street}</td>
                    <td>${pessoa.address.number}</td>
                    <td>${pessoa.address.complement}</td>
                    <td>${pessoa.address.district}</td>
                    <td>${pessoa.address.city}</td>
                    <td>${pessoa.address.state}</td>
                    <td>${pessoa.address.cep}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>


</body>
</html>
