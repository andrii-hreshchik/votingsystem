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
            <p> This is a voting system for deciding where to have lunch.
                It has two types of users: admin and regular users.
                Admin can input a restaurant and it's lunch menu of the day.
                Users can vote on which restaurant they want to have lunch at.
                Only one vote per day is available for user.</p>
        </div>
    </div>
    <div class="container">
        <table class="table table-striped text-center" id="restaurant_datatable">
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

    <%-- Modal vote window--%>
    <div class="modal fade" id="modalVote" tabindex="-1" role="dialog"
         aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="modalTitle">Confirm vote</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                    <input type="hidden" id="restId" name="id" value="">
                <div class="modal-body">
                    User can vote only once a day.
                    Please, confirm your voting on a restaurant.
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                    <button type="button" class="btn btn-primary" onclick="save()">Confirm</button>
                </div>
            </div>
        </div>
    </div>

</main>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>