<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<jsp:include page="header.jsp"></jsp:include>
        <div class="wrapper row-offcanvas row-offcanvas-left">
            <%-- Left side column. contains the logo and sidebar --%>
            <jsp:include page="leftsider.jsp"></jsp:include>

            <%-- Right side column. Contains the navbar and content of the page --%>
            <aside class="right-side">
                <%-- Content Header (Page header) --%>
                <section class="content-header">
                    <h1>教學頁面</h1>
                    <ol class="breadcrumb">
                        <li><a href="#"><i class="fa fa-dashboard"></i>Home </a></li>
                        <li><a href="#">OAuth-Management</a></li>
                        <li class="active">Authorized Applications </li>
                    </ol>
                </section>
                
                <%-- Main content --%>
                <section class="content invoice">

                    
                    <%-- title row --%>
                    <div class="row">
                        <div class="col-xs-12">
                            <h2 class="page-header">
                                <i class="fa fa-user-md"></i> 開發者教學
                                <small class="pull-right">Date: 2/10/2014</small>
                            </h2>
                        </div><%-- /.col --%>
                    </div>
                    <%-- info row --%>
                    <div class="row invoice-info">
                        <div class="col-sm-12 invoice-col">
                                                                                               
                                                                                               
                            <div id="preview" preview=""><h1 id="oauth-for-">Oauth教學 for 開發者</h1>
								<p>此網站主要是提供給開發者</p>
								<ul>
								<li>APP開發申請</li>
								<li>刪除APP</li>
								<li>取得新的Secret碼</li>
								<li>編輯APP申請內容</li>
								</ul>
								<h5 id="app-">APP開發申請</h5>
								<ul>
								<li>點擊畫面左方的 <strong>開發人員軟體管理 --&gt; 註冊新APP</strong></li>
								<li>填寫<strong>相關內容</strong></li>
								<li>取得<strong>secret</strong>碼與<strong>client id</strong></li>
								</ul>
								<h5 id="-app">刪除APP</h5>
								<ul>
								<li>點擊畫面左方的 <strong>開發人員軟體管理 --&gt; APP開發管理</strong></li>
								<li>顯示<strong>APP列表</strong>，選擇要刪除的APP，點擊右方<strong>修改</strong></li>
								<li>點選<strong>刪除</strong></li>
								</ul>
								<h5 id="-secret-">取得新的Secret碼</h5>
								<ul>
								<li>點擊畫面左方的 <strong>開發人員軟體管理 --&gt; APP開發管理</strong></li>
								<li>顯示<strong>APP列表</strong>，選擇要取得的APP，點擊右方<strong>修改</strong></li>
								<li>點選<strong>新的secret</strong></li>
								</ul>
								<h5 id="-app-">編輯APP申請內容</h5>
								<ul>
								<li>點擊畫面左方的 <strong>開發人員軟體管理 --&gt; APP開發管理</strong></li>
								<li>顯示<strong>APP列表</strong>，選擇要取得的APP，點擊右方<strong>修改</strong></li>
								<li>修改內容</li>
								<li>點擊<strong>更新APP</strong></li>
								</ul>
							</div>
                            
                            
                                                                                                       
                        </div><%-- /.col --%>                        
                    </div><%-- /.row --%>

                   

                    

                </section><%-- /.content --%>
            </aside><%-- /.right-side --%>
        </div><%-- ./wrapper --%>

        <%-- add new calendar event modal --%>


       <jsp:include page="usingcommonjs.jsp"></jsp:include>


    </body>
</html>
