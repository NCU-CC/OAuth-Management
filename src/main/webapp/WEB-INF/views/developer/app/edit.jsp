<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:if test="${errorTitle not empty}">
	<div class="pad margin no-print">
		<div class="alert alert-danger alert-dismissable"
			style="margin-bottom: 0 !important;">
			<i class="fa fa-ban"></i> <b>${errorTitle }:</b> ${errorContent }
		</div>
	</div>
</c:if>
<%-- left column --%>
<div class="box box-primary invoice">
	<div class="box-header">
		<h3 class="box-title">申請表單</h3>
	</div>
	<%-- /.box-header --%>
	<%-- form start --%>
	<form:form role="form" action='edit' method='post'>
		<div class="box-body">
			<div class="form-group">
				<label for="name">App名稱</label>
				<input id=name type="text" class="form-control" name="name"	placeholder="輸入app的名稱" value="${application.name }">
			</div>
			<div class="form-group">
				<label for="url">App網站URL</label>
				<input id=url type="text" class="form-control" name="url" placeholder="網站完整的網址(http, https)" value="${application.url}">
			</div>
			<div class="form-group">
				<label for="description">App簡述</label> 
				<input id=description type="text" class="form-control" name="description" placeholder="簡單的描述你的app" value="${application.description}">
			</div>
			<div class="form-group">
				<label for="callback">授權 callback URL</label>
				<input id=callback type="text" class="form-control" name="callback"	placeholder="OAuth callback url" value="${application.callback}">
				<p class="help-block">Your application's callback URL. Read our	OAuth documentation for more information</p>
			</div>

		</div>
		<%-- /.box-body --%>

		<div class="box-footer">
			<input type="hidden" name="id" value="${id}" />
			<button type="submit" class="btn btn-success">更新App</button>
			<a
				href="<c:url action='/developer/app/secret?id=${id}' />"
				data-confirm="是否要更新secret？ 舊的secret將無法使用" data-method="post"
				class="btn btn-warning">更新secret</a> <a
				href="<c:url action='/developer/app/delete?id=${id}' />"
				data-confirm="是否要刪除？" data-method="post" class="btn btn-danger">刪除App</a>
		</div>
	</form:form>
	<%--</form>--%>
</div>
<%-- /.box --%>

<script src="<c:url value='/resources/js/rails.js'/>" type="text/javascript"></script>
7<script src="<c:url value='/resources/js/data-confirm-modal.js'/>" type="text/javascript"></script>