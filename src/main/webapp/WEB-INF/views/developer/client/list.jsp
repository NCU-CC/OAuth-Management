<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
	<div class="col-md-8">
		<div class="box">
			<div class="box-header">
				<h3 class="box-title">
					<c:choose>
						<c:when test="${not empty clientList}">應用服務列表</c:when>
						<c:otherwise>目前因為中心人力不足，已不開放新的 Oauth 用戶註冊服務。舊申請者仍然可以透過左邊界面管理已申請的設施，但一年後將全面停止這項 Oauth  服務。</c:otherwise>
					</c:choose>
				</h3>
				<div class="box-tools">
					<div class="input-group">
						<div class="input-group-btn">
							<button disabled class="btn btn-sm btn-default pull-right">
									<i>目前不開放註冊</i>
								</button>
						</div>
					</div>
				</div>
			</div>
			<%-- /.box-header --%>
			<div class="box-body">
				<c:if test="${not empty clientList}">
					<table class="table table-hover">
						<tr>
							<th>名稱</th>
						</tr>
						<c:forEach var="client" items="${clientList}">
							<tr>
								<td>
									<a href="<c:url value="/developer/client/detail/${client.id}"/>">
										${client.name}
									</a>
									<c:if test="${isInBlacklist}">
										<span class='badge bg-red'>黑名單</span>
									</c:if>
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
