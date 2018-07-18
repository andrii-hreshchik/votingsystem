<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create/Update Meals</title>

    <jsp:include page="fragments/headTagFragments.jsp"/>
</head>
<body>

<%--Navigation bar--%>
<jsp:include page="fragments/navbar.jsp"/>

<script>
var restaurantId = <c:out value="${restaurantId}" />
</script>

<br>
<br>
<br>
<br>

<%--Admin Menu DataTable Spript--%>
<script src="resources/js/updateMenuDT.js"></script>

<div class="container">
    <table class="table table-striped" id="admin_menu_datatable">
        <thead>
        <tr>
            <th>Description</th>
            <th>Price</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
    </table>
</div>


</body>
</html>
