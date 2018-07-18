<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <a class="navbar-brand" href="#">Restaurant voting system</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault"
            aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/restaurants">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Link</a>
            </li>
            <li class="nav-item">
                <a class="nav-link disabled" href="#">Disabled</a>
            </li>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
            <li class="nav-item dropdown active">
                <a class="nav-link dropdown-toggle" href="http://example.com" id="dropdown01" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">Admin</a>
                <div class="dropdown-menu" aria-labelledby="dropdown01">
                    <a class="dropdown-item" href="/administration">Create\Update Restaurant</a>
                    <a class="dropdown-item" href="#">Update daily menu</a>
                    <a class="dropdown-item" href="/populateDB"> <span style="color: red; ">Reset database</span></a>
                </div>
            </li>
            </sec:authorize>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <a class="btn btn-outline-success my-2 my-sm-0" href="/logout">Logout</a>
        </form>
    </div>
</nav>