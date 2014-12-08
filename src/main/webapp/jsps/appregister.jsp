<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="struts" %>
<jsp:include page="header.jsp"></jsp:include>
        <div class="wrapper row-offcanvas row-offcanvas-left">
            <!-- Left side column. contains the logo and sidebar -->
            <jsp:include page="leftsider.jsp"></jsp:include>

            <!-- Right side column. Contains the navbar and content of the page -->
            <aside class="right-side">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>
                                                                        註冊APP
                        <small>註冊APP將可使用API</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="#"><i class="fa fa-dashboard"></i>Home </a></li>
                        <li><a href="#"></i>Oauth </a></li>
                        <li class="active">Authorized Applications </li>
                    </ol>
                </section>
                
                
                <struts:if test="errorTitle!=null">
	                <div class="pad margin no-print">
	                    <div class="alert alert-danger alert-dismissable" style="margin-bottom: 0!important;">
	                        <i class="fa fa-ban"></i>
	                        <b>${errorTitle }:</b> ${errorContent }
	                    </div>
	                </div>
                </struts:if>
                
                
                
                <!-- Main content -->
                <section class="content">

                    
                   <!-- left column -->
                            <div class="box box-primary invoice">
                                <div class="box-header">
                                    <h3 class="box-title">申請表單</h3>
                                </div><!-- /.box-header -->
                                <!-- form start -->
                                <struts:form role="form" namespace="/dev" action='tonew' method='post'>                                
                                   <div class="box-body">
                                        <div class="form-group">
                                            <label for="exampleInputEmail1">APP名稱</label>
                                            <input type="text" class="form-control" name="appInfo.name" placeholder="Enter APP's name" value="${appInfo.name }">
                                            <p class="help-block">Something users will recognize and trust</p>
                                        </div>
                                        <div class="form-group">
                                            <label for="exampleInputEmail1">APP網站URL</label>
                                            <input type="text" class="form-control" name="appInfo.url" placeholder="Website url" value="${appInfo.url }">
                                            <p class="help-block">The full URL to your application homepage</p>
                                        </div>
                                        <div class="form-group">
                                            <label for="exampleInputEmail1">APP簡述</label>
                                            <input type="text" class="form-control" name="appInfo.description" placeholder="Description" value="${appInfo.description }">
                                            <p class="help-block">This is displayed to all potential users of your application</p>
                                        </div>
                                        <div class="form-group">
                                            <label for="exampleInputEmail1">授權 callback URL</label>
                                            <input type="text" class="form-control" name="appInfo.callback" placeholder="Callback url" value="${appInfo.callback }">
                                            <p class="help-block">Your application's callback URL. Read our OAuth documentation for more information</p>
                                        </div>
                                            
                                    </div><!-- /.box-body -->

                                    <div class="box-footer">                                        
                                        <button type="submit" class="btn btn-success">送出申請</button>                                        
                                    </div>
                                </struts:form>
                            </div><!-- /.box -->

                </section><!-- /.content -->
            </aside><!-- /.right-side -->
        </div><!-- ./wrapper -->

        <!-- add new calendar event modal -->


        <jsp:include page="usingcommonjs.jsp"></jsp:include>


    </body>
</html>
