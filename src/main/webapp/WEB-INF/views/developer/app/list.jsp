<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
	<div class="col-xs-12">
		<div class="box">
			<div class="box-header">
				<h3 class="box-title">
					<c:choose>
						<c:when test="${not empty appList}">App列表</c:when>
						<c:otherwise>您尚未註冊任何App</c:otherwise>
					</c:choose>
				</h3>
				<div class="box-tools">
					<div class="input-group">
						<div class="input-group-btn">
							<a href="<c:url value="/developer/app/new"/>"><button
									class="btn btn-sm btn-default pull-right">
									<i class="fa fa-plus">註冊新APP</i>
								</button></a>
						</div>
					</div>
				</div>
			</div>
			<%-- /.box-header --%>
			<div class="box-body table-responsive no-padding">
				<c:choose>
					<c:when test="${not empty appList}">
						<table class="table table-hover">
							<tr>
								<th>ID</th>
								<th>名稱</th>
								<th>網站URL</th>
								<th>簡介</th>
								<th>功能</th>
							</tr>
							<c:forEach var="app" items="${appList}">
								<tr>
									<td>${app.id}</td>
									<td>${app.name}</td>
									<td><a href="${app.url}" target="_blank">${app.url}</a></td>
									<td>${description}</td>
									<td><a href="<c:url value="/developer/app/edit?id=${id}"/>"><span
											class="label label-primary">修改</span></a></td>
								</tr>
							</c:forEach>
						</table>
					</c:when>
					<c:otherwise>
						<div class="col-xs-2"></div>
						<div class="col-xs-8">
							<a class="btn btn-block btn-social btn-foursquare"
								href="<c:url value="/developer/app/create"/>"> <i class="fa fa-plus"></i>註冊新App
							</a>
						</div>
					</c:otherwise>
				</c:choose>
			</div>
			<%-- /.box-body --%>
		</div>
		<%-- /.box --%>
	</div>
</div>
<script src="<c:url value='/resources/js/rails.js'/>" type="text/javascript"></script>
<script src="<c:url value='/resources/js/data-confirm-modal.js'/>" type="text/javascript"></script>
