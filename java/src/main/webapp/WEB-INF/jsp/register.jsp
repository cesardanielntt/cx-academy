<%--
  Created by IntelliJ IDEA.
<<<<<<< HEAD
  User: tiago
=======
  User: lucas
>>>>>>> origin/master
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
<<<<<<< HEAD
<h1 style="text-align: center">Página de cadastro</h1>

<body action="${pageContext.servletContext.contextPath}/pages/register" method=POST">
    <div class="row">
        <%--@declare id="nome"--%><label for="nome">Nome</label>
        <input type="text" name="nome" placeholder="Digite seu Nome"/>
    </div>
    <div class="row">
        <%--@declare id="sobrenome"--%><label for="sobrenome">Sobrenome</label>
        <input type="text" name="sobrenome" placeholder="Digite seu Sobrenome"/>
    </div>
    <div class="row">
        <%--@declare id="email"--%><label for="email">E-mail</label>
        <input type="text" name="email" placeholder="Digite seu E-mail"/>
    </div>
    <div class="row">
        <%--@declare id="idade"--%><label for="idade">Idade</label>
        <input type="text" name="idade" placeholder="Digite sua idade"/>
    </div>
    <h2 style="...">Endereço</h2>
    <div class="row">
        <%--@declare id="rua"--%><label for="rua">Rua</label>
        <input type="text" name="Rua" placeholder="Digite sua Rua"/>
    </div>
    <div class="row">
        <%--@declare id="numero"--%><label for="numero">Número</label>
        <input type="text" name="Número" placeholder="Digite seu Número"/>
    </div>
    <div class="row">
        <%--@declare id="complemento"--%><label for="complemento">Complemento</label>
        <input type="text" name="Complemento" placeholder="Digite seu Complemento"/>
    </div>
    <div class="row">
        <%--@declare id="bairro"--%><label for="bairro">Bairro</label>
        <input type="text" name="Bairro" placeholder="Digite seu Bairro"/>
    </div>
    <div class="row">
        <%--@declare id="cidade"--%><label for="cidade">Cidade</label>
        <input type="text" name="Cidade" placeholder="Digite sua Cidade"/>
    </div>
    <div class="row">
        <%--@declare id="estado"--%><label for="Estado">Estado</label>
        <input type="text" name="Estado" placeholder="Digite seu Estado"/>
    </div>
    <div class="row">
        <%--@declare id="cep"--%><label for="cep">CEP</label>
        <input type="text" name="CEP" placeholder="Digite seu CEP"/>
    </div>
=======
<body>
<h1 style="text-align: center">Página de Cadastro</h1>

<form action="${pageContext.servletContext.contextPath}/pages/register" method="POST">
    <div class="row">
        <label for="nome">Nome</label>
        <input type="text" name="nome" placeholder="Digite seu Nome"/>
        <jsp:include page="error.jsp">
            <jsp:param name="path" value="nome"/>
        </jsp:include>
    </div>
    <div class="row">
        <label for="sobrenome">Sobrenome</label>
        <input type="text" name="sobrenome" placeholder="Digite seu Sobrenome"/>
        <jsp:include page="error.jsp">
            <jsp:param name="path" value="sobrenome"/>
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
        <label for="idade">Idade</label>
        <input type="text" name="idade" placeholder="Digite sua idade"/>
        <jsp:include page="error.jsp">
            <jsp:param name="path" value="idade"/>
        </jsp:include>
    </div>
    <h3 style="text-align: center">Endereço</h3>
    <div class="row">
        <label for="rua">Rua</label>
        <input type="text" name="rua" placeholder="Digite sua rua"/>
        <jsp:include page="error.jsp">
            <jsp:param name="path" value="rua"/>
        </jsp:include>
    </div>
    <div class="row">
        <label for="numero">Número</label>
        <input type="number" name="numero" placeholder="Digite seu número"/>
        <jsp:include page="error.jsp">
            <jsp:param name="path" value="numero"/>
        </jsp:include>
    </div>
    <div class="row">
        <label for="complemento">Complemento</label>
        <input type="text" name="complemento" placeholder="Digite seu complemento"/>
        <jsp:include page="error.jsp">
            <jsp:param name="path" value="complemento"/>
        </jsp:include>
    </div>
    <div class="row">
        <label for="bairro">Bairro</label>
        <input type="text" name="bairro" placeholder="Digite seu bairro"/>
        <jsp:include page="error.jsp">
            <jsp:param name="path" value="bairro"/>
        </jsp:include>
    </div>
    <div class="row">
        <label for="cidade">Cidade</label>
        <input type="text" name="cidade" placeholder="Digite sua cidade"/>
        <jsp:include page="error.jsp">
            <jsp:param name="path" value="cidade"/>
        </jsp:include>
    </div>
    <div class="row">
        <label for="estado">Estado</label>
        <input type="text" name="estado" placeholder="Digite seu Estado"/>
        <jsp:include page="error.jsp">
            <jsp:param name="path" value="estado"/>
        </jsp:include>
    </div>
    <div class="row">
        <label for="cep">Cep</label>
        <input type="text" name="cep" placeholder="Digite seu Cep"/>
        <jsp:include page="error.jsp">
            <jsp:param name="path" value="cep"/>
        </jsp:include>
    </div>



    <button type="submit">Enviar</button>
</form>
>>>>>>> origin/master
</body>
</html>
