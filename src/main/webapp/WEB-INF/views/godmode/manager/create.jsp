<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%-- left column --%>
<div class="box box-primary invoice">
	<div class="box-header">
		<h3 class="box-title">新增系統管理員</h3>
	</div>
	<%-- /.box-header --%>
	<%-- form start --%>
	<form:form role="form" action='create' commandName="manager">
		<div class="box-body">
			<div class="form-group">
				<form:label path="id">帳號</form:label>
				<form:input path="id" cssClass="form-control"/>
				<form:errors path="id"/>
				
				<form:label path="name">姓名</form:label>
				<form:input path="name" cssClass="form-control"/>
				<form:errors path="name"/>
			</div>
		</div>
		<%-- /.box-body --%>

		<div class="box-footer">
			<button type="submit" class="btn btn-success">送出</button>
		</div>
	</form:form>
</div>
<%-- /.box --%>