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
	<form:form role="form" action='create' method='post'>
		<div class="box-body">
			<div class="form-group">
				<label for="account">帳號</label>
				<input id=id type="text" class="form-control" name="id">
				<label for="name">姓名</label>
                <input id=name type="text" class="form-control" name="name">
			</div>
		</div>
		<%-- /.box-body --%>

		<div class="box-footer">
			<button type="submit" class="btn btn-success">送出</button>
		</div>
	</form:form>
</div>
<%-- /.box --%>