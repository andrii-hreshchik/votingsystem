<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html>

<head>
    <title>Restaurants administration</title>

    <jsp:include page="fragments/headTagFragments.jsp"/>
    <link href="resources/css/restaurant.css" rel="stylesheet">

</head>

<body>
<%--Navigation bar--%>
<jsp:include page="fragments/navbar.jsp"/>

<%--Admin DataTable Spript--%>
<script src="resources/js/adminDT.js"></script>

<br><br><br>

<button type="submit" class="btn btn-primary" onclick="createRestaurant()">Create new restaurant</button>

<div class="container">
    <table class="table table-striped text-center" id="admin_datatable">
        <thead>
        <tr>
            <th>Title</th>
            <th>Description</th>
            <th>Date registered</th>
            <th>Menu price</th>
            <th>Votes today</th>
            <th>Votes overall</th>
            <th>Update menu</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
    </table>
</div>

<%--Modal window edit Restaurant--%>
<div class="modal fade" id="editRow" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="modalTitle">Update restaurant</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form id="detailsForm">
                    <input type="hidden" id="id" name="id">
                    <div class="form-group">
                        <label for="title" class="col-form-label">Title:</label>
                        <input type="text" class="form-control" id="title" name="title" placeholder="Min 3 symbols">
                    </div>

                    <div class="form-group">
                        <label for="description" class="col-form-label">Description:</label>
                        <input type="text" class="form-control" id="description" name="description"
                               placeholder="Min 5 symbols">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" onclick="save()">Save</button>
            </div>
        </div>
    </div>
</div>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
