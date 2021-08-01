<%--
  Created by IntelliJ IDEA.
<<<<<<< HEAD
  User: AlphaPlayerOne
  Date: 19/07/21
=======
  User: Onilson
  Date: 19/07/2021
>>>>>>> master
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
<<<<<<< HEAD
        <input type="text" name="email" placeholder="Digite seu E-mail"/>
=======
        <input type="email" name="email" placeholder="Digite seu E-mail"/>
>>>>>>> master
        <jsp:include page="error.jsp">
            <jsp:param name="path" value="email"/>
        </jsp:include>
    </div>
    <div class="row">
        <label for="idade">Idade</label>
        <input type="number" name="idade" placeholder="Digite sua Idade"/>
    </div>
<<<<<<< HEAD
    <h1 style="text-align: center">Endereço</h1>
    <div class="row">
        <label for="rua">Rua</label>
        <input type="text" name="rua" placeholder="Digite sua Rua"/>
=======

    <div class="row">
        <label for="rua">Rua</label>
        <input type="text" name="rua" placeholder="Digite a rua">
>>>>>>> master
        <jsp:include page="error.jsp">
            <jsp:param name="path" value="rua"/>
        </jsp:include>
    </div>
    <div class="row">
<<<<<<< HEAD
        <label for="numero">Número</label>
        <input type="number" name="numero" placeholder="Digite o Número"/>
    </div>
    <div class="row">
        <label for="complemento">Complemento</label>
        <input type="text" name="complemento" placeholder="Digite o Complemento"/>
=======
        <label for="numero">Numero</label>
        <input type="number" name="numero" placeholder="Digite o número ">
    </div>
    <div class="row">
        <label for="complemento">Complemento</label>
        <input type="text" name="complemento" placeholder="Digite o complemento">
>>>>>>> master
        <jsp:include page="error.jsp">
            <jsp:param name="path" value="complemento"/>
        </jsp:include>
    </div>
    <div class="row">
        <label for="bairro">Bairro</label>
<<<<<<< HEAD
        <input type="text" name="bairro" placeholder="Informe o seu Bairro"/>
=======
        <input type="text" name="bairro" placeholder="Digite o bairro">
>>>>>>> master
        <jsp:include page="error.jsp">
            <jsp:param name="path" value="bairro"/>
        </jsp:include>
    </div>
    <div class="row">
        <label for="cidade">Cidade</label>
<<<<<<< HEAD
        <input type="text" name="cidade" placeholder="Informe a sua Cidade"/>
=======
        <input type="text" name="cidade" placeholder="Digite a cidade">
>>>>>>> master
        <jsp:include page="error.jsp">
            <jsp:param name="path" value="cidade"/>
        </jsp:include>
    </div>
    <div class="row">
        <label for="estado">Estado</label>
<<<<<<< HEAD
        <input type="text" name="estado" placeholder="Informe o seu Bairro"/>
=======
        <input type="text" name="estado" placeholder="Digite o estado">
>>>>>>> master
        <jsp:include page="error.jsp">
            <jsp:param name="path" value="estado"/>
        </jsp:include>
    </div>
    <div class="row">
<<<<<<< HEAD
        <label for="cep">CEP</label>
        <input type="number" name="cep" placeholder="Informe o seu CEP"/>
=======
        <label for="cep">Cep</label>
        <input type="text" class="cep" name="cep" placeholder="Digite o cep">
>>>>>>> master
    </div>

    <button type="submit">Enviar</button>
</form>
</body>
</html>
