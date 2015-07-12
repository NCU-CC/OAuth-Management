<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

	<!DOCTYPE html>
	<%--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]--%>
	<%--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]--%>
	<%--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]--%>
	<%--[if gt IE 8]><%--%>
	<html class="no-js">
<%--<![endif]--%>
<head>

<title>Login - OAuth Management</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="description" content="">
<meta name="author" content="NCUCC" />

<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,800italic,400,600,800"
	type="text/css">
<link rel="stylesheet" href="<c:url value='/resources/css/font-awesome.min.css' />" type="text/css" />
<link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.min.css' />" type="text/css" />
<link rel="stylesheet" href="<c:url value='/resources/css/jquery-ui-1.9.2.custom.css' />" type="text/css" />

<link rel="stylesheet" href="<c:url value='/resources/css/App.css' />" type="text/css" />
<link rel="stylesheet" href="<c:url value='/resources/css/Login.css' />" type="text/css" />

<link rel="stylesheet" href="./css/custom.css" type="text/css" />
</head>

<body>

	<div id="login-container">

		<div id="logo">
			<img src="<c:url value='/resources/img/logos/logo-login.png' />" alt="Logo" />
		</div>
		<div id="login">
			<h3>歡迎使用NCU OAuth</h3>
			<div class="form-group">
				<c:if test="${not empty param.login_error}">
					<div class="errors">
						<p>無法登入</p>
					</div>
				</c:if>

                <c:if test="${not empty errorMsg}">
                    <p align="center">
                        <span style="font-size: 20px; background-color: black; color: white; padding: 5px;">
                            <spring:message code="${errorMsg}" />
                        </span>
                    </p>
                </c:if>
                <form action="login/openid" method="post">
                    <input id="openid_identifier" name="openid_identifier" size="70" maxlength="100" type="hidden"
                        value="https://portal.ncu.edu.tw/user" />
                        <security:csrfInput/>
                    <input id="login-btn" class="btn btn-primary btn-block"type="submit" value="NCU Portal 登入" />
                </form>
            </div>
			<p class="text-red">目前僅限教職員工、在校生及校友使用。</p>
			<a href="http://www.cc.ncu.edu.tw/net/password.php" class="btn btn-default">忘記密碼？</a>

		</div>
		<%-- /#login --%>
	</div>
	<%-- /#login-container --%>
</body>
</html>