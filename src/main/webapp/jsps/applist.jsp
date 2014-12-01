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
                        程式開發APP
                        <small>下列APP是您已註冊去使用API的申請</small>
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
                                    <h3 class="box-title">APP列表</h3>
                                    <div class="box-tools">
                                        <div class="input-group">
                                            
                                            <div class="input-group-btn">
                                                <a href="<struts:url namespace="/dev" action='new'/>"><button class="btn btn-sm btn-default pull-right"><i class="fa fa-plus"> 註冊新APP</i></button></a>
                                            </div>
                                        </div>
                                    </div>
                                </div><!-- /.box-header -->
                                <div class="box-body table-responsive no-padding">
                                    <table class="table table-hover">
                                        <tr>
                                            <th>ID</th>
                                            <th>名稱</th>
                                            <th>網站URL</th>
                                            <th>簡介</th>
                                            <th></th>
                                        </tr>
                                        <tr>
                                            <td>183</td>
                                            <td>中大地圖</td>
                                            <td><a href="#" target="_blank">http://appforncu.appspot.com/</a></td>
                                            <td>NCUAPP.是中央大學oauth的服務網站，透過此網站您可以掌握您oauth的使用情形</td>
                                            <td><a href="<struts:url namespace="/dev" action='edit'/>"><span class="label label-primary">修改</span></a></td>
                                        </tr>
                                        <tr>
                                            <td>219</td>
                                            <td>選課APP</td>
                                            <td><a href="#" target="_blank">http://appforncu.appspot.com/</a></td>
                                            <td>現階段NCUAPP.只提供course的web service，在將來我們我提供更多服務</td>
                                            <td><a href="<struts:url namespace="/dev" action='edit'/>"><span class="label label-primary">修改</span></a></td>
                                        </tr>
                                        <tr>
                                            <td>657</td>
                                            <td>公車資訊通</td>
                                            <td><a href="#" target="_blank">http://appforncu.appspot.com/</a></td>
                                            <td>NCUAPP.是相當安全的，我們全程透過ssl加密來傳送資料。不需要當心您的資料被竊取。</td>
                                            <td><a href="<struts:url namespace="/dev" action='edit'/>"><span class="label label-primary">修改</span></a></td>
                                        </tr>
                                        <tr>
                                            <td>175</td>
                                            <td>課外活動通</td>
                                            <td><a href="#" target="_blank">http://appforncu.appspot.com/</a></td>
                                            <td>NCUAPP.是中央大學oauth的服務網站，透過此網站您可以掌握您oauth的使用情形</td>
                                            <td><a href="<struts:url namespace="/dev" action='edit'/>"><span class="label label-primary">修改</span></a></td>
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
