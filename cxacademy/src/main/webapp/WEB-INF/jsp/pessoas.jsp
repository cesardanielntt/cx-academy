<%--
  Created by IntelliJ IDEA.
  User: leand
  Date: 20/07/2021
  Time: 09:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Pessoas</title>
    <jsp:include page="header.jsp"></jsp:include>
</head>
<body>
    <c:forEach items="${pessoas}" var="pessoa">
        <h3>Nome: </h3>
        <b>${pessoa.name}</b>
        <h3>Sobrenome: </h3>
        <b>${pessoa.lastName}</b>
        <h3>Email: </h3>
        <b>${pessoa.email}</b>
        <h3>Idade: </h3>
        <b>${pessoa.age}</b>
    </c:forEach>
</body>
</html>
