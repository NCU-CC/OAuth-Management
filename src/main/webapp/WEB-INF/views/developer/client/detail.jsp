<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<c:if test="${isInBlacklist}">
	<div class="callout callout-danger">
		<h4>已被加入黑名單！</h4>
		<p>這個應用服務已被加入黑名單，將不被允許進行任何修改。</p>
	</div>
</c:if>
<h2 class="page-header">一般</h2>
<div class="box box-primary invoice">
	<div class="box-header with-border">
		<h3 class="box-title">基本資料</h3>
	</div>
	<%-- /.box-header --%>
	<%-- form start --%>
    <form:form role="form" action='../../edit' method='post' commandName="client">
       <security:csrfInput/>
		<div class="box-body">
			<div class="form-group">
			    <form:label path="name">應用服務名稱</form:label>
			    <form:input path="name" cssClass="form-control" placeholder="輸入應用服務的名稱"/>
			    <form:errors path="name"/>
			</div>
			<div class="form-group">
			    <form:label path="url">網站</form:label>
			    <form:input path="url" cssClass="form-control" placeholder="網站完整的網址(http, https)"/>
                <form:errors path="url"/>
			</div>
			<div class="form-group">
                <form:label path="description">應用服務簡述</form:label> 
                <form:input path="description" cssClass="form-control" placeholder="簡單地描述你的應用服務"/>
                <form:errors path="description"/>
			</div>
			<div class="form-group">
                <form:label path="callback">授權 callback URL</form:label> 
                <form:input path="callback" cssClass="form-control" placeholder="OAuth callback url"/>
                <form:errors path="callback"/>
				<p class="help-block">應用服務的callback URL，用以在認證成功後要導向的位址。<a href="https://github.com/NCU-CC/API-Documentation">瞭解更多</a></p>
			</div>

		</div>
		<%-- /.box-body --%>
		<c:if test="${not isInBlacklist}">
			<div class="box-footer">
				<form:hidden path="id" />
				<button type="submit" class="btn btn-success">更新資訊</button>
			</div>
		</c:if>

	</form:form>
	<%--</form>--%>
</div>
<%-- /.box --%>
<h2 class="page-header">Token</h2>
<div class="box box-info invoice">
	<div class="box-header with-border">
		<h3 class="box-title">Secret</h3>
	</div>
	<div class="box-body">
		<dl class="dl-horizontal">
			<dt>Client Id</dt>
			<dd>${client.id}</dd>
			<dt>Client Secret</dt>
			<dd>${client.secret}</dd>
			
		</dl>
	</div>
	<div class="box-footer">
		<c:if test="${not isInBlacklist}">
			<button class="btn btn-info" onClick="location.href='secret?id=${client.id}'">更新secret</button>
		</c:if>
	</div>
</div>
<div class="box box-info invoice">
	<div class="box-header with-border">
		<h3 class="box-title">API Token</h3>
	</div>
	<div class="box-body">
		<dl class="dl-horizontal">
			<dt>API Token</dt>
			<dd>
				${apiToken.token}
			</dd>
		</dl>
	</div>
	
	<c:if test="${not isInBlacklist}">
		<div class="box-footer">
			<button class="btn btn-info" onClick="location.href='apiToken?d=${apiToken.token}'">更新API Token</button>
		</div>
	</c:if>
</div>


<h2 class="page-header">無法回復的操作</h2>
<div class="box box-danger invoice">
	<div class="box-footer">
		<button class="btn btn-danger" onClick="location.href='delete?id=${client.id}'">刪除本應用服務</button>
	</div>
</div>

<script src="<c:url value='/resources/js/rails.js'/>" type="text/javascript"></script>
<script src="<c:url value='/resources/js/data-confirm-modal.js'/>" type="text/javascript"></script>