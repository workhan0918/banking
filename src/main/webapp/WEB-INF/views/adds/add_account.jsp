<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/main.css'/>"/>
<meta charset="UTF-8">
<title>Banking | 계좌생성</title>
</head>
<body>
		<%@ include file="/WEB-INF/views/include/header.jsp" %>
	<div id="add_account_wrap">
		<form action="add_account" method="post" id="add_form" >
			<h1>사용하실 계좌 타입을 선택해주세요.</h1>
				<select name="accountType">
					<option value='S' selected="selected">Saving Account</option>
					<option value='C'>Checked Account</option>
				</select><br>
			<input type="submit" value="계좌생성" id="submit_btn">
		</form>
	</div>
</body>
</html>