<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<aside class="left-side sidebar-offcanvas">
	<%-- sidebar: style can be found in sidebar.less --%>
	<section class="sidebar">
	    <%-- Sidebar user panel --%>
	    <div class="user-panel">
	        <div class="pull-left image">
	            <img src="<c:url value='/resources/img/avatar3.png'/>" class="img-circle" alt="User Image" />
	        </div>
	        <div class="pull-left info">
	            <p>Hello, ${sessionScope._user.name}</p>
	        </div>
	    </div>

	    <%-- sidebar menu: : style can be found in sidebar.less --%>
	    <ul class="sidebar-menu">
	        <li>
	            <a href="<c:url value="/"/>">
	                <i class="fa fa-home"></i><span>首頁</span>
	            </a>
	        </li>
	        <li class="treeview active">
	            <a href="#">
	                <i class="fa fa-user"></i>
	                <span>使用者功能</span>
	                <i class="fa fa-angle-left pull-right"></i>
	            </a>
	            <ul class="treeview-menu">
					<li><a href="<c:url value="/user/tutorial"/>" ><i class="fa fa-angle-double-right"></i>使用者說明</a></li>
	            	<li><a href="<c:url value="/user/token/list"/>"><i class="fa fa-angle-double-right"></i>授權管理</a></li>                               
	            </ul>
	        </li>
	        <li class="treeview active">
	            <a href="#">
	                <i class="fa fa-laptop"></i>
	                <span>開發者功能</span>
	                <i class="fa fa-angle-left pull-right"></i>
	            </a>
	            <ul class="treeview-menu">
					<li><a href="<c:url value="/developer/tutorial"/>" ><i class="fa fa-angle-double-right"></i>開發者說明</a></li>
	                <li><a href="<c:url value="/developer/client/list"/>"><i class="fa fa-angle-double-right"></i>應用服務管理</a></li>
	            </ul>
	        </li>

			<security:authorize access="hasRole('ADMIN')">
                <li class="treeview active">
                    <a href="#">
                        <i class="fa fa-unlock-alt"></i>
                        <span>使用者管理</span>
                        <i class="fa fa-angle-left pull-right"></i>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="<c:url value="/godmode/userManage"/>"><i class="fa fa-angle-double-right"></i>使用者管理</a></li>
                        <li><a href="<c:url value="/godmode/userAuthorizedTokenManage"/>"><i class="fa fa-angle-double-right"></i>使用者授權管理</a></li>
                        <li><a href="<c:url value="/godmode/blacklist/user"/>"><i class="fa fa-angle-double-right"></i>使用者黑名單</a></li>
                    </ul>
                </li>
                
                <li class="treeview active">
                    <a href="#">
                        <i class="fa fa-unlock-alt"></i>
                        <span>應用服務管理</span>
                        <i class="fa fa-angle-left pull-right"></i>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="<c:url value="/godmode/clientManage"/>"><i class="fa fa-angle-double-right"></i>應用服務</a></li>
                        <li><a href="<c:url value="/godmode/blacklist/client"/>"><i class="fa fa-angle-double-right"></i>應用服務黑名單</a></li>
                    </ul>
                </li>
                
		        <li class="treeview active">
		            <a href="#">
		                <i class="fa fa-unlock-alt"></i>
		                <span>管理者功能</span>
		                <i class="fa fa-angle-left pull-right"></i>
		            </a>
		            <ul class="treeview-menu">
	                    <li><a href="<c:url value="/godmode/statistic"/>"><i class="fa fa-angle-double-right"></i>統計報表(未完成)</a></li>
	                    <li><a href="<c:url value="/godmode/manager"/>"><i class="fa fa-angle-double-right"></i>系統管理者管理</a></li>
		            </ul>
		        </li>
	        </security:authorize>
	    </ul>
	</section>
	<%-- /.sidebar --%>
</aside>
