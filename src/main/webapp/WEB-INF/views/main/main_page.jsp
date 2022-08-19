<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/main.css'/>"/>
<meta charset="UTF-8">
<title>Banking | MAIN</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp" %>
	  <div id="wrap">
     <c:forEach var="item" items="${accList }" varStatus="status">
      <div class="content">
        <div class="text">
          	<h1>${item.accountNum }</h1><input value="${item.accountNum }" name="accountNum" style="display:none">
          	<h3>계좌 타입 : ${item.accountType }</h3>
          	<h4 style="text-align: center">계좌 생성 날짜<br>${item.regDate }</h4>
          	<button type="button" id="btn${status.index}" class="money_check">${item.balance }원</button>
        </div>
      </div>
     </c:forEach>
    </div>
</body>
</html>