<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp"></jsp:include>
<div class="wrapper row-offcanvas row-offcanvas-left">
	<%-- Left side column. contains the logo and sidebar --%>
	<jsp:include page="leftsider.jsp"></jsp:include>

	<%-- Right side column. Contains the navbar and content of the page --%>
	<aside class="right-side">
		<%-- Content Header (Page header) --%>
		<section class="content-header">
			<h1>
				教學頁面 <small></small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="#"><i class="fa fa-dashboard"></i>Home </a></li>
				<li><a href="#"></i>Oauth </a></li>
				<li class="active">Authorized Applications</li>
			</ol>
		</section>

		<%-- Main content --%>
		<section class="content invoice">


			<%-- title row --%>
			<div class="row">
				<div class="col-xs-12">
					<h2 class="page-header">
						<i class="fa fa-user-md"></i> 使用者教學 <small class="pull-right">Date:
							2/10/2014</small>
					</h2>
				</div>
				<%-- /.col --%>
			</div>
			<%-- info row --%>
			<div class="row invoice-info">
				<div class="col-sm-12 invoice-col">


					<div>
						<h1 id="oauth-for-">Oauth教學 for 使用者</h1>
						<p>此網站主要是提供給使用者</p>
						<ul>
							<li>查看授權給APP的權限</li>
							<li>取消授權給APP的權限</li>
						</ul>
						<p>Note</p>
						<pre>
							<code>
							<span class="hljs-bullet">- </span>這授權指的是在使用APP時，同意所跳出的授權網頁所要求的權限
							<img src="<c:url value='/images/authweb.png'/>">
							</code>
						</pre>


						<h5 id="-app-">查看授權給APP的權限</h5>
						<ul>
							<li>點擊畫面左方的 <strong>使用者軟體管理 --&gt; 已授權管理</strong></li>
							<li>呈現<strong>已授權給APP的權限</strong></li>
						</ul>
						<h5 id="-app-">取消授權給APP的權限</h5>
						<ul>
							<li>查看授權給APP的權限的頁面中，右方有<strong>取消授權</strong>的按鈕
							</li>
							<li>點擊<strong>取消授權</strong>後，授權就會取消
							</li>
						</ul>
					</div>


				</div>
				<%-- /.col --%>
			</div>
			<%-- /.row --%>





		</section>
		<%-- /.content --%>
	</aside>
	<%-- /.right-side --%>
</div>
<%-- ./wrapper --%>

<%-- add new calendar event modal --%>


<jsp:include page="usingcommonjs.jsp"></jsp:include>


</body>
</html>
