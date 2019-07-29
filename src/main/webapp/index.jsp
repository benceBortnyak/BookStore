<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <c:url value="/style.css" var="styleUrl"/>
        <c:url value="/index.js" var="indexScriptUrl"/>
        <c:url value="/Books.js" var="booksScriptUrl"/>
        <c:url value="/Cart.js" var="cartScriptUrl"/>
        <c:url value="Login.js" var="loginScriptUrl"/>
        <link rel="stylesheet" type="text/css" href="${styleUrl}">
        <script src="${indexScriptUrl}"></script>
        <script src="${booksScriptUrl}"></script>
        <script src="${cartScriptUrl}"></script>
        <script src="${loginScriptUrl}"></script>
        <title>Book Store</title>
    </head>
<body>
<div class="main">
    <div class="topnav">
        <ul>
            <li><a id="home">Home</a></li>
            <li><a id="cart">Cart</a></li>
            <li><a id="login">Login</a></li>
            <li style="float:right"><a id="logout" >Logout</a></li>
        </ul>
    </div>

    <div id="booksDiv" class="hidden content">

    </div>

    <div id="cartDiv" class="hidden content">

    </div>
    <div id="loginRegisterDiv" class="hidden content">
        <form id="loginForm" onsubmit="return false;">
            <label for="email">Email</label>
            <input id="email" type="email" name="email" placeholder="example@gmail.com" required/>
            <label for="password">Password</label>
            <input id="password" type="password" name="password" required/>
            <input type="submit" id ="loginButton" value="Login"/>
        </form>
    </div>
</div>
</body>
</html>
