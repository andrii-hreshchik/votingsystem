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

<%--Modal window edit Meal--%>
<div class="modal fade" id="editRow" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Create/Update meal</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form id="detailsForm">
                    <input type="hidden" id="id" name="id">

                    <div class="form-group">
                        <label for="description" class="col-form-label">Description:</label>
                        <input type="text" class="form-control" id="description" name="description" placeholder="Description">
                    </div>

                    <div class="form-group">
                        <label for="price" class="col-form-label">Price:</label>
                        <input type="text" class="form-control" id="price" name="price"
                               placeholder="Price">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" onclick="save()">Save changes</button>
            </div>
        </div>
    </div>
</div>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
