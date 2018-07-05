<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <title>Рестораны</title>
    <jsp:include page="fragments/headTagFragments.jsp"/>
    <link href="resources/css/restaurant.css" rel="stylesheet">
</head>

<body>
<!-- Navigation bar -->
<jsp:include page="fragments/navbar.jsp"/>
<!-- DataTable JS-->
<main role="main">
    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
        <div class="container">
            <h1 class="display-3">Hello, world!</h1>
            <p>This is a template for a simple marketing or informational website. It includes a large callout called a
                jumbotron and three supporting pieces of content. Use it as a starting point to create something more
                unique.</p>
            <p><a class="btn btn-primary btn-lg" href="#" role="button">Learn more &raquo;</a></p>
        </div>
    </div>

    <!-- DataTable-->
    <script>
        $(document).ready(function () {
            $('#datatable').DataTable()
        });
    </script>
       <div class="container">
        <table class="table table-striped" id="datatable">
            <thead>
            <tr>
                <th>Название</th>
                <th>Описание</th>
                <th>ID</th>
            </tr>
            </thead>
        </table>
        <hr>
    </div>
</main>


<jsp:include page="fragments/footer.jsp"/>
</body>
</html>