<%--
  Created by IntelliJ IDEA.
<<<<<<< HEAD
  User: Leandro Rocha
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
<<<<<<< HEAD
    <title>Página de cadastro</title>
=======
    <title>Title</title>
>>>>>>> origin/master
    <jsp:include page="header.jsp"/>
</head>
<body>
<h1 style="text-align: center">Página de Cadastro</h1>

<form action="${pageContext.servletContext.contextPath}/pages/register" method="POST">
    <div class="row">
        <label for="nome">Nome</label>
<<<<<<< HEAD
        <input type="teste" name="nome" placeholder="Digite seu nome">
=======
        <input type="text" name="nome" placeholder="Digite seu Nome"/>
>>>>>>> origin/master
        <jsp:include page="error.jsp">
            <jsp:param name="path" value="nome"/>
        </jsp:include>
    </div>
    <div class="row">
<<<<<<< HEAD
        <label for="sobrenome">sobrenome</label>
        <input type="text" name="sobrenome" placeholder="Digite seu sobrenome">
=======
        <label for="sobrenome">Sobrenome</label>
        <input type="text" name="sobrenome" placeholder="Digite seu Sobrenome"/>
>>>>>>> origin/master
        <jsp:include page="error.jsp">
            <jsp:param name="path" value="sobrenome"/>
        </jsp:include>
    </div>
    <div class="row">
<<<<<<< HEAD
        <label for="email">Email</label>
        <input type="email" name="email" placeholder="digite seu email">
=======
        <label for="email">E-mail</label>
        <input type="text" name="email" placeholder="Digite seu E-mail"/>
>>>>>>> origin/master
        <jsp:include page="error.jsp">
            <jsp:param name="path" value="email"/>
        </jsp:include>
    </div>
    <div class="row">
        <label for="idade">Idade</label>
<<<<<<< HEAD
        <input type="number" name="idade" placeholder="Digite sua idade">

    </div>
    <div class="row">
        <label for="rua">Rua</label>
        <input type="text" name="rua" placeholder="Digite sua rua">
        <jsp:include page="error.jsp">
            <jsp:param name="path" value="rua"/>
        </jsp:include>
    </div>
    <div class="row">
        <label for="numero">Número</label>
        <input type="number" name="numero" placeholder="Digite o número da sua residência">
    </div>
    <div class="row">
        <label for="complemento">Complemento</label>
        <input type="text" name="complemento" placeholder="Digite o complemento">
        <jsp:include page="error.jsp">
            <jsp:param name="path" value="complemento"/>
        </jsp:include>
    </div>
    <div class="row">
        <label for="bairro">Bairro</label>
        <input type="text" name="bairro" placeholder="Digite seu bairro">
        <jsp:include page="error.jsp">
            <jsp:param name="path" value="bairro"/>
        </jsp:include>
    </div>
    <div class="row">
        <label for="cidade">Cidade</label>
        <input type="text" name="cidade" placeholder="Digite a cidade onde você mora">
        <jsp:include page="error.jsp">
            <jsp:param name="path" value="cidade"/>
        </jsp:include>
    </div>
    <div class="row">
        <label for="estado">Estado</label>
        <input type="text" name="estado" placeholder="Digite o estado onde você mora">
        <jsp:include page="error.jsp">
            <jsp:param name="path" value="estado"/>
        </jsp:include>
    </div>
    <div class="row">
        <label for="cep">CEP</label>
        <input  type="number" name="cep" placeholder="Digite sue cep">
    <!-- a mascara de cep não funcionou, não consegui identificar o erro-->
    </div>
=======
        <input type="number" name="idade" placeholder="Digite sua Idade"/>
    </div>

>>>>>>> origin/master
    <button type="submit">Enviar</button>
</form>
</body>
</html>
<<<<<<< HEAD


=======
>>>>>>> origin/master
