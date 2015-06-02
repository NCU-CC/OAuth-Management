<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
	<div class="col-xs-12">
		<div class="box">
			<div class="box-header">
				<h3 class="box-title">
					<c:choose>
						<c:when test="${not empty clientList}">應用服務列表</c:when>
						<c:otherwise>您尚未註冊任何應用服務</c:otherwise>
					</c:choose>
				</h3>
				<div class="box-tools">
					<div class="input-group">
						<div class="input-group-btn">
							<a href="<c:url value="/developer/client/create"/>"><button
									class="btn btn-sm btn-default pull-right">
									<i class="fa fa-plus">註冊新應用服務</i>
								</button></a>
						</div>
					</div>
				</div>
			</div>
			<%-- /.box-header --%>
			<div class="box-body table-responsive no-padding">
				<c:if test="${not empty clientList}">
					<table class="table table-hover">
						<tr>
							<th>名稱</th>
						</tr>
						<c:forEach var="client" items="${clientList}">
							<tr>
								<td>
									<a href="<c:url value="/developer/client/detail?id=${client.id}"/>">
										${client.name}
									</a>
									<%--
									<a href="<c:url value="/developer/client/secret?id=${client.id}"/>">
										<span class="label label-primary">secret</span>
									</a>
									<a href="<c:url value="/developer/client/delete?id=${client.id}"/>">
										<span class="label label-danger">刪除</span>
									</a>
									 --%>
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
<script src="<c:url value='/resources/js/rails.js'/>" type="text/javascript"></script>
<script src="<c:url value='/resources/js/data-confirm-modal.js'/>" type="text/javascript"></script>
