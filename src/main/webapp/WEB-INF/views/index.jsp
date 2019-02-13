<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SPRIIING</title>

    <link rel="stylesheet" href="/resources/css/bootstrap.min.css"/>
    <script src="/resources/js/bootstrap.min.js"></script>

</head>
<body>
    <div class="container">

    <form method="post" action="/addItem">

        <p>Name: <input type="text" name="name" class="input-group-text">
        <p>Price: <input type="text" name="price" class="input-group-text">
        <p><button type="submit" class="btn-primary">ADD</button>

    </form>


    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>NAME</th>
            <th>PRICE</th>
            <th>EDIT</th>
        </tr>
        </thead>
        <tbody>
        <c:set var="sum" value="0"></c:set>
        <c:forEach items="${list}" var="items">


            <c:set var="sum" value="${sum + items.price}"></c:set>

            <tr>
                <td>
                        ${items.id}
                </td>
                <td>
                        ${items.name}
                </td>
                <td>
                        ${items.price}
                </td>
                <td>
                        <a href="/editPage?id=${items.id}">EDIT</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>

    </table>
    <p>Total: ${sum}
    </div>
</body>
</html>