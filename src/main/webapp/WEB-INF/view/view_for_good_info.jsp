<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Дмитрий
  Date: 02.01.2022
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8" />
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />"/>
</head>
<body>
    <h2>Information about good</h2>

    <form:form action="/save_or_update_good" method="post" modelAttribute="good">
        <form:hidden path="idGood"/>

        Name Of Good <form:input path="nameOfGoods"/>
        <form:errors path="nameOfGoods"/>
        <br><br>

        Cost of good (₽)<form:input path="cost"/>
        <form:errors path="cost"/>
        <br><br>

        Path to image <form:input path="pathToImage"/>
        <form:errors path="pathToImage"/>
        <br><br><br>
        <input type="submit" value="ОК">
    </form:form>
</body>
</html>
