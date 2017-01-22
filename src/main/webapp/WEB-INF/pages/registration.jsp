<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Sign In</title>
    <link href="${contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/css/signin.css" rel="stylesheet">
    <link href="${contextPath}/css/style.css" rel="stylesheet">
    <link href="${contextPath}/css/favicon.ico" rel="icon">
</head>

<body>


<tiles:insertAttribute name="header"/>

<div class="container">


    <form:form method="POST" modelAttribute="userForm" class="form-signin">

        <form:errors path="username"></form:errors>
        <form:input type="text" path="username" class="form-control" placeholder="Username"
                    autofocus="true"></form:input>

        <form:errors path="password"></form:errors>
        <form:input type="password" path="password" class="form-control" placeholder="Password"></form:input>

        <form:errors path="confirmPassword"></form:errors>
        <form:input type="password" path="confirmPassword" class="form-control"
                    placeholder="Confirm your password"></form:input>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>

    </form:form>


</div> <!-- /container -->


<tiles:insertAttribute name="footer"/>

</body>
</html>

