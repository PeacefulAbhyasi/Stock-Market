<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Panel</title>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container" style="margin-top: 50px">
        <h3 style="text-align: center">ADD THE COMPANY WITH STOCK VALUE</h3>
        <form role="form" action="/addCompanyStock" method="post">
            <div class="input-group input-group-lg">
                <span class="input-group-addon">COMPANY NAME</span>
                <input type="text" name="companyName" class="form-control">
            </div>
            <br>
            <div class="input-group input-group-lg">
                <span class="input-group-addon">STOCK VALUE</span>
                <input type="text" name="stockValue" class="form-control">
            </div>
            <br>
            <button type="submit" class="btn btn-block btn-lg btn-info">SUBMIT COMPANY</button>
        </form>
    </div>

    <div class="container" style="margin-top: 50px">
        <h3 style="text-align: center">CHANGE THE STOCK VALUE OF THE COMPANY</h3>
        <form role="form" action="/changeCompanyStock" method="post">
            <div class="input-group input-group-lg">
                <span class="input-group-addon">COMPANY NAME</span>
                <input type="text" name="companyName" class="form-control">
            </div>
            <br>
            <div class="input-group input-group-lg">
                <span class="input-group-addon"> NEW STOCK VALUE</span>
                <input type="text" name="stockValue" class="form-control">
            </div>
            <br>
            <button type="submit" class="btn btn-block btn-lg btn-info">SUBMIT COMPANY NEW STOCK VALUE</button>
        </form>
    </div>
</body>
</html>
