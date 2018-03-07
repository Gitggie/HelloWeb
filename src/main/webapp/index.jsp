<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h1><a href="${pageContext.request.contextPath}/login">登录</a></h1>


<h1>&lt;c:out&gt; 实例</h1>
<c:out value="&lt要显示的数据对象（未使用转义字符）&gt" escapeXml="true" default="默认值"></c:out><br/>
<c:out value="&lt要显示的数据对象（使用转义字符）&gt" escapeXml="false" default="默认值"></c:out><br/>
<c:out value="${null}" escapeXml="false">使用的表达式结果为null，则输出该默认值</c:out><br/>

<c:set var="salary" scope="session" value="${2000*2}"/>
<c:out value="${salary}"/>
<p>salary 变量值: <c:out value="${salary}"/></p>
<c:remove var="salary"/>
<p>删除 salary 变量后的值: <c:out value="${salary}"/></p>

<c:catch var="catchException">
    <% int x = 5 / 0;%>
</c:catch>

<c:if test="${catchException != null}">
    <p>异常为 : ${catchException} <br/>
        发生了异常: ${catchException.message}</p>
</c:if>

<c:set var="salary" scope="session" value="${2000*2}"/>
<c:if test="${salary > 2000}">
    <p>我的工资为: <c:out value="${salary}"/><p>
</c:if>

<p>你的工资为 : <c:out value="${salary}"/></p>
<c:choose>
    <c:when test="${salary <= 0}">
        太惨了。
    </c:when>
    <c:when test="${salary > 1000}">
        不错的薪水，还能生活。
    </c:when>
    <c:otherwise>
        什么都没有。
    </c:otherwise>
</c:choose><br/>
<%--<c:import var="data" url="http://www.runoob.com"/>--%>
<%--<c:out value="${data}"/>--%>

<c:forEach var="i" begin="1" end="5">
    Item <c:out value="${i}"/><p>
</c:forEach>

<c:forTokens items="google,runoob,taobao" delims="," var="name">
    <c:out value="${name}"/><p>
</c:forTokens>

<%--<h1>&lt;c:param&gt; 实例</h1>--%>
<%--<c:url var="myURL" value="${pageContext.request.contextPath}/jsp/m.jsp">--%>
<%--<c:param name="name" value="Runoob"/>--%>
<%--<c:param name="url" value="www.runoob.com"/>--%>
<%--</c:url>--%>
<%--<a href="/<c:out value="${myURL}"/>">--%>
<%--使用 &lt;c:param&gt; 为指定URL发送两个参数。</a>--%>

<%--<c:redirect url="http://www.runoob.com"/>--%>

<h1>&lt;c:url&gt实例 Demo</h1>
<a href="<c:url value="http://www.baidu.com"/>">
    这个链接通过 &lt;c:url&gt; 标签生成。
</a>

