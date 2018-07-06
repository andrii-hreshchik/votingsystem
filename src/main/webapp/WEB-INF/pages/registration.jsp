<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html>

<head>
    <title>Регистрация</title>

    <jsp:include page="fragments/headTagFragments.jsp"/>

    <link rel="stylesheet" href="resources/css/register.css"/>

</head>

<body class="text-center">
<%--<form class="form-signin">--%>
    <form:form modelAttribute="userTo" method="post" action="register"
               charset="utf-8" acceptCharset="UTF-8">

        <img class="mb-4" src="/resources/images/pencil.png" alt="" width="72" height="72">
        <h1 class="h3 mb-3 font-weight-normal">Registration</h1>

        <label for="name" class="sr-only">Name</label>
        <form:input path="name" name="name" id="name" placeholder="Your name" class="form-control"/>

        <label for="email" class="sr-only">Email</label>
        <form:input path="email" name="email" id="email" placeholder="you@example.com" class="form-control"/>

        <label for="password" class="sr-only">Password</label>
        <form:input path="password" name="password" id="password" placeholder="Your password" class="form-control" inputType="password"/>

        <button class="btn btn-lg btn-block btn-outline-primary" type="submit">Register</button>

    </form:form>
<%--</form>--%>
</body>
</html>
