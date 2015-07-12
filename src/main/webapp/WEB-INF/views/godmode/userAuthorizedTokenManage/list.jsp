<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
	<div class="col-md-6">
		<div class="box box-solid box-info">
			<div class="box-header">
				<h3 class="box-title">搜尋</h3>
			</div>
			<%-- /.box-header --%>
			<form class="form-horizontal" role="form" method="GET" action="">
				<div class="box-body">
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">帳號</label>
						<div class="col-sm-10">
							<input class="form-control" id="name" placeholder="使用者帳號" name="name" value="${param.name}">
						</div>
					</div>
				</div>
				<!-- /.box-body -->
				<div class="box-footer">
                    <input type=hidden name="action" value="search"/>
					<button type="submit" class="btn btn-primary">搜尋</button>
				</div>
				<!-- /.box-footer -->
			</form>
			<%-- /.box-body --%>
		</div>
		<%-- /.box --%>
	</div>
	<div class="col-xs-12 col-md-12">
		<div class="box box-info">
			<div class="box-header">
				<h3 class="box-title">搜尋結果</h3>
			</div>
			<%-- /.box-header --%>
			<div class="box-body table-responsive no-padding">
				<c:if test="${empty userList}">
					<table class="table table-hover">
						<tr>
							<th>無結果</th>
						</tr>
					</table>
				</c:if>
				<c:if test="${not empty userList}">
					<table class="table table-hover">
						<tr>
							<th>id</th>
							<th>帳號</th>
						</tr>
						<c:forEach var="user" items="${userList}">
							<tr>
								<td>${user.id}</td>
								<td>${user.name}</td>
							</tr>
						</c:forEach>
					</table>
				</c:if>
			</div>
			<%-- /.box-body --%>
		</div>
	</div>
</div>