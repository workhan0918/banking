<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/login.css'/>"/>
<meta charset="UTF-8">
<title>Banking | 로그인</title>
</head>
<body>
    <form method="post" class="borderBox">
        <h1 class="westagram">DOTORI BANK</h1>
        <div class="login">
            <input id="id" type="text" placeholder="사용자 아이디" name="userId">
            <input id="password" type="password" placeholder="비밀번호" name="passwd">
            <input type="submit" value="로그인" class="btn">
        </div>
        <a class="text" href="/banking/controller/add_customer">아직 계정이 없으신가요?</a>
    </form>
</body>
</html>