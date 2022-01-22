<%@ page import="java.io.File" %><%--
  Created by IntelliJ IDEA.
  User: Дмитрий
  Date: 02.01.2022
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <meta charset="utf-8" />
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />"/>
</head>
<body>
    <c:url var="createOrder" value="/form_order">
        <c:param name="totalSumOfOrder" value="${totalSumInCart}"/>
    </c:url>
    <h1>CATALOG</h1>
    <br>
    <input type="button" class="buttonClean" id="cleanCart" value="Clean Cart"
           onclick="window.location.href = '/clean_cart'"/>
    <input type="button" class="buttonCart" id="cart" value="Cart: ${totalSumInCart} rub" contenteditable="true"
            onclick="window.location.href = '${createOrder}'"/>

    <c:forEach var="good" items="${listOfGoods}">

        <c:url var="addToCart" value="/add_Cart">
            <c:param name="costOfGood" value="${good.cost}"/>
            <c:param name="totalSumInCart" value="${totalSumInCart}"/>
            <c:param name="idOfGood" value="${good.idGood}"/>
        </c:url>

        <security:authorize access="hasRole('ADMIN')">
        <c:url var="updateGood" value="/update_info">
            <c:param name="idGood" value="${good.idGood}"/>
        </c:url>
        <c:url var="deleteGood" value="/delete_good">
            <c:param name="idGood" value="${good.idGood}"/>
        </c:url>
        </security:authorize>
        <h2 class="nameOfGoods">${good.nameOfGoods}</h2>
        <div class="img">
            <img id="img" src="${good.pathToImage}" width="300px" height="300px">
        </div>

        <div class="info">
            <div>
                <br>
                <p class="infoAboutGood">${good.cost} ₽/ Add to cart
                <input type="image" onclick="window.location.href='${addToCart}'"
                       src="resources/images/cart.jpg" width="23px" height="23px">
                </p>
                <td>
                    <security:authorize access="hasRole('ADMIN')">
                        <input type="button" value="Change"
                               onclick="window.location.href = '${updateGood}'">
                    </security:authorize>
                    <security:authorize access="hasRole('ADMIN')">
                        <input type="button" value="Delete"
                               onclick="window.location.href = '${deleteGood}'">
                    </security:authorize>
                </td>
            </div>
        </div>
        <br>
    </c:forEach>
    <security:authorize access="hasRole('ADMIN')">
    <input type="button" value="New good"
           onclick="window.location.href = '/add_new_good'">
    </security:authorize>
</body>
</html>

