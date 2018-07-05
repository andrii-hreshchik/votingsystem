<%--region Description--%>
<%--<editor-fold desc="Description">--%>
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

    <img class="mb-4" src="/resources/images/logo.png" alt="" width="72" height="72">
    <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>

    <label for="inputName" class="sr-only">User email</label>
    <input type="text" id="inputName" name="username" class="form-control" placeholder="Your email" required
           autofocus>

    <label for="inputPassword" class="sr-only">Password</label>
    <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Your password"
           required>

    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    <button class="btn btn-lg btn-block btn-outline-primary" type="submit">Sign up</button>


    <button class="btn btn-lg btn-primary btn-block" type="submit">Login as User</button>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Login as Admin</button>

    <p class="mt-5 mb-3 text-muted">&copy; 2018</p>
</form>

</body>
</html>
<%--</editor-fold>--%>
<%--endregion--%>