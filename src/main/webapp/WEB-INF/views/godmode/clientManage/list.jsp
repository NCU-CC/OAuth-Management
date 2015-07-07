<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
	<div class="col-xs-12">
		<div class="box box-solid box-info">
			<div class="box-header">
				<h3 class="box-title ">搜尋</h3>		
			</div>
			<%-- /.box-header --%>
			<div class="box-body table-responsive no-padding">
				<form class="form-horizontal" method="GET" action="">
					<div class="box-body">
						<div class="form-group">
							<label for="name" class="col-sm-2 control-label">名稱</label>
							<div class="col-sm-10">
								<input class="form-control" id="name" placeholder="應用服務名稱" name="name">
							</div>
						</div>
						<div class="form-group">
							<label for="id" class="col-sm-2 control-label">client id</label>
							<div class="col-sm-10">
								<input class="form-control" id="id" placeholder="應用服務的client id" name="id">
							</div>
						</div>
						<div class="form-group">
							<label for="owner" class="col-sm-2 control-label">開發者</label>
							<div class="col-sm-10">
								<input class="form-control" id="owner" placeholder="開發者姓名" name="owner">
							</div>
						</div>
						<div class="form-group">
							<label for="deleted" class="col-sm-2 control-label">是否刪除</label>
							<div class="col-sm-10">
								<select class="form-control" id="deleted" name="deleted">
									<option selected value="false">未刪除</option>
									<option value="true">已刪除</option>
								</select>
							</div>
						</div>
					</div>
					<!-- /.box-body -->
					<div class="box-footer">
						<button type="submit" class="btn btn-primary">搜尋</button>
					</div>
					<!-- /.box-footer -->
				</form>
			</div>
			<%-- /.box-body --%>
		</div>
		<%-- /.box --%>
		
		<div class="box box-info">
			<div class="box-header">
				<h3 class="box-title">搜尋結果</h3>
			</div>
			<%-- /.box-header --%>
			<div class="box-body table-responsive no-padding">
				<c:if test="${empty clientList}">
					<table class="table table-hover">
						<tr>
							<th>無結果</th>
						</tr>
					</table>
				</c:if>
				<c:if test="${not empty clientList}">
					<table class="table table-hover">
						<tr>
							<th>名稱</th>
						</tr>
						<c:forEach var="client" items="${clientList}">
							<tr>
								<td>
									<a href="<c:url value="/developer/client/detail?g=${client.id}"/>">
										${client.name}
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