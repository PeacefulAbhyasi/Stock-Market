<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LOGIN HERE</title>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
<center><h1>STOCK MARKET LOGIN</h1></center>

<c:if test="${ERROR == 'YES' }">
    <div class="container">
        <div class="alert alert-danger">
            <c:out value="${MESSAGE}"/>
        </div>
    </div>
</c:if>
<div class="container" style="margin-top: 100px">
    <form role="form" action="/login" method="post">
        <div class="input-group input-group-lg">
            <span class="input-group-addon glyphicon glyphicon-user"></span>
            <input type="text" style="margin-top: 2px" name="userName" class="form-control" placeholder="USERNAME@DOMAIN.COM">
        </div>
        <br>
        <div class="input-group input-group-lg">
            <span class="input-group-addon glyphicon glyphicon-lock"></span>
            <input type="password" style="margin-top: 2px"name="password" class="form-control" placeholder="PASSWORD">
        </div>
        <br>
        <button type="submit" class="btn btn-block btn-lg btn-info">SUBMIT</button>
    </form>
</div>
</body>
</html>
