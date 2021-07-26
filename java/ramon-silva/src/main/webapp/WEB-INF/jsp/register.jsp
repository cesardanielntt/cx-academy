<%--
  Created by IntelliJ IDEA.
  User: ramon
  Date: 19/07/2021
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1 style="text-align: center" >Pagina de Cadastro</h1>
    <jsp:include page="header.jsp"></jsp:include>


<form action="${pageContext.servletContext.contextPath}/pages/register" method="post">
        <div class="row">
            <label for="nome">Nome</label>
            <input type="text" name="nome" placeholder="Digite seu nome" />
            <jsp:include page="error.jsp">
                <jsp:param name="path" value="nome"/>
            </jsp:include>
        </div>
        <div class="row">
            <label for="sobrenome">Sobrenome</label>
            <input type="text" name="sobrenome" placeholder="Digite seu sobrenome" />
            <jsp:include page="error.jsp">
                <jsp:param name="path" value="sobrenome"/>
            </jsp:include>
        </div>
        <div class="row">
            <label for="email">Email</label>
            <input type="email" name="email" placeholder="Digite seu email" />
            <jsp:include page="error.jsp">
                <jsp:param name="path" value="email"/>
            </jsp:include>
        </div>
        <div class="row">
            <label for="idade">Idade</label>
            <input type="number" name="idade" placeholder="Digite sua idade" />
        </div>
        <div class="row">
            <label for="rua">Rua</label>
            <input type="text" name="rua" placeholder="Digite sua rua" />
            <jsp:include page="error.jsp">
                <jsp:param name="path" value="rua"/>
            </jsp:include>
        </div>
        <div class="row">
            <label for="numero">Numero</label>
            <input type="number" name="numero" placeholder="Digite seu número" />
        </div>
        <div class="row">
            <label for="complemento">Complemento</label>
            <input type="text" name="complemento" placeholder="Digite o comlemento" />
            <jsp:include page="error.jsp">
                <jsp:param name="path" value="complemento"/>
            </jsp:include>
        </div>
        <div class="row">
            <label for="bairro">Bairro</label>
            <input type="text" name="bairro" placeholder="Digite seu bairro" />
            <jsp:include page="error.jsp">
                <jsp:param name="path" value="bairro"/>
            </jsp:include>
        </div>
        <div class="row">
            <label for="cidade">Cidade</label>
            <input type="text" name="cidade" placeholder="Digite sua cidade" />
            <jsp:include page="error.jsp">
                <jsp:param name="path" value="cidade"/>
            </jsp:include>
        </div>
        <div class="row">
            <label for="estado">Estado</label>
            <input type="text" name="estado" placeholder="Digite seu estado" />
            <jsp:include page="error.jsp">
                <jsp:param name="path" value="estado"/>
            </jsp:include>
        </div>
        <div class="row">
            <label for="cep">Cep</label>
            <input type="number" name="cep" placeholder="Digite seu cep" />
        </div>

        <button type="submit">Enviar</button>
    </form>
</body>
</html>
