<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="POST" modelAttribute="defaultUser">
    <form:input path="firstName"/>
    <form:input path="age"/>
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>
