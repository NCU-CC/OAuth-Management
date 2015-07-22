<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<div class="row">
	<div class="col-md-8">
		<div class="box box-solid box-info">
			<div class="box-header">
				<h3 class="box-title">新增應用服務黑名單</h3>
			</div>
			<%-- /.box-header --%>
			<form class="form-horizontal" method="POST" action="">
				<div class="box-body">
					<div class="form-group">
						<label for="client_id" class="col-sm-2 control-label">client id</label>
						<div class="col-sm-10">
							<input class="form-control" id="client_id" placeholder="應用服務的client id" name="client_id" value="${param.client_id}">
						</div>
					</div>
					<div class="form-group">
						<label for="reason" class="col-sm-2 control-label">理由</label>
						<div class="col-sm-10">
							<input class="form-control" id="reason" placeholder="黑名單的理由" name="reason" value="${param.reason}">
						</div>
					</div>
				</div>
				<!-- /.box-body -->
				<div class="box-footer">
				    <security:csrfInput/>
					<button type="submit" class="btn btn-primary">新增</button>
				</div>
				<!-- /.box-footer -->
			</form>
			<%-- /.box-body --%>
		</div>
		<%-- /.box --%>
	</div>
</div>