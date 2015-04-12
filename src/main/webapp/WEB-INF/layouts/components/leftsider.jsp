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
                            <p>Hello, ${username}</p>
                            <a><i class="fa fa-circle text-success"></i>Online</a>
                        </div>
                    </div>
                    <%-- search form --%>
                    
                    <%-- /.search form --%>
                    <%-- sidebar menu: : style can be found in sidebar.less --%>
                    <ul class="sidebar-menu">
                        <li>
                            <a href="<c:url value="/"/>">
                                <i class="fa fa-home"></i> <span>首頁</span>
                            </a>
                        </li>
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-book"></i>
                                <span>使用說明</span>
                                <i class="fa fa-angle-left pull-right"></i>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="<c:url value="/tutorial/user"/>" ><i class="fa fa-angle-double-right"></i> 一般使用者</a></li>         
                                <li><a href="<c:url value="/tutorial/developer"/>" ><i class="fa fa-angle-double-right"></i> 程式開發者</a></li>                          
                            </ul>
                        </li>
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-user"></i>
                                <span>使用者管理</span>
                                <i class="fa fa-angle-left pull-right"></i>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="<c:url value="/user/app/list"/>"><i class="fa fa-angle-double-right"></i>已授權軟體管理</a></li>                               
                            </ul>
                        </li>
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-laptop"></i>
                                <span>開發者管理</span>
                                <i class="fa fa-angle-left pull-right"></i>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="<c:url value="/developer/app/list"/>"><i class="fa fa-angle-double-right"></i> App開發管理</a></li>
                                <li><a href="<c:url value="/developer/app/new"/>"><i class="fa fa-angle-double-right"></i> 註冊新App</a></li>                                 
                            </ul>
                        </li>
                    </ul>
                </section>
                <%-- /.sidebar --%>
            </aside>