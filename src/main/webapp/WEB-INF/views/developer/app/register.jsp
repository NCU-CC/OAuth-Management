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
		<h3 class="box-title">申請表單</h3>
	</div>
	<%-- /.box-header --%>
	<%-- form start --%>
	<form:form role="form" action='create' method='post'>
		<div class="box-body">
			<div class="form-group">
				<label for="name">App名稱</label>
				<input id=name type="text" class="form-control" name="name"	placeholder="輸入app的名稱">
			</div>
			<div class="form-group">
				<label for="url">App網站URL</label>
				<input id=url type="text" class="form-control" name="url" placeholder="網站完整的網址(http, https)">
			</div>
			<div class="form-group">
				<label for="description">App簡述</label> 
				<input id=description type="text" class="form-control" name="description" placeholder="簡單的描述你的app">
			</div>
			<div class="form-group">
				<label for="callback">授權 callback URL</label>
				<input id=callback type="text" class="form-control" name="callback"	placeholder="OAuth callback url">
				<p class="help-block">Your application's callback URL. Read our	OAuth documentation for more information</p>
			</div>
		</div>
		<%-- /.box-body --%>

		<div class="box-footer">
			<button type="submit" class="btn btn-success">送出申請</button>
		</div>
	</form:form>
</div>
<%-- /.box --%>