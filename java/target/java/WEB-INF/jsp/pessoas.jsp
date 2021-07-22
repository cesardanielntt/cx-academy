<%--
  Created by IntelliJ IDEA.
  User: Pedro
  Date: 20/07/2021
  Time: 09:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
    <jsp:include page="header.jsp"/>
</head>
<body>
<h1>Pessoas</h1>

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
                        <th>Rua</th>
                        <th>Complemento</th>
                        <th>Número</th>
                        <th>Bairro</th>
                        <th>Estado</th>
                        <th>Cidade</th>
                        <th>CEP</th>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach items="${pessoas}" var="pessoa">
                        <tr>
                            <td>${pessoa.id}</td>
                            <td>${pessoa.nome}</td>
                            <td>${pessoa.sobrenome}</td>
                            <td>${pessoa.email}</td>
                            <td>${pessoa.getIdade()}</td>
                            <td>${pessoa.getEndereco().getRua()}</td>
                            <td>${pessoa.getEndereco().getComplemento()}</td>
                            <td>${pessoa.getEndereco().getNumero()}</td>
                            <td>${pessoa.getEndereco().getBairro()}</td>
                            <td>${pessoa.getEndereco().getEstado()}</td>
                            <td>${pessoa.getEndereco().getCidade()}</td>
                            <td>${pessoa.getEndereco().getCep()}</td>

                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
