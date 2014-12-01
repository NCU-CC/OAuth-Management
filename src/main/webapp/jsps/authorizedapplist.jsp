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

                    

                   
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="box">
                                <div class="box-header">
                                    <h3 class="box-title">已授權軟體列表</h3>
                                    
                                </div><!-- /.box-header -->
                                <div class="box-body table-responsive no-padding">
                                    <table class="table table-hover">
                                        <tr>
                                            <th>ID</th>
                                            <th>名稱</th>
                                            <th>權限</th>
                                            <th>簡介</th>
                                            <th>授權</th>
                                        </tr>
                                        <tr>
                                            <td>183</td>
                                            <td><a href="#" target="_blank">中大地圖</a></td>
                                            <td>user:email</td>
                                            <td>NCUAPP.是中央大學oauth的服務網站，透過此網站您可以掌握您oauth的使用情形</td>
                                            <td><a href="<struts:url namespace="/user" action='cancel'/>"><span class="label label-danger">取消</span></a></td>
                                        </tr>
                                        <tr>
                                            <td>219</td>
                                            <td><a href="#" target="_blank">選課APP</a></td>
                                            <td>public_repo, user:email</td>
                                            <td>現階段NCUAPP.只提供course的web service，在將來我們我提供更多服務</td>
                                            <td><a href="<struts:url namespace="/user" action='cancel'/>"><span class="label label-danger">取消</span></a></td>
                                        </tr>
                                        <tr>
                                            <td>657</td>
                                            <td><a href="#" target="_blank">公車資訊通</a></td>
                                            <td>read:org, repo:status, repo_deployment, user:email, write:repo_hook</td>
                                            <td>NCUAPP.是相當安全的，我們全程透過ssl加密來傳送資料。不需要當心您的資料被竊取。</td>
                                            <td><a href="<struts:url namespace="/user" action='cancel'/>"><span class="label label-danger">取消</span></a></td>
                                        </tr>
                                        <tr>
                                            <td>175</td>
                                            <td><a href="#" target="_blank">課外活動通</a></td>
                                            <td>repo, user:email</td>
                                            <td>NCUAPP.是中央大學oauth的服務網站，透過此網站您可以掌握您oauth的使用情形</td>
                                            <td><a href="<struts:url namespace="/user" action='cancel'/>"><span class="label label-danger">取消</span></a></td>
                                        </tr>
                                    </table>
                                </div><!-- /.box-body -->
                            </div><!-- /.box -->
                        </div>
                    </div>

                </section><!-- /.content -->
            </aside><!-- /.right-side -->
        </div><!-- ./wrapper -->

        <!-- add new calendar event modal -->


        <jsp:include page="usingcommonjs.jsp"></jsp:include>


    </body>
</html>
