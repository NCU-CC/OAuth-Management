<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="struts" %>
<jsp:include page="header.jsp"></jsp:include>
        <div class="wrapper row-offcanvas row-offcanvas-left">
            <%-- Left side column. contains the logo and sidebar --%>
            <jsp:include page="leftsider.jsp"></jsp:include>

            <%-- Right side column. Contains the navbar and content of the page --%>
            <aside class="right-side">
                <%-- Content Header (Page header) --%>
                <section class="content-header">
                    <h1>
                        歡迎來到OAuth管理網站
                        <small></small>
                    </h1>
                    <ol class="breadcrumb">
                        <li class="active"><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                    </ol>
                </section>

                <%-- Main content --%>
                <section class="content">

                    <%-- Small boxes (Stat box) --%>
                    <div class="row">
                        <div class="col-lg-4 col-xs-6">
                            <%-- small box --%>
                            <div class="small-box bg-aqua">
                                <div class="inner">
                                    <h3>
                                                                                                                                                 使用說明
                                    </h3>
                                    <p>
                                                                                                                                                  一般使用者
                                    </p>
                                </div>
                                <div class="icon">
                                    <i class="ion ion-ios7-paper-outline"></i>
                                </div>
                                <a href="<struts:url namespace="/tutorial" action='user'/>" class="small-box-footer">
                                    More info <i class="fa fa-arrow-circle-right"></i>
                                </a>
                            </div>
                        </div><%-- ./col --%>
                        <div class="col-lg-4 col-xs-6">
                            <%-- small box --%>
                            <div class="small-box bg-aqua">
                                <div class="inner">
                                    <h3>
                                                                                                                                                  授權管理
                                    </h3>
                                    <p>
                                       一般使用者
                                    </p>
                                </div>
                                <div class="icon">
                                    <i class="ion ion-ios7-gear"></i>
                                </div>
                                <a href="<struts:url namespace="/user" action='list'/>" class="small-box-footer">
                                    More info <i class="fa fa-arrow-circle-right"></i>
                                </a>
                            </div>
                        </div><%-- ./col --%>
                        
                        
                    </div><%-- /.row --%>
                    <%-- Main row --%>
                    
      
      
       <%-- Small boxes (Stat box) --%>
                    <div class="row">
                        <div class="col-lg-4 col-xs-6">
                            <%-- small box --%>
                            <div class="small-box bg-yellow">
                                <div class="inner">
                                    <h3>
                                                                                                                                                 使用說明
                                    </h3>
                                    <p>
                                                                                                                                                  程式開發者
                                    </p>
                                </div>
                                <div class="icon">
                                    <i class="ion ion-ios7-paper"></i>
                                </div>
                                <a href="<struts:url namespace="/tutorial" action='dev'/>" class="small-box-footer">
                                    More info <i class="fa fa-arrow-circle-right"></i>
                                </a>
                            </div>
                        </div><%-- ./col --%>
                        <div class="col-lg-4 col-xs-6">
                            <%-- small box --%>
                            <div class="small-box bg-yellow">
                                <div class="inner">
                                    <h3>
                                                                                                                                                  程式管理
                                    </h3>
                                    <p>
                                        程式開發者
                                    </p>
                                </div>
                                <div class="icon">
                                    <i class="ion ion-settings"></i>
                                </div>
                                <a href="<struts:url namespace="/dev" action='list'/>" class="small-box-footer">
                                    More info <i class="fa fa-arrow-circle-right"></i>
                                </a>
                            </div>
                        </div><%-- ./col --%>
                        
                    </div><%-- /.row --%>
                    <%-- Main row --%>
                    
                    </section><%-- /.content --%>
                    
                   
                    
                    
                  
                   

                
            </aside><%-- /.right-side --%>
        </div><%-- ./wrapper --%>

        <%-- add new calendar event modal --%>


        <jsp:include page="usingcommonjs.jsp"></jsp:include>


    </body>
</html>
