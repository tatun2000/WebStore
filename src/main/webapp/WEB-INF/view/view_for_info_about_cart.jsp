<%--
  Created by IntelliJ IDEA.
  User: Дмитрий
  Date: 17.01.2022
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8" />
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />"/>
</head>
<body>
    <c:set var="totalSum" value="${0}"/>
    <c:set var="i" value="${0}"/>
    <h1>CART:</h1>

    <c:forEach var="goods" items="${goodsInCart.entrySet()}">
        <c:forEach var="good" items="${goods.getValue()}">
            <c:set var="i" value="${i + 1}"/>

            <c:set var="totalSum" value="${totalSum + good.cost}"/>
            <c:if test="${i > 1}">

            </c:if>
            <c:if test="${i <= 1}">
                <span>${good.nameOfGoods}: ${good.cost} ₽</span>
            </c:if>
        </c:forEach>
        <span>  (Count = ${i})</span>
        <br>
        <c:set var="i" value="${0}"/>
    </c:forEach>
    <h2>Total sum = ${totalSum} ₽</h2>

    <c:url var="createOrder" value="/create_order">
        <c:param name="totalSum" value="${totalSum}"/>
    </c:url>
    <br><br>
    <input class="buttonForBuy" type="button" value="Buy"
           onclick="window.location.href = '${createOrder}'">
</body>
</html>
