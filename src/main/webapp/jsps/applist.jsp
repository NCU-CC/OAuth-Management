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
                        程式開發APP
                        <small>下列APP是您已註冊去使用API的申請</small>
                    </h1>                    
                </section>

                <!-- Main content -->
                <section class="content">
                

                    
                    <struts:set var="titlex" >您尚未註冊任何APP</struts:set>
                    
                    <struts:if test="appList !=null && appList.size() > 0">
                        <struts:set var="titlex" >APP列表</struts:set>
                    </struts:if>

                   
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="box">
                                <div class="box-header">
                                    <h3 class="box-title"><struts:property value="titlex"/></h3>
                                    <div class="box-tools">
                                        <div class="input-group">
                                            
                                            <div class="input-group-btn">
                                                <a href="<struts:url namespace="/dev" action='new'/>"><button class="btn btn-sm btn-default pull-right"><i class="fa fa-plus"> 註冊新APP</i></button></a>
                                            </div>
                                        </div>
                                    </div>
                                </div><!-- /.box-header -->
                                <div class="box-body table-responsive no-padding">
                                <struts:if test="appList !=null && appList.size() > 0">
                                    <table class="table table-hover">
                                        <tr>
                                            <th>ID</th>
                                            <th>名稱</th>
                                            <th>網站URL</th>
                                            <th>簡介</th>
                                            <th>編輯</th>
                                        </tr>                   
                                        <struts:iterator value="appList" >
                                            <tr>
                                            <td>${id }</td>
                                            <td>${name }</td>
                                            <td><a href="${url }" target="_blank">${url }</a></td>
                                            <td>${description}</td>
                                            <td><a href="<struts:url namespace="/dev" action='edit' ><struts:param name="id" >${id }</struts:param></struts:url>"><span class="label label-primary">修改</span></a></td>
                                        </tr>
                                        </struts:iterator>
                                                                                
                                        
                                    </table>
                                    </struts:if>
                                        <struts:else>
                                        
                                        
                                        <div class="col-xs-2"></div>
                                            <div class="col-xs-8">
                                                <a class="btn btn-block btn-social btn-foursquare" href="<struts:url namespace="/dev" action='new'/>">
                                                    <i class="fa fa-plus"></i> 註冊新APP
                                                </a>     
                                                </div>
                                                                   
                                        </struts:else>
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
