<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div xmlns:jsp="http://java.sun.com/JSP/Page"
    xmlns:c="http://java.sun.com/jsp/jstl/core"
    xmlns:spring="http://www.springframework.org/tags"
    version="2.0">
    
    <c:if test="${not empty param.login_error}">
      <div class="errors">
        <p>無法登入</p>
      </div>
    </c:if>
    
<c:if test="${not empty errorMsg}">
<p align="center">
    <span style="font-size:20px; background-color:black; color:white; padding:5px;">
    <spring:message code="${errorMsg}" />
    </span>
</p>
</c:if>
<form action="login/openid" method="post">
  <input id="openid_identifier" name="openid_identifier" size="70"
maxlength="100" type="hidden" value="https://portal.ncu.edu.tw/user" />
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
  <input type="submit" value="Portal Login"/>
</form>
</div>