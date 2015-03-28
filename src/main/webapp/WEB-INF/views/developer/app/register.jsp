<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:if test="${not empty errorTitle}">
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
	<form:form role="form" action='tonew' method='post'>
		<div class="box-body">
			<div class="form-group">
				<label for="exampleInputEmail1">App名稱</label> <input type="text"
					class="form-control" name="appInfo.name"
					placeholder="Enter APP's name" value="${appInfo.name }">
				<p class="help-block">Something users will recognize and trust</p>
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">App網站URL</label> <input type="text"
					class="form-control" name="appInfo.url" placeholder="Website url"
					value="${appInfo.url }">
				<p class="help-block">The full URL to your application homepage</p>
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">App簡述</label> <input type="text"
					class="form-control" name="appInfo.description"
					placeholder="Description" value="${appInfo.description }">
				<p class="help-block">This is displayed to all potential users
					of your application</p>
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">授權 callback URL</label> <input
					type="text" class="form-control" name="appInfo.callback"
					placeholder="Callback url" value="${appInfo.callback }">
				<p class="help-block">Your application's callback URL. Read our
					OAuth documentation for more information</p>
			</div>
		</div>
		<%-- /.box-body --%>

		<div class="box-footer">
			<button type="submit" class="btn btn-success">送出申請</button>
		</div>
	</form:form>
</div>
<%-- /.box --%>