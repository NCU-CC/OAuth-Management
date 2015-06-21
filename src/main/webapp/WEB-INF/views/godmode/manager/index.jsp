<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
	<div class="col-xs-12">
		<div class="box">
			<div class="box-header">
				<h3>系統管理者管理</h3>
				<div class="box-tools">
                    <div class="input-group">
                        <div class="input-group-btn">
                            <a href="<c:url value='/godmode/manager/create'/>">
                                <button class="btn btn-sm btn-default pull-right">
                                    <i class="fa fa-plus">新增系統管理員</i>
                                </button></a>
                        </div>
                    </div>
                </div>
			</div>
			<%-- /.box-header --%>
			<div class="box-body table-responsive no-padding">
				<table class="table table-hover">
				    <tr>
                        <th>編號</th>
                        <th>帳號</th>
                        <th>功能</th>
                    </tr>
				    <c:forEach items="${managerList}" var="manager" varStatus="status">
				        <tr>
				            <td>${status.index + 1}</td>
				            <td>${manager.id}</td>
				            <td>${manager.name}</td>
				            <td><a href="<c:url value='/godmode/manager/delete/${manager.id}'/>"><span class="label label-primary">刪除</span></a></td>
				        </tr>
				    </c:forEach>
				</table>
			</div>
			<%-- /.box-body --%>
		</div>
		<%-- /.box --%>
	</div>
</div>
<script src="<c:url value='/resources/js/rails.js'/>" type="text/javascript"></script>
<script src="<c:url value='/resources/js/data-confirm-modal.js'/>" type="text/javascript"></script>
