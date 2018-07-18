<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!doctype html>
<html>
<head>
    <title>Restaurants list</title>
    <jsp:include page="fragments/headTagFragments.jsp"/>
    <link href="resources/css/restaurant.css" rel="stylesheet">
</head>

<body>
<%--Navigation bar--%>
<jsp:include page="fragments/navbar.jsp"/>

<%--Spring Security principal--%>
<sec:authentication var="principal" property="principal"/>

<%--Restaurant DataTable Spript--%>
<script src="resources/js/restaurantDT.js"></script>

<main role="main">
    <div class="jumbotron">
        <div class="container">
            <h1 class="display-3"><b>Hello, ${principal.userTo.name}</b></h1>
            <p>This is a template for a simple marketing or informational website. It includes a large callout called a
                jumbotron and three supporting pieces of content. Use it as a starting point to create something more
                unique.</p>
        </div>
    </div>
    <div class="container">
        <table class="table table-striped" id="restaurant_datatable">
            <thead>
            <tr>
                <th>Title</th>
                <th>Description</th>
                <th>Menu price</th>
                <th>Votes today</th>
                <th>Votes overall</th>
                <th>Show menu of the day</th>
                <th>Vote</th>
            </tr>
            </thead>
        </table>
    </div>
</main>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>