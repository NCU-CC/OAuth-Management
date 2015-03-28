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
				<tiles:insertAttribute name="primaryTitle" />
				<small><tiles:insertAttribute name="secondaryTitle" /></small>
			</h1>
		</section>

		<%-- Main content --%>
		<section class="content"><tiles:insertAttribute name="mainContent"/></section>
		<%-- /.content --%>


	</aside>
	<%-- /.right-side --%>
</div>
<%-- ./wrapper --%>
<tiles:insertAttribute name="jsFiles" />
</body>
</html>