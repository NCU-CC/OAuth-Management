<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%-- title row --%>
<div class="row">
	<div class="col-xs-12">
		<h2 class="page-header">
			<i class="fa fa-user-md"></i> 使用者教學<small class="pull-right">修改日期:2014-10-02</small>
		</h2>
	</div>
	<%-- /.col --%>
</div>
<%-- info row --%>
<div class="row invoice-info">
	<div class="col-sm-12 invoice-col">
		<div>
			<h1 id="oauth-for-">OAuth教學</h1>
			<p>此網站主要是提供給一般使用者</p>
			<ul>
				<li>查看授權給App的權限</li>
				<li>取消授權給App的權限</li>
			</ul>
			<p>Note</p>
			<pre>
							<code>
							<span class="hljs-bullet">- </span>這授權指的是在使用App時，同意所跳出的授權網頁所要求的權限
							<img src="<c:url value="/resources/images/authweb.png"/>" />
							</code>
						</pre>


			<h5 id="-App-">查看授權給App的權限</h5>
			<ul>
				<li>點擊畫面左方的 <strong>使用者軟體管理 --&gt; 已授權管理</strong></li>
				<li>呈現<strong>已授權給App的權限</strong></li>
			</ul>
			<h5 id="-App-">取消授權給App的權限</h5>
			<ul>
				<li>查看授權給App的權限的頁面中，右方有<strong>取消授權</strong>的按鈕
				</li>
				<li>點擊<strong>取消授權</strong>後，授權就會取消
				</li>
			</ul>
		</div>


	</div>
	<%-- /.col --%>
</div>
<%-- /.row --%>
