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
                                                                        取消APP授權
                        <small>取消APP授權後該APP將無法存取您的個人資料</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="#"><i class="fa fa-dashboard"></i>Home </a></li>
                        <li><a href="#">Oauth </a></li>
                        <li class="active">Authorized Applications </li>
                    </ol>
                </section>               
                

                <!-- Main content -->
                <section class="content invoice">

                    
                    <!-- title row -->
                    <div class="row">
                        <div class="col-xs-12">
                            <h2 class="page-header">
                                <i class="fa fa-globe"></i> 選課APP
                                <small class="pull-right">Date: 2/10/2014</small>
                            </h2>
                        </div><!-- /.col -->
                    </div>
                    <!-- info row -->
                    <div class="row invoice-info">
                        <div class="col-sm-4 invoice-col">
                            APP 介紹
                            <address>
                                <strong>NCUAPP.是中央大學oauth的服務網站，透過此網站您可以掌握您oauth的使用情形</strong><br>
                            </address>
                        </div><!-- /.col -->
                        <div class="col-sm-4 invoice-col">
                            APP 受援項目
                            <address><strong>
                                public_repo<br>
                                user:email<br>
                                write:repo_hook<br/></strong>
                            </address>
                        </div><!-- /.col -->
                        <div class="col-sm-4 invoice-col">
                            
                        </div><!-- /.col -->
                    </div><!-- /.row -->

                   

                    <!-- this row will not appear when printing -->
                    <div class="row no-print">
                        <div class="col-xs-12">
                            <a href=" <struts:url namespace="/user" action='cancelok'/> "><button class="btn btn-danger pull-left"><i class="fa fa-ban"></i> 取消授權</button></a>
                        </div>
                    </div>

                </section><!-- /.content -->
            </aside><!-- /.right-side -->
        </div><!-- ./wrapper -->

        <!-- add new calendar event modal -->


        <jsp:include page="usingcommonjs.jsp"></jsp:include>


    </body>
</html>
