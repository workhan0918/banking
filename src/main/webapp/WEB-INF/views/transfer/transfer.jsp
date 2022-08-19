<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/main.css'/>"/>
<meta charset="UTF-8">
<title>Banking | 계좌 이체</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp" %>
  	<div id="wrap">
  		<form action="transfer_account" method="post" id="add_form" style="margin-top: 200px;" >
        <h1 class="transferTitle">이체할 계좌번호를 선택해주세요</h1>
  		<ul class="transferUl">
  			<li>
        <select name="myAccount">
  			<c:forEach var="item" items="${accList }">
  				<option value="${item.accountNum }">${item.accountNum }
  			</c:forEach>
  			</select>
  			</li>
  			<li><span class="text">비밀번호 : </span><input type="password" name="passwd"></li>
  			<li><span class="text">상대방 계좌번호 : </span><input type="text" name="transferAccount"></li>
  			<li><span class="text">이체할 금액 : </span><input type="text" name="amount"  oninput="onlyNumber(this)" maxlength="8"></li>
  		</ul>
  			<input style="margin-left: 40px; margin-top: 30px;" type="submit" value="송금" id="submit_btn">
  		</form>
  	</div>


<script type="text/javascript">
const onlyNumber = (target) => {
    target.value = target.value
    .replace(/[^0-9]/g, '');
  }
</script>
  </body>
</html>