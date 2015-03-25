<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"></jsp:include>
        <div class="wrapper row-offcanvas row-offcanvas-left">
            <%-- Left side column. contains the logo and sidebar --%>
            <jsp:include page="leftsider.jsp"></jsp:include>

            <%-- Right side column. Contains the navbar and content of the page --%>
            <aside class="right-side">
                <%-- Content Header (Page header) --%>
                <section class="content-header">
                    <h1>已授權之軟體<small>下列APP有權限存取您所授權的個人資料</small></h1>
                    <ol class="breadcrumb">
                        <li><a href="#"><i class="fa fa-dashboard"></i>Home </a></li>
                        <li><a href="#">OAuth-Management</a></li>
                        <li class="active">Authorized Applications </li>
                    </ol>
                </section>

                <%-- Main content --%>
                <section class="content">

                   
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="box">
                                <div class="box-header">
                                    <h3 class="box-title">
                                        <c:choose>
                                            <c:when test="${tokenList not empty }">Token列表</c:when>
                                            <c:otherwise>您尚未註冊任何Token</c:otherwise>
                                        </c:choose>
                                     </h3>
                                    
                                </div><%-- /.box-header --%>
                                <div class="box-body table-responsive no-padding">
                                <c:if test="${tokenList not empty}">
	                                <table class="table table-hover">
	                                        <tr>
	                                            <th>ID</th>
	                                            <th>名稱</th>
	                                            <th>權限</th>
	                                            <th>簡介</th>
	                                            <th>授權</th>
	                                        </tr>
	                                        <c:forEach var="token" items="${tokenList}">
	                                            <tr>
	                                            <td>${token.id }</td>
	                                            <td>${token.application.name}</td>
	                                            <td>${token.scopeString }</td>
	                                            <td>${token.application.description}</td>
	                                            <td><a href="<c:url action='/user/cancel?id=${id}&token="${token}&struts.token.name=token' />" data-confirm="是否要獲刪除Token？ " data-method="post" ><span class="label label-danger">取消</span></a></td>
	                                        </tr>
	                                        </c:forEach>                                        
	                                  </table>
                                </c:if>
                                </div><%-- /.box-body --%>
                            </div><%-- /.box --%>
                        </div>
                    </div>

                </section><%-- /.content --%>
            </aside><%-- /.right-side --%>
        </div><%-- ./wrapper --%>

        <%-- add new calendar event modal --%>


        <jsp:include page="usingcommonjs.jsp"></jsp:include>
        <script src="<c:url value='/js/rails.js'/>" type="text/javascript"></script>
        <script src="<c:url value='/js/data-confirm-modal.js'/>" type="text/javascript"></script>  

    </body>
</html>
