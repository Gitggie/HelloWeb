<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>JSTL fmt:formatNumber 标签</title>
</head>
<body>
<h3>数字格式化:</h3>
<c:set var="balance" value="120000.2309" />
<p>格式化数字 (1): <fmt:formatNumber value="${balance}" type="currency"/></p>
<p>格式化数字 (2): <fmt:formatNumber type="number" maxIntegerDigits="3" value="${balance}" /></p>
<p>格式化数字 (3): <fmt:formatNumber type="number" maxFractionDigits="3" value="${balance}" /></p>
<p>格式化数字 (4): <fmt:formatNumber type="number" groupingUsed="false" value="${balance}" /></p>
<p>格式化数字 (5): <fmt:formatNumber type="percent" maxIntegerDigits="3" value="${balance}" /></p>
<p>格式化数字 (6): <fmt:formatNumber type="percent" minFractionDigits="10" value="${balance}" /></p>
<p>格式化数字 (7): <fmt:formatNumber type="percent" maxIntegerDigits="3" value="${balance}" /></p>
<p>格式化数字 (8): <fmt:formatNumber type="number" pattern="###.###E0" value="${balance}" /></p>
<p>美元 :
    <fmt:setLocale value="en_US"/>
    <fmt:formatNumber value="${balance}" type="currency"/></p>

<h3>数字解析:</h3>
<c:set var="balance" value="1250003.350" />

<fmt:parseNumber var="i" type="number" value="${balance}" />
<p>数字解析 (1) : <c:out value="${i}" /></p>
<fmt:parseNumber var="i" integerOnly="true" type="number" value="${balance}" />
<p>数字解析 (2) : <c:out value="${i}" /></p>

<h3>日期格式化:</h3>
<c:set var="now" value="<%=new java.util.Date()%>" />

<p>日期格式化 (1): <fmt:formatDate type="time" value="${now}" /></p>
<p>日期格式化 (2): <fmt:formatDate type="date" value="${now}" /></p>
<p>日期格式化 (3): <fmt:formatDate type="both" value="${now}" /></p>
<p>日期格式化 (4): <fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${now}" /></p>
<p>日期格式化 (5): <fmt:formatDate type="both" dateStyle="medium" timeStyle="medium" value="${now}" /></p>
<p>日期格式化 (6): <fmt:formatDate type="both" dateStyle="long" timeStyle="long" value="${now}" /></p>
<p>日期格式化 (7): <fmt:formatDate pattern="yyyy-MM-dd" value="${now}" /></p>

<h3>日期解析:</h3>
<c:set var="now" value="20-10-2015" />

<fmt:parseDate value="${now}" var="parsedEmpDate" pattern="dd-MM-yyyy" />
<p>解析后的日期为: <c:out value="${parsedEmpDate}" /></p>
</body>
</html>