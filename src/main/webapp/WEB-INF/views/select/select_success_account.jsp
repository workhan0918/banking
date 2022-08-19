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
			<h1>계좌 ID로 조회 성공!</h1>
		</header>
		<ul>
		<p>${account.customer.userId }님의 보유 계좌 정보</p>
		<c:forEach var="item" items="${accountArr }">
			<li>계좌 번호 : ${item.accountNum }</li>
			<li>계좌 타입 : ${item.accountType }</li>
			<li>계좌 잔고 : ${item.balance }원</li>
			<li>이자율 : ${item.interestRate }%</li>
			<li>한도 : ${item.overAmount }원</li>
			<br>
		</c:forEach>
		</ul>
	</div>
</body>
</html>