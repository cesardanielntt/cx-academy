<<<<<<< HEAD
=======
<%--
  Created by IntelliJ IDEA.
  User: Onilson Cardoso
  Date: 20/07/2021
  Time: 09:55
  To change this template use File | Settings | File Templates.
--%>
>>>>>>> master
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Pessoas</title>
<<<<<<< HEAD
    <jsp:include page="header.jsp"/>
=======
    <jsp:include page ="header.jsp"/>
>>>>>>> master
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
<<<<<<< HEAD
            <thead>
            <tr>
                <th class="id-collum">ID</th>
                <th>Nome</th>
                <th>Sobrenome</th>
                <th>E-mail</th>
                <th>Idade</th>
                <th>Rua</th>
                <th>Número</th>
                <th>Complemento</th>
                <th>Bairro</th>
                <th>Cidade</th>
                <th>Estado</th>
                <th>CEP</th>
            </thead>

            <tbody>
            <c:forEach items="${pessoas}" var="pessoa">
                <tr>
                    <td>${pessoa.id}</td>
                    <td>${pessoa.nome}</td>
                    <td>${pessoa.sobrenome}</td>
                    <td>${pessoa.email}</td>
                    <td>${pessoa.idade} anos</td>
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
=======
    <thead>
        <tr>
            <th class="id-collum">ID</th>
            <th>Nome</th>
            <th>Sobrenome</th>
            <th>E-mail</th>
            <th>Idade</th>
            <th>Rua</th>
            <th>Numero</th>
            <th>Complemento</th>
            <th>Bairro</th>
            <th>Cidade</th>
            <th>Estado</th>
            <th>Cep</th>

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
>>>>>>> master
