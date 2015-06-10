<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertAttribute name="header" />

<div class="wrapper row-offcanvas row-offcanvas-left">
	<%-- Left side column. contains the logo and sidebar --%>
	<tiles:insertAttribute name="leftsider" />

	<%-- Right side column. Contains the navbar and content of the page --%>
	<aside class="right-side">
		<%-- Content Header (Page header) --%>
		<section class="content-header">
			<h1>
				<tiles:insertAttribute name="primaryTitle" defaultValue=""/>
				<small><tiles:insertAttribute name="secondaryTitle" defaultValue=""/></small>
			</h1>
		</section>

		<%-- Main content --%>
		<section class="content"><tiles:insertAttribute name="mainContent"/></section>
		<%-- /.content --%>


	</aside>
	<footer class="main-footer">
	   <strong>Copyright © 2015 Computer Center, National Central University.</strong>All rights reserved.　<a href="mailto:mobile@cc.ncu.edu.tw"><i class="fa fa-envelope-o"></i>寄信給我們</a>
	</footer>
	<%-- /.right-side --%>
</div>
<%-- ./wrapper --%>
<tiles:insertAttribute name="jsFiles" />
</body>
</html>