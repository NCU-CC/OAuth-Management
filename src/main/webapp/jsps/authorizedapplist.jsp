<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="struts" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"></jsp:include>
        <div class="wrapper row-offcanvas row-offcanvas-left">
            <!-- Left side column. contains the logo and sidebar -->
            <jsp:include page="leftsider.jsp"></jsp:include>

            <!-- Right side column. Contains the navbar and content of the page -->
            <aside class="right-side">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>
                        已授權之軟體
                        <small>下列APP有權限存取您所授權的個人資料</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="#"><i class="fa fa-dashboard"></i>Home </a></li>
                        <li><a href="#"></i>Oauth </a></li>
                        <li class="active">Authorized Applications </li>
                    </ol>
                </section>

                <!-- Main content -->
                <section class="content">

                    <struts:set var="titlex" >您尚未註冊任何Token</struts:set>
                    
                    <struts:if test="tokenList !=null && tokenList.size() > 0">
                        <struts:set var="titlex" >Token列表</struts:set>
                    </struts:if>

                   
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="box">
                                <div class="box-header">
                                    <h3 class="box-title"><struts:property value="titlex"/></h3>
                                    
                                </div><!-- /.box-header -->
                                <div class="box-body table-responsive no-padding">
                                <struts:if test="tokenList !=null && tokenList.size() > 0">
                                    <table class="table table-hover">
                                        <tr>
                                            <th>ID</th>
                                            <th>名稱</th>
                                            <th>權限</th>
                                            <th>簡介</th>
                                            <th>授權</th>
                                        </tr>
                                        <struts:iterator value="tokenList" >
                                            <tr>
                                            <td>${id }</td>
                                            <td>${application.name }</td>
                                            <td>${scopeString }</td>
                                            <td>${application.description}</td>
                                            <td><a href="<struts:url namespace="/user" action='cancel'><struts:param name="id" >${id }</struts:param><struts:param name="struts.token.name" value="%{'token'}"/><struts:param name="token" value="%{token}"/></struts:url>" data-confirm="是否要獲刪除Token？ " data-method="post" ><span class="label label-danger">取消</span></a></td>
                                        </tr>
                                        </struts:iterator>                                        
                                    </table>
                                    </struts:if>
                                </div><!-- /.box-body -->
                            </div><!-- /.box -->
                        </div>
                    </div>

                </section><!-- /.content -->
            </aside><!-- /.right-side -->
        </div><!-- ./wrapper -->

        <!-- add new calendar event modal -->


        <jsp:include page="usingcommonjs.jsp"></jsp:include>
        <script src="<c:url value='/js/rails.js'/>" type="text/javascript"></script>
        <script src="<c:url value='/js/data-confirm-modal.js'/>" type="text/javascript"></script>  

    </body>
</html>
