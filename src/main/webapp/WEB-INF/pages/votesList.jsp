%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <jsp:include page="fragments/headTagFragments.jsp"/>
    <title>Votes</title>
</head>
<body>
List of the votes

<div class="container">
    <table class="table table-striped" id="votes_datatable">
        <thead>
        <tr>
            <th>ID</th>
            <th>Date</th>
        </tr>
        </thead>
    </table>
</div>
<script>
    $(document).ready(function () {
        $('#votes_datatable').DataTable({
            ajax: {
                url: '/ajax/votes',
                dataSrc: ''
            },
            rowId: 'id',
            columns: [
                {data: 'id'},
                {data: 'date'}
            ]
        })
    });
</script>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
