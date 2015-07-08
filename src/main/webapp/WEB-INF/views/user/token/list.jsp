<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<div class="row">
	<div class="col-xs-12">
		<div class="box">
			<div class="box-header">
				<h3 class="box-title">
                    <c:choose>
                        <c:when test="${not empty tokenList}">授權列表</c:when>
                        <c:otherwise>您無任何授權</c:otherwise>
					</c:choose>
				</h3>

			</div>
			<%-- /.box-header --%>
			<div class="box-body table-responsive no-padding">
				<c:if test="${not empty tokenList}">
					<table class="table table-hover">
						<tr>
							<th>應用服務名稱</th>
							<th>權限</th>
							<th>功能</th>
						</tr>
						<c:forEach var="token" items="${tokenList}">
							<tr>
								<td>${token.client.name}</td>
								<td>
									<c:forEach items="${token.scope}" var="scope">
										${scope}<br/>
									</c:forEach></td>
								<td><a href="<c:url value="/user/token/revoke?id=${token.id}&=${_csrf.parameterName}=${_csrf.token}" />"
									data-confirm="確定要撤銷此應用服務的授權？ " data-method="post">
									   <span class="label label-danger">撤銷</span>
									   </a>
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
