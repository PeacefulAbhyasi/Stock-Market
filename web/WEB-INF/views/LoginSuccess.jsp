<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
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
            <div class="dropdown">
                <button style="margin-top: 7px; margin-right: 7px; " class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">
                    MENU &nbsp;<span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                    <li><a href="#">${person.firstName}</a></li>
                    <li><a href="#">${person.lastName}</a></li>
                    <li><a href="#">${person.userName}</a></li>
                    <li><a href="/logOut">Logout</a></li>
                </ul>
            </div>
        </ul>
    </div>
</nav>

<div class="container">
    <div class="row">
        <div class="col-sm-6">
            <h2>YOUR SUBSCRIPTIONS</h2>
            <c:forEach var="companyStock" items="${subscriptions}">
                <div class="list-group">
                    <a href="#" class="list-group-item">
                        <h3 class="list-group-item-heading">${companyStock.companyName}</h3>
                        <h3 class="list-group-item-text">${companyStock.stockValue}</h3>
                    </a>
                </div>
            </c:forEach>
        </div>
        <div class="col-sm-6">
            <h2>SUBSCRIBE FROM HERE</h2>
            <c:forEach var="companyStock" items="${nonSubscriptions}">
                <li class="list-group-item">
                    <h3 class="list-group-item-heading">${companyStock.companyName}</h3>
                    <h3 class="list-group-item-text">${companyStock.stockValue}</h3>
                    <button style="margin-left: 400px" onclick="sendPostRequest(${companyStock.companyId},${person.personId})" class="btn btn-info">SUBSCRIBE</button>
                </li>
            </c:forEach>
        </div>
    </div>
</div>
<script>
    function sendPostRequest(companyId,personId) {
        var companyId  = companyId;
        var personId = personId;
        var json = {
            companyId : companyId,
            personId : personId
        };
        $.ajax({
            url: '/addSubscription',
            data: JSON.stringify(json),
            type: "POST",
            beforeSend: function(xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-Type", "application/json");
            },
            success: function(data){
                alert(data);
            }
        });
        event.preventDefault();
    }
</script>
</body>
</html>
