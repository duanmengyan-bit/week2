<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
	<td>编号</td>
	<td>姓名</td>
	<td>价钱</td>
	<td>百分比</td>
</tr>
<c:forEach items="${list }" var="li">
	<tr>
		<td>${li.id }</td>
		<td>${li.name }</td>
		<td>${li.price }</td>
		<td>${li.baifen }</td>
	</tr>
</c:forEach>

</table>
<a href="getList?page="+${prepage }>上一页</a>
<a href="getList?page="+${nextpage }>下一页</a>
</body>
</html>