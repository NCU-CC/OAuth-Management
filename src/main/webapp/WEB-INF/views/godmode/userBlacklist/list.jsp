<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
	<div class="col-xs-12">
		<div class="box">
			<div class="box-header">
				<h3 class="box-title">搜尋</h3>
				<div class="box-tools">
					<div class="input-group">
						<div class="input-group-btn">
							<a href="<c:url value="user/create"/>"><button
									class="btn btn-sm btn-warning pull-right">
									<i class="fa fa-plus">新增使用者黑名單</i>
								</button></a>
						</div>
					</div>
				</div>
			</div>
			<%-- /.box-header --%>
			<form class="form-horizontal" method="GET" action="">
				<div class="box-body">
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">帳號</label>
						<div class="col-sm-10">
							<input class="form-control" id="username" placeholder="使用者帳號" name="username" value="${param.username}">
						</div>
					</div>
				</div>
				<!-- /.box-body -->
				<div class="box-footer">
					<input type=hidden name=action value=search />
					<button type="submit" class="btn btn-primary">搜尋</button>
				</div>
				<!-- /.box-footer -->
			</form>
			<%-- /.box-body --%>
		</div>
		<%-- /.box --%>
	</div>
	<div class="col-md-12">
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
							<th>帳號</th>
							<th>原因</th>
							<th>功能</th>
						</tr>
						<c:forEach var="blacklistUser" items="${userList}">
							<tr>
								<td>${blacklistUser.username}</td>
								<td>${blacklistUser.reason}</td>
								<td>
									<a href="<c:url value='/godmode/blacklist/user/delete/${blacklistUser.username}'/>"><span class="label label-danger">取消</span></a>
								</td>
							</tr>
						</c:forEach>
					</table>
				</c:if>
			</div>
			<%-- /.box-body --%>
		</div>
		<%-- /.box --%>
	</div>
</div>