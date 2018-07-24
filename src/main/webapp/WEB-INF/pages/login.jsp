<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>

    <title>Страница входа</title>

    <jsp:include page="fragments/headTagFragments.jsp"/>

    <link rel="stylesheet" href="resources/css/signin.css"/>

</head>

<body class="text-center">

<form class="form-signin" action="spring_security_check" method="post">

    <img class="mb-4" src="/resources/images/dish.png" alt="" width="72" height="72">
    <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>

    <label for="inputName" class="sr-only">User email</label>
    <input type="text" id="inputName" name="username" class="form-control" placeholder="Your email" required
           autofocus>

    <label for="inputPassword" class="sr-only">Password</label>
    <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Your password"
           required>

    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>

    <a class="btn btn-lg btn-block btn-outline-primary" href="register">Sign up</a>

    <%--<button class="btn btn-lg btn-primary btn-block" type="submit" onclick=login("user@gmail.com","password")>Login as--%>
        <%--User--%>
    <%--</button>--%>
    <%--<button class="btn btn-lg btn-primary btn-block" type="submit" onclick=login("admin@gmail.com","password")>Login as--%>
        <%--Admin--%>
    <%--</button>--%>

    <br/><br/>
    <p>Available roles:</p>

    <b>ROLE_ADMIN</b> <br/>
    Login: <span style="color: royalblue">admin@gmail.com</span> Password: <span style="color: royalblue">password</span>
    <br/>
    <b>ROLE_USER</b> <br/>
    Login: <span style="color: royalblue">user@gmail.com</span> Password: <span style="color: royalblue">password</span>

</form>
</body>
<%--<script>--%>
    <%--function login(email, password) {--%>
        <%--$('input[name="username"]').val(email);--%>
        <%--$('input[name="password"]').val(password);--%>
    <%--}--%>
<%--</script>--%>

</html>
