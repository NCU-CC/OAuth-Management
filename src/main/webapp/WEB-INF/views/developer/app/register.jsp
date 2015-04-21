<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${not empty errorTitle}">
	<div class="pad margin no-print">
		<div class="alert alert-danger alert-dismissable"
			style="margin-bottom: 0 !important;">
			<i class="fa fa-ban"></i> <b>${errorTitle}:</b> ${errorContent}
		</div>
	</div>
</c:if>

<%-- left column --%>
<div class="box box-primary invoice">
	<div class="box-header">
		<h3 class="box-title">申請表單</h3>
	</div>
	<%-- /.box-header --%>
	<%-- form start --%>
	<form role="form" action='register' method='post'>
		<div class="box-body">
			<div class="form-group">
				<label for="name">App名稱</label>
                <input type="text" id="name" class="form-control" name="name" placeholder="顯示給使用者的名稱" value="${appInfo.name}">
			</div>
			<div class="form-group">
				<label for="url">App的網站位置</label>
				<input type="text" id="url" class="form-control" name="url" placeholder="完整的網站URL (http, https)" value="${appInfo.url}">
			</div>
			<div class="form-group">
				<label for="description">App簡述</label>
                    <input type="text" id="description" class="form-control" name="description" placeholder="簡單地描述你的作品" value="${appInfo.description}">			</div>
			<div class="form-group">
				<label for="callback">授權 callback URL</label>
                <input type="text" id="callback" class="form-control" name="callback" placeholder="OAuth callback URL" value="${appInfo.callback}">
				<p class="help-block"></p>
			</div>
		</div>
		<%-- /.box-body --%>
		<div class="box-footer">
			<button type="submit" class="btn btn-success">送出申請</button>
		</div>
	</form>
</div>
<%-- /.box --%>