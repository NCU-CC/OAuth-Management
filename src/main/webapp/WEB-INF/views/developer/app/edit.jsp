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
	<form:form role="form" action='/dev/edited' method='post'>
		<div class="box-body">
			<div class="form-group">
				<label for="exampleInputEmail1">App名稱</label> <input type="text"
					class="form-control" name="AppInfo.name"
					placeholder="Enter App's name" value="${AppInfo.name }">
				<p class="help-block">Something users will recognize and trust</p>
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">App網站URL</label> <input type="text"
					class="form-control" name="AppInfo.url" placeholder="Website url"
					value="${AppInfo.url }">
				<p class="help-block">The full URL to your Application homepage</p>
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">App簡述</label> <input type="text"
					class="form-control" name="AppInfo.description"
					placeholder="Description" value="${AppInfo.description }">
				<p class="help-block">This is displayed to all potential users
					of your Application</p>
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">授權 callback URL</label> <input
					type="text" class="form-control" name="AppInfo.callback"
					placeholder="Callback url" value="${AppInfo.callback }">
				<p class="help-block">Your Application's callback URL. Read our
					OAuth documentation for more information</p>
			</div>

		</div>
		<%-- /.box-body --%>

		<div class="box-footer">
			<input type="hidden" name="id" value="${id}" />
			<button type="submit" class="btn btn-success">更新App</button>
			<a
				href="<c:url action='/developer/app/secret?id=${id}&token=${token}&struts.token.name=token' />"
				data-confirm="是否要獲取新的secret？ 舊的secret將無法使用" data-method="post"
				class="btn btn-warning">新的secret</a> <a
				href="<c:url action='/developer/app/delete?id=${id}&token=${token}&struts.token.name=token' />"
				data-confirm="是否要刪除？" data-method="post" class="btn btn-danger">刪除App</a>
		</div>
	</form:form>
	<%--</form>--%>
</div>
<%-- /.box --%>

<script src="<c:url value='/resources/js/rails.js'/>" type="text/javascript"></script>
7<script src="<c:url value='/resources/js/data-confirm-modal.js'/>" type="text/javascript"></script>