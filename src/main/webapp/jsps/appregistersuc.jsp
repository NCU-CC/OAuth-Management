<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="struts" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"></jsp:include>
        <div class="wrapper row-offcanvas row-offcanvas-left">
            <%-- Left side column. contains the logo and sidebar --%>
            <jsp:include page="leftsider.jsp"></jsp:include>

            <%-- Right side column. Contains the navbar and content of the page --%>
            <aside class="right-side">
                <%-- Content Header (Page header) --%>
                <section class="content-header">
                    <h1>
                                                                        新增APP成功
                        <small>APP內容</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="#"><i class="fa fa-dashboard"></i>Home </a></li>
                        <li><a href="#"></i>Oauth </a></li>
                        <li class="active">Authorized Applications </li>
                    </ol>
                </section>
               
               
               <div class="pad margin no-print">
                        <div class="alert alert-info" style="margin-bottom: 0!important;">
                            <i class="fa fa-info"></i>
                            <b>申請成功</b> 
                        </div>
                    </div>
               
                <%-- Main content --%>
                <section class="content">

                    
                   <%-- left column --%>
                            <div class="box box-primary invoice">
                                <div class="box-header">
                                    <h3 class="box-title">申請表單</h3>
                                </div><%-- /.box-header --%>
                                <%-- form start --%>
                                
                                    <div class="box-body">
                                        <div class="form-group">
                                            <label for="exampleInputEmail1">APP名稱</label>
                                            <input type="text" class="form-control" name="appInfo.name" placeholder="Enter APP's name" value="${appInfoid.name }" disabled>
                                            <p class="help-block">Something users will recognize and trust</p>
                                        </div>
                                        <div class="form-group">
                                            <label for="exampleInputEmail1">APP網站URL</label>
                                            <input type="text" class="form-control" name="appInfo.url" placeholder="Website url" value="${appInfoid.url }" disabled>
                                            <p class="help-block">The full URL to your application homepage</p>
                                        </div>
                                        <div class="form-group">
                                            <label for="exampleInputEmail1">APP簡述</label>
                                            <input type="text" class="form-control" name="appInfo.description" placeholder="Description" value="${appInfoid.description }" disabled>
                                            <p class="help-block">This is displayed to all potential users of your application</p>
                                        </div>
                                        <div class="form-group">
                                            <label for="exampleInputEmail1">授權 callback URL</label>
                                            <input type="text" class="form-control" name="appInfo.callback" placeholder="Callback url" value="${appInfoid.callback }" disabled>
                                            <p class="help-block">Your application's callback URL. Read our OAuth documentation for more information</p>
                                        </div>
                                        <div class="form-group">
                                            <label for="exampleInputEmail1">Client ID</label>
                                            <input type="text" class="form-control" name="appInfo.callback" placeholder="Callback url" value="${appInfoid.id }" disabled>
                                            <p class="help-block"></p>
                                        </div>
                                        <div class="form-group">
                                            <label for="exampleInputEmail1">Secret</label>
                                            <input type="text" class="form-control" name="appInfo.callback" placeholder="Callback url" value="${appInfoid.secret }" disabled>
                                            <p class="help-block">僅會出現一次，請將secret儲存起來</p>
                                        </div>
                                        
                                            
                                    </div><%-- /.box-body --%>
                                     <div class="row no-print">
				                        <div class="col-xs-12">
				                            <a href="<struts:url namespace="/dev" action='list'/>"><button class="btn btn-success pull-left"><i class="fa fa-reply"></i> 返回</button></a>
				                        </div>
				                    </div>
                                    
                                <%--</form>--%>
                            </div><%-- /.box --%>

                </section><%-- /.content --%>
            </aside><%-- /.right-side --%>
        </div><%-- ./wrapper --%>

        <%-- add new calendar event modal --%>

    
        <jsp:include page="usingcommonjs.jsp"></jsp:include>
        <script src="<c:url value='/js/rails.js'/>" type="text/javascript"></script>
        <script src="<c:url value='/js/data-confirm-modal.js'/>" type="text/javascript"></script>        

    </body>
</html>
