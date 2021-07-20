<%--
  Created by IntelliJ IDEA.
  User: ramon
  Date: 20/07/2021
  Time: 09:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Pessoas</title>
    <jsp:include page="header.jsp"></jsp:include>
</head>
<body>

<h1 style="text-align: center" >Pessoas</h1>
<div class="content">
    <div style="display: block">
        <a href="register">
            <button class="register-button" type="button">
                Novo Cadastro
            </button>
        </a>
    </div>


<div class="table">

<table cellspacing="0" cellpadding="0">
    <thead>
        <tr>
            <th class="id-column">ID</th>
            <th color>Nome</th>x
            <th >Sobrenome</th>
            <th >E-mail</th>
            <th>Idade</th>
            <th>Rua</th>
            <th>Número</th>
            <th>Complemento</th>
            <th>Bairro</th>
            <th>Cidade</th>
            <th>Estado</th>
            <th>Cep</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${pessoas}" var="pessoa" >

        <tr>
            <td>${pessoa.id}</td>
            <td>${pessoa.nome}</td>
            <td>${pessoa.sobrenome}</td>
            <td>${pessoa.email}</td>
            <td>${pessoa.idade}</td>
            <td>${pessoa.rua}</td>
            <td>${pessoa.numero}</td>
            <td>${pessoa.complemento}</td>
            <td>${pessoa.bairro}</td>
            <td>${pessoa.cidade}</td>
            <td>${pessoa.estado}</td>
            <td>${pessoa.cep}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>
</div>



</body>
</html>