<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
	<div class="box-header">
		<h3 class="box-title">黑名單管理</h3>
	</div>
	<%-- /.box-header --%>
	<%-- form start --%>
	<form:form role="form" action='#' method='post'>
		<div class="box-body">
			<div class="form-group">
				<label for="account">開發者帳號</label>
				<input id=account type="text" class="form-control" name="account" value="${account}">
			</div>
			<div class="form-group">
				<label for="reason">停權原因</label>
				<input id=reason type="text" class="form-control" name="reason" value="${reason}">
			</div>
		</div>
		<%-- /.box-body --%>

		<div class="box-footer">
			<button type="submit" class="btn btn-success">送出</button>
		</div>
	</form:form>
</div>
<%-- /.box --%>