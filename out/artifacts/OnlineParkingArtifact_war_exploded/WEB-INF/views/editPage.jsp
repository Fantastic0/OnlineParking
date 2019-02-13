<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css"/>
    <script src="/resources/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <form method="post" action="/editItem">

        <p><input type="hidden" name="id" value="${item.id}">
        <p>Name: <input type="text" name="name" value="${item.name}" class="input-group-text">
        <p>Price: <input type="text" name="price" value="${item.price}" class="input-group-text">
        <p><button type="submit" class="btn-primary">EDIT</button>

    </form>

    <p><a href="/deleteItem?id=${item.id}">DELETE</a>

</div>
</body>
</html>
