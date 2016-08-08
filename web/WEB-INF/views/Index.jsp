<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Stock Market</title>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">STOCK MARKET</a>
            </div>
            <ul class="nav navbar-nav">
                <li><a href="/adminPanel">ADMIN PANEL</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/registrationForm"><span class="glyphicon glyphicon-user"></span> Register</a></li>
                <li><a href="/loginForm"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
            </ul>
        </div>
    </nav>
    <c:forEach var="companyStock" items="${companyStocks}">
        <div class="container">
            <div class="list-group">
                <a href="#" class="list-group-item">
                    <h3 class="list-group-item-heading">${companyStock.companyName}</h3>
                    <h3 class="list-group-item-text">${companyStock.stockValue}</h3>
                </a>
            </div>
        </div>
    </c:forEach>
</body>
</html>
