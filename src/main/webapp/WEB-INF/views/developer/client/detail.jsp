<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<c:if test="${not empty errorTitle}">
	<div class="pad margin no-print">
		<div class="alert alert-danger alert-dismissable"
			style="margin-bottom: 0 !important;">
			<i class="fa fa-ban"></i> <b>${errorTitle}:</b> ${errorContent}
		</div>
	</div>
</c:if>
<%-- left column --%>
<div class="box box-primary invoice">
	<div class="box-header with-border">
		<h3 class="box-title">一般操作</h3>
	</div>
	<%-- /.box-header --%>
	<%-- form start --%>
	<form:form role="form" action='edit' method='post'>
	   <security:csrfInput/>
		<div class="box-body">
			<div class="form-group">
				<label for="name">應用服務名稱</label>
				<input id=name type="text" class="form-control" name="name"	placeholder="輸入應用服務的名稱" value="${client.name}">
			</div>
			<div class="form-group">
				<label for="url">網站URL</label>
				<input id=url type="text" class="form-control" name="url" placeholder="網站完整的網址(http, https)" value="${client.url}">
			</div>
			<div class="form-group">
				<label for="description">應用服務簡述</label> 
				<input id=description type="text" class="form-control" name="description" placeholder="簡單地描述你的應用服務" value="${client.description}">
			</div>
			<div class="form-group">
				<label for="callback">授權 callback URL</label>
				<input id=callback type="text" class="form-control" name="callback"	placeholder="OAuth callback url" value="${client.callback}">
				<p class="help-block">應用服務的callback URL，用以在認證成功後要導向的位址。<a href="https://github.com/NCU-CC/API-Documentation">瞭解更多</a></p>
			</div>

		</div>
		<%-- /.box-body --%>

		<div class="box-footer">
			<input type=hidden name=id value="${client.id}"/>
			<button type="submit" class="btn btn-success">更新</button>
		</div>

	</form:form>
	<%--</form>--%>
</div>
<%-- /.box --%>

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
		<button class="btn btn-info" onClick="location.href='secret?id=${client.id}'">更新secret</button>
	</div>
</div>

<div class="box box-danger invoice">
	<div class="box-header with-border">
		<h3 class="box-title">危險操作</h3>
	</div>
	<div class="box-footer">
		<button class="btn btn-danger" onClick="location.href='delete?id=${client.id}'">刪除本應用服務</button>
	</div>
</div>

<script src="<c:url value='/resources/js/rails.js'/>" type="text/javascript"></script>
<script src="<c:url value='/resources/js/data-confirm-modal.js'/>" type="text/javascript"></script>