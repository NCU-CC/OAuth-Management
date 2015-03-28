<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%-- left column --%>
<div class="box box-primary invoice">
	<div class="col-md-2"></div>
	<div class="col-md-8">
		<div class="box box-info">
			<div class="box-header">
				<i class="fa fa-bullhorn"></i>
				<h3 class="box-title">通知</h3>
			</div>
			<%-- /.box-header --%>
			<div class="box-body">
				<div class="callout callout-info">
					<h4><!-- messageTitlle 修改/刪除 成功--></h4>
					<p><!-- messageContent 您已成功修改/刪除 APP--></p>
				</div>
				<a href="<c:url value="/dev/list"/>">
				    <button	class="btn btn-success"><i class="fa fa-reply"></i>返回</button>
				</a>
			</div>
			<%-- /.box-body --%>

		</div>
		<%-- /.box --%>
	</div>
	<%-- /.col --%>
</div>
<%-- /.row --%>