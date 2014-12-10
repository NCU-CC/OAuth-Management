<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<jsp:include page="header.jsp"></jsp:include>
        <div class="wrapper row-offcanvas row-offcanvas-left">
            <%-- Left side column. contains the logo and sidebar --%>
            <jsp:include page="leftsider.jsp"></jsp:include>

            <%-- Right side column. Contains the navbar and content of the page --%>
            <aside class="right-side">
                <%-- Content Header (Page header) --%>
                <section class="content-header">
                    <h1>
                        API列表
                        <small>下列是目前已開放使用的API</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="#"><i class="fa fa-dashboard"></i>Home </a></li>
                        <li><a href="#">Oauth </a></li>
                        <li class="active">Authorized Applications </li>
                    </ol>
                </section>

                <%-- Main content --%>
                <section class="content">

                    

                   
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="box">
                                <div class="box-header">
                                    <h3 class="box-title">已開放API列表</h3>
                                    
                                </div><%-- /.box-header --%>
                                <div class="box-body table-responsive no-padding">
                                    <table class="table table-hover">
                                        <tr>
                                            <th>ID</th>
                                            <th>名稱</th>
                                            <th>權限</th>
                                            <th>簡介</th>
                                            <th>驗證</th>
                                        </tr>
                                        <tr>
                                            <td>1</td>
                                            <td><a href="#" target="_blank">個人資料</a></td>
                                            <td>讀取</td>
                                            <td>可以得知使用者的學號、姓名與信箱</td>
                                            <td><span class="label label-info">OAUTH</span></td>
                                        </tr>
                                        <tr>
                                            <td>2</td>
                                            <td><a href="#" target="_blank">校園活動</a></td>
                                            <td>讀取</td>
                                            <td>可以讀取校園近期所有的活動資訊</td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>3</td>
                                            <td><a href="#" target="_blank">選課系統</a></td>
                                            <td>讀取、寫入</td>
                                            <td>可以讀取使用者的課表、幫使用者選課與退選課</td>
                                            <td><span class="label label-info">OAUTH</span></td>
                                        </tr>
                                        <tr>
                                            <td>4</td>
                                            <td><a href="#" target="_blank">宿舍網路</a></td>
                                            <td>讀取</td>
                                            <td>可以讀取使用者目前使用流量</td>
                                            <td><span class="label label-info">OAUTH</span></td>
                                        </tr>
                                    </table>
                                </div><%-- /.box-body --%>
                            </div><%-- /.box --%>
                        </div>
                    </div>

                </section><%-- /.content --%>
            </aside><%-- /.right-side --%>
        </div><%-- ./wrapper --%>

        <%-- add new calendar event modal --%>


        <jsp:include page="usingcommonjs.jsp"></jsp:include>


    </body>
</html>
