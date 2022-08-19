<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/login.css'/>"/>
<meta charset="UTF-8">
<title>Banking | 회원가입</title>
</head>
<body>
    <form method="post" class="borderBox">
        <h1 class="westagram">회원가입</h1>
        <div class="login">
            <input id="id" type="text" placeholder="사용할 아이디" name="userId" maxlength="13" >
            <input id="password" type="password" placeholder="비밀번호" name="passwd" maxlength="20">
            <input id="name" type="text" placeholder="이름" name="name" maxlength="3">
            <input id="ssn" type="text" placeholder="주민번호" oninput="autoHyphenForSsn(this)" name="ssn" maxlength="14">
            <input id="phone" type="text" placeholder="휴대전화" oninput="autoHyphenForPhone(this)" name="phone" maxlength="13">
            <input type="submit" value="가입하기" class="btn">
        </div>
    </form>
    <script type="text/javascript">

    // 전화번호 입력시 자동 하이픈 생성 (정규식 사용)
    const autoHyphenForPhone = (target) => {
      target.value = target.value
      .replace(/[^0-9]/g, '')
      .replace(/^(\d{2,3})(\d{3,4})(\d{4})$/, `$1-$2-$3`);
    }

    // 주민번호 입력시 자동 하이픈 생성 (정규식 사용)
    const autoHyphenForSsn = (target) => {
      target.value = target.value
      .replace(/[^0-9]/g, '')
      .replace(/^(\d{6})(\d{7})$/, `$1-$2`);
    }
  </script>
</body>
</html>