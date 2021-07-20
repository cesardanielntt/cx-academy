<%--
  Created by IntelliJ IDEA.
  User: Karoline
  Date: 20/07/2021
  Time: 12:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>>

<c:if test="${formErrors[param.path] != null}">
    <div class="error">
        <span>${formErrors[param.path]}</span>
    </div>
</c:if>

