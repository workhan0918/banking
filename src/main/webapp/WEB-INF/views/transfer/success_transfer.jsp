<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/style.css'/>"/>
<meta charset="UTF-8">
<title>BANKING | 이체 완료</title>
</head>
<body>
	<div id="wrap">
	<ul style="position: relative; top: 400px;">
		<li>${transferAccNum }계좌로</li>
		<li>${amount }원 이체가 완료 되었습니다.</li>
		<br>
		<li>남은 잔액</li>
		<li>${accNum }원</li>
	</ul>	
	</div>
	
</body>
</html>