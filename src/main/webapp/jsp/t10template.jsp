<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html; charset=utf-8" %>
<%@ taglib uri="/tags" prefix="date"%>
<date:date value="${date}"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修真院官网</title>
    <link href="${pageContext.request.contextPath}/t10/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/bootstrap-3.3.5-dist/css/bootstrap.css">
    <link href="${pageContext.request.contextPath}/t10/Untitled-3.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/t10/Untitled-1base.css" rel="stylesheet" type="text/css">
</head>
<body>

<tiles:insertAttribute name="header"/>

<tiles:insertAttribute name="body"/>


<tiles:insertAttribute name="footer"/>

</body>
<script src="${pageContext.request.contextPath}/t10/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/t10/bootstrap.min.js"></script>
</html>