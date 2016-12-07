<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>findUser</h1>
<table>
    <c:forEach items="${users}" var="u">
        <tr>
            <td>${u.firstname}</td>
            <td>${u.lastname}</td>
            <td>${u.phone}</td>
            <td>${u.email}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>