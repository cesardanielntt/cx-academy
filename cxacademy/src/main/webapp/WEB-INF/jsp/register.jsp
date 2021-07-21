<%--
  Created by IntelliJ IDEA.
  User: lucas
  Date: 19/07/2021
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="header.jsp"/>
</head>
<body>
<h1 style="text-align: center">Página de Cadastro</h1>

<form action="${pageContext.servletContext.contextPath}/pages/register" method="POST">
    <div class="row">
        <label for="name">Nome</label>
        <input type="text" name="name" placeholder="Digite seu Nome"/>
        <jsp:include page="error.jsp">
            <jsp:param name="path" value="name"/>
        </jsp:include>
    </div>
    <div class="row">
        <label for="last-name">Sobrenome</label>
        <input type="text" name="last-name" placeholder="Digite seu Sobrenome"/>
        <jsp:include page="error.jsp">
            <jsp:param name="path" value="last-name"/>
        </jsp:include>
    </div>
    <div class="row">
        <label for="email">E-mail</label>
        <input type="text" name="email" placeholder="Digite seu E-mail"/>
        <jsp:include page="error.jsp">
            <jsp:param name="path" value="email"/>
        </jsp:include>
    </div>
    <div class="row">
        <label for="age">Idade</label>
        <input type="number" name="age" placeholder="Digite sua Idade"/>
    </div>
    <h2>Endereco</h2>
    <div class="row">
        <label for="street">Logradouro</label>
        <input type="text" name="street" placeholder="Rua"/>
        <jsp:include page="error.jsp">
            <jsp:param name="path" value="street"/>
        </jsp:include>
    </div>
    <div class="row">
        <label for="number">Numero</label>
        <input type="text" name="number" placeholder="Numero"/>
        <jsp:include page="error.jsp">
            <jsp:param name="path" value="number"/>
        </jsp:include>
    </div>
    <div class="row">
        <label for="complement">Complemento</label>
        <input type="text" name="complement" placeholder="Complemento"/>
        <jsp:include page="error.jsp">
            <jsp:param name="path" value="complement"/>
        </jsp:include>
    </div>
    <div class="row">
        <label for="district">Bairro</label>
        <input type="text" name="district" placeholder="Bairro"/>
        <jsp:include page="error.jsp">
            <jsp:param name="path" value="district"/>
        </jsp:include>
    </div>
    <div class="row">
        <label for="city">Cidade</label>
        <input type="text" name="city" placeholder="Cidade"/>
        <jsp:include page="error.jsp">
            <jsp:param name="path" value="city"/>
        </jsp:include>
    </div>
    <div class="row">
        <label for="state">Estado</label>
        <input type="text" name="state" placeholder="State"/>
        <jsp:include page="error.jsp">
            <jsp:param name="path" value="state"/>
        </jsp:include>
    </div>
    <div class="row">
        <label for="cep">CEP</label>
        <input class="cep" type="text" name="cep" placeholder="CEP"/>
        <jsp:include page="error.jsp">
            <jsp:param name="path" value="cep"/>
        </jsp:include>
    </div>
    <input type="submit" value="Enviar">
</form>
</body>
</html>
