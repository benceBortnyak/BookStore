<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <c:url value="/style.css" var="styleUrl"/>
        <c:url value="/index.js" var="indexScriptUrl"/>
        <c:url value="/Books.js" var="booksScriptUrl"/>
        <c:url value="/Cart.js" var="cartScriptUrl"/>
        <c:url value="Login.js" var="loginScriptUrl"/>
        <c:url value="logout.js" var="logoutScriptUrl"/>
        <c:url value="register.js" var="registerScriptUrl"/>
        <c:url value="order.js" var="orderScriptUrl"/>
        <link rel="stylesheet" type="text/css" href="${styleUrl}">
        <script src="${indexScriptUrl}"></script>
        <script src="${booksScriptUrl}"></script>
        <script src="${cartScriptUrl}"></script>
        <script src="${loginScriptUrl}"></script>
        <script src="${logoutScriptUrl}"></script>
        <script src="${registerScriptUrl}"></script>
        <script src="${orderScriptUrl}"></script>
        <title>Book Store</title>
    </head>
<body>
<div class="main">
    <div class="topnav">
        <ul id="navBarList">
            <li><a id="home">Home</a></li>
            <li><a id="cart">Cart</a></li>
            <li><a id="register">Register</a></li>
            <li id ="loginLi">
                <div id="loginDiv">
                    <form id="loginForm" onsubmit="return false;">
                        <label for="email">Email</label>
                        <input id="email" type="email" name="email" placeholder="example@gmail.com" required/>
                        <label for="password">Password</label>
                        <input id="password" type="password" name="password" required/>
                        <input type="submit" id ="loginButton" value="Login"/>
                    </form>
                </div>
            </li>
            <li id = "welcomeLi"></li>
            <li style="float:right"><a id="logoutBtn" class="hidden content" >Logout</a></li>
        </ul>
    </div>

    <div id="registerDiv" class="hidden content">
        <div id="signUp-content">
            <form accept-charset=utf-8 id='signUp-form' onsubmit="return false;">
                <h1>Register</h1>
                <label for="foreName">Forename</label>
                <input id ="foreName" type="text" name="foreName" required>
                <label for="lastName"> Last name</label>
                <input id = "lastName" type="text" name="lastName" required>
                <br>
                <label for="emailReg">Email</label>
                <input id = "emailReg" type="email" name="emailReg" required>
                <br>
                <label for = "passwordReg">Password</label>
                <input id="passwordReg" type="password" name="passwordReg"
                       pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" required title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"></p>
                <label for="passwordRegRe">Re-enter password</label>
                <input id ="passwordRegRe" type="password" name="passwordRegRe"
                              pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" required
                              title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters">
                <br>
                <button id='submitButton' type="submit">Register</button>
            </form>
        </div>
    </div>

    <div id="booksDiv" class="hidden content"></div>

    <div id="cartDiv" class="hidden content">

    </div>

    <div id="loginRegisterDiv" class="hidden content"></div>

    <div id = "userDetails" class="hidden content">
        <div id = "userForm" class="hidden content">
            <form accept-charset=utf-8 id='detailsForm' onsubmit="return false;">
                <h1>Details</h1>
                <label for="city">City</label>
                <input id ="city" type="text" name="city" required>
                <br>
                <label for="street">Street</label>
                <input id = "street" type="text" name="street" required>
                <br>
                <label for="ZipCode">Zip Code</label>
                <input id = "ZipCode" type="number" name="ZipCode" required>
                <br>
                <label for="streetNumber">Street Number</label>
                <input id = "streetNumber" type="number" name="streetNumber" required>
                <br>
                <button id='detailsButton' type="submit">Save</button>
            </form>
        </div>

        <div id="display" class="hidden content">

        </div>
        <div id="orderButtonDiv" class="hidden content">
            <button id='orderButton' type="submit">Order</button>
        </div>
    </div>

</div>
</body>
</html>
