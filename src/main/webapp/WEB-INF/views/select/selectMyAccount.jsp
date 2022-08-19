<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/style.css'/>"/>
<meta charset="UTF-8">
<title>Banking | 계좌조회</title>
</head>
<body>
	<div id="wrap">
		<header id="header">
			<h1>계좌 ID로 조회</h1>
		</header>
		<form action="select_account" method="post" id="select_form" >
		<ul>
			<li style="margin-top: 15px;"><span class="userid">ID : </span><input type="text" name="userId"></li>
		</ul>
			<input type="submit" value="조회" id="submit" style="top: 180px;">
		</form>
		${msg }
	</div>
</body>
</html>