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
                    
                </section>
                

                <%-- Main content --%>
                <section class="content">
                    
                   <%-- left column --%>
                            <div class="box box-primary invoice">
                            <div class="col-md-2"></div>
                                <div class="col-md-8">
                                    <div class="box box-info">
                                        <div class="box-header">
                                            <i class="fa fa-bullhorn"></i>
                                            <h3 class="box-title">通知</h3>
                                        </div><%-- /.box-header --%>
                                        <div class="box-body">                                          
                                            <div class="callout callout-info">
                                                <h4>成功刪除</h4>
                                                <p>成功刪除TOKEN</p>
                                                   
                                            </div>
                                            <a href="<c:url action='/user/list'/>"><button class="btn btn-success"><i class="fa fa-reply"></i> 返回</button></a>       
                                        </div><%-- /.box-body --%>
                                        
                                    </div><%-- /.box --%>
                                </div><%-- /.col --%>
                            </div> <%-- /.row --%>

                </section><%-- /.content --%>
            </aside><%-- /.right-side --%>
        </div><%-- ./wrapper --%>

        <%-- add new calendar event modal --%>


        <jsp:include page="usingcommonjs.jsp"></jsp:include>


    </body>
</html>
