<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/login.css'/>"/>
<meta charset="UTF-8">
<title>Banking | 회원가입 완료</title>
</head>
<body>
	<div id="wrap">
	<div class="borderBox">
        <h1 class="westagram">회원가입이 완료되었습니다.</h1>
        <div class="login">
            <input id="id" value="${customer.userId }" readonly>
            <input id="id" value="${customer.passwd }" readonly>
            <input id="id" value="${customer.name }" readonly>
            <input id="id" value="${customer.ssn }" readonly>
            <input id="id" value="${customer.phone }" readonly>            
            <a href="/banking/controller/login" class="btn">로그인 페이지로</a>
        </div>
    </div>
	</div>
</body>
</html>