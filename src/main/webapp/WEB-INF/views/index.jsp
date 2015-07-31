<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%-- Small boxes (Stat box) --%>
<div class="row">
	<div class="col-lg-4 col-xs-6">
		<%-- small box --%>
		<div class="small-box bg-aqua">
			<div class="inner">
				<h3>使用者說明</h3>
				<p>給一般使用者的說明</p>
			</div>
			<div class="icon">
				<i class="ion ion-ios7-paper-outline"></i>
			</div>
			<a href="<c:url value='/user/tutorial'/>" class="small-box-footer">
				More info <i class="fa fa-arrow-circle-right"></i>
			</a>
		</div>
		
		<%-- small box --%>
        <div class="small-box bg-yellow">
            <div class="inner">
                <h3>開發者說明</h3>
                <p>給應用程式開發者的說明</p>
            </div>
            <div class="icon">
                <i class="ion ion-ios7-paper"></i>
            </div>
            <a href="<c:url value='/developer/tutorial'/>" class="small-box-footer">
                More info <i class="fa fa-arrow-circle-right"></i>
            </a>
        </div>
	</div>
	<%-- ./col --%>
</div>
<%-- /.row --%>