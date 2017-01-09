<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>


<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Instagram</title>
    <link href="<c:url value="/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/css/style.css" />" rel="stylesheet">
    <link href="<c:url value="/css/favicon.ico" />" rel="icon">
</head>
<body>

<tiles:insertAttribute name="header"/>

<div class="main_body">
    <div class="container">
        <div class="row">

            <div class="col-md-3 col-sm-2 col-xs-1 "></div>

            <div class="col-md-6 col-sm-8 col-xs-10 content">

                <c:forEach items="${imageList}" var="image">
                    <div class="post_content">
                        <img class="image"
                             src="<c:out value="${image.baseURL}"/>/images/<c:out value="${image.filename}"/>"/>
                        <p><c:out value="${image.comment}"/></p>
                        <a href="delete/${image.id}">Delete</a>
                    </div>
                </c:forEach>


                <form method="post" action="fileUpLoad" enctype="multipart/form-data">
                    <div class="form-group">
                        ${message}12345
                        <br>
                        <label for="comment">Write your comment</label>
                        <textarea name="comment" id="comment" class="form-control" rows="10" cols="10"></textarea>
                    </div>
                    <div class="form-group">
                        <label for="files">Attach your image</label>
                        <input type="file" id="files" name="image">
                    </div>
                    <button type="submit" class="btn btn-danger pull-right">Submit</button>
                </form>


                <c:url var="firstUrl" value="/pages/1"/>
                <c:url var="lastUrl" value="/pages/${count}"/>
                <c:url var="prevUrl" value="/pages/${currentIndex - 1}"/>
                <c:url var="nextUrl" value="/pages/${currentIndex + 1}"/>

                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <c:choose>
                            <c:when test="${currentIndex == 1}">
                                <li class="disabled"><a href="#">&lt;&lt;</a></li>
                                <li class="disabled"><a href="#">&lt;</a></li>
                            </c:when>
                            <c:otherwise>
                                <li><a href="${firstUrl}">&lt;&lt;</a></li>
                                <li><a href="${prevUrl}">&lt;</a></li>
                            </c:otherwise>
                        </c:choose>
                        <c:forEach var="i" begin="${beginIndex}" end="${endIndex}">
                            <c:url var="pageUrl" value="/pages/${i}"/>
                            <c:choose>
                                <c:when test="${i == currentIndex}">
                                    <li class="active"><a href="${pageUrl}"><c:out value="${i}"/></a></li>
                                </c:when>
                                <c:otherwise>
                                    <li><a href="${pageUrl}"><c:out value="${i}"/></a></li>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                        <c:choose>
                            <c:when test="${currentIndex == count}">
                                <li class="disabled"><a href="#">&gt;</a></li>
                                <li class="disabled"><a href="#">&gt;&gt;</a></li>
                            </c:when>
                            <c:otherwise>
                                <li><a href="${nextUrl}">&gt;</a></li>
                                <li><a href="${lastUrl}">&gt;&gt;</a></li>
                            </c:otherwise>
                        </c:choose>
                    </ul>
                </nav>


                <div class="col-md-3 col-sm-2 col-xs-1 "></div>

            </div>
        </div>
    </div>

    <tiles:insertAttribute name="footer"/>
</body>
</html>


