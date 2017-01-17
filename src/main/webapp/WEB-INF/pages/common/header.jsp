<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header class="header">
    <div class="container">
        <div class="row">
            <div class="avatar col-md-3 pull-left">
                <a href="<%=request.getContextPath()%>/"><p class="text-header">HOME</p></a>
            </div>
            <div class="col-md-9">

                <sec:authorize ifAnyGranted="ROLE_ANONYMOUS">
                    <a href="<%=request.getContextPath()%>/signin" style="margin-top:13px"  class="btn btn-success pull-right">SIGN IN</a>
                </sec:authorize>


                <sec:authorize ifAnyGranted="ROLE_USER">
                    <c:url var="logout" value="/j_spring_security_logout"/>
                    <a class="btn btn-success pull-right" href="${logout}" id="logOutButton" style="margin-top:13px" >Log Out</a>
                </sec:authorize>

            </div>
        </div>
    </div>
</header>

