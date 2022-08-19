<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/main.css'/>"/>
<meta charset="UTF-8">
<title>Banking | 계좌생성 완료</title>
</head>
  <body>
  	<%@ include file="/WEB-INF/views/include/header.jsp" %>
    <div id="add_account_wrap">
      <div id="success">
        <h1>계좌생성을 축하합니다!</h1>
          <p>생성된 계좌 타입</p>
          <p>${account.accountType }</p>
          <p>생성된 계좌 번호</p>
          <p>${account.accountNum }</p>
          <button type="button" name="button" id="submit_btn" onclick="window.location.href='../controller/main'">메인페이지로</button>
      </div>
  </div>
  </body>
</html>