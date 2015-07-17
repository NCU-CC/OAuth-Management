<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
				<label for="account">使用者帳號</label>
				<input id=account type="text" class="form-control" name="account">
			</div>
			<div class="form-group">
				<label for="reason">停權原因</label>
				<input id=reason type="text" class="form-control" name="reason">
			</div>
		</div>
		<%-- /.box-body --%>

		<div class="box-footer">
			<button type="submit" class="btn btn-success">送出</button>
		</div>
	</form:form>
</div>
<%-- /.box --%>