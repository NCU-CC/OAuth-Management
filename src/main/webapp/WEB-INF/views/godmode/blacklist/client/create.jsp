<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
	<div class="col-xs-4 col-md-4">
		<div class="box box-solid box-info">
			<div class="box-header">
				<h3 class="box-title">新增應用服務黑名單</h3>
			</div>
			<%-- /.box-header --%>
			<div class="box-body table-responsive no-padding">
				<form class="form-horizontal" method="POST" action="">
					<div class="box-body">
						<div class="form-group">
							<label for="id" class="col-sm-2 control-label">client id</label>
							<div class="col-sm-10">
								<input class="form-control" id="id" placeholder="應用服務的client id" name="client.id" value="${param.id}">
							</div>
						</div>
						<div class="form-group">
							<label for="reason" class="col-sm-2 control-label">開發者</label>
							<div class="col-sm-10">
								<input class="form-control" id="reason" placeholder="黑名單的理由" name="reason" value="${param.reason}">
							</div>
						</div>
					</div>
					<!-- /.box-body -->
					<div class="box-footer">
						<button type="submit" class="btn btn-primary">新增</button>
					</div>
					<!-- /.box-footer -->
				</form>
			</div>
			<%-- /.box-body --%>
		</div>
		<%-- /.box --%>
	</div>
</div>