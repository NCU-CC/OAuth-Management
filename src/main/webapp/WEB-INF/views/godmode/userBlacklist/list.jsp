<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
	<div class="col-xs-12">
		<div class="box">
			<div class="box-header">
                <h3 class="box-title">黑名單管理</h3>
                <div class="box-tools">
                    <div class="input-group">
                        <div class="input-group-btn">
                            <a href="<c:url value="/godmode/blacklist/create"/>"><button
                                    class="btn btn-sm btn-default pull-right">
                                    <i class="fa fa-plus">新增黑名單</i>
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
						<th>開發者帳號</th>
                        <th>開發者姓名</th>
						<th>停權原因</th>
						<th>功能</th>
					</tr>
					<tr>
						<td>1</td>
						<td>1000101009</td>
						<td>王小明</td>
						<td>散播垃圾訊息</td>
						<td><a href="<c:url value='/godemode/blacklist/edit'/>"><span class="label label-primary">修改</span></a>
						<a href="<c:url value='/godemode/blacklist/delete'/>"><span class="label label-primary">刪除</span></a></td>
					</tr>
                    <tr>
                        <td>2</td>
                        <td>A020202</td>
                        <td>李小美</td>
                        <td>將token給其他開發者使用</td>
                        <td><a href="<c:url value='/godmode/blacklist/edit'/>"><span class="label label-primary">修改</span></a>
                        <a href="<c:url value='/godmode/blacklist/delete'/>"><span class="label label-primary">刪除</span></a></td>
                    </tr>
				</table>
			</div>
			<%-- /.box-body --%>
		</div>
		<%-- /.box --%>
	</div>
</div>
<script src="<c:url value='/resources/js/rails.js'/>" type="text/javascript"></script>
<script src="<c:url value='/resources/js/data-confirm-modal.js'/>" type="text/javascript"></script>
