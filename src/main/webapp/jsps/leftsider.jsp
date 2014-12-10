<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="struts" %>
<aside class="left-side sidebar-offcanvas">
                <%-- sidebar: style can be found in sidebar.less --%>
                <section class="sidebar">
                    <%-- Sidebar user panel --%>
                    <div class="user-panel">
                        <div class="pull-left image">
                            <img src="<c:url value='/img/avatar3.png'/>" class="img-circle" alt="User Image" />
                        </div>
                        <div class="pull-left info">
                            <p>Hello, ${session.personInfo.getAccount()}</p>

                            <a><i class="fa fa-circle text-success"></i> Online</a>
                        </div>
                    </div>
                    <%-- search form --%>
                    
                    <%-- /.search form --%>
                    <%-- sidebar menu: : style can be found in sidebar.less --%>
                    <ul class="sidebar-menu">
                        <li>
                            <a href="<struts:url namespace="/" action=''/>">
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
                                <li><a href="<struts:url namespace="/tutorial" action='user'/>"><i class="fa fa-angle-double-right"></i> 一般使用者</a></li>         
                                <li><a href="<struts:url namespace="/tutorial" action='dev'/>"><i class="fa fa-angle-double-right"></i> 程式開發者</a></li>                          
                            </ul>
                        </li>
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-user"></i>
                                <span>使用者軟體管理</span>
                                <i class="fa fa-angle-left pull-right"></i>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="<struts:url namespace="/user" action='list'/>"><i class="fa fa-angle-double-right"></i> 已授權軟體管理</a></li>                               
                            </ul>
                        </li>
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-laptop"></i>
                                <span>開發人員軟體管理</span>
                                <i class="fa fa-angle-left pull-right"></i>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="<struts:url namespace="/dev" action='list'/>"><i class="fa fa-angle-double-right"></i> APP開發管理</a></li>
                                <li><a href="<struts:url namespace="/dev" action='new'/>"><i class="fa fa-angle-double-right"></i> 註冊新APP</a></li>      
                                <li><a href="<struts:url namespace="/dev" action='api'/>"><i class="fa fa-angle-double-right"></i> 已開放API列表</a></li>                              
                            </ul>
                        </li>
                        <li>
                            <a href="<struts:url namespace="/" action='terms'/>">
                                <i class="fa fa-file-text-o"></i> <span>服務條款</span> 
                            </a>
                        </li>
                        <li>
                            <a href="<struts:url namespace="/" action='about'/>">
                                <i class="fa fa-group"></i> <span>關於我們</span> 
                            </a>
                        </li>
                    </ul>
                </section>
                <%-- /.sidebar --%>
            </aside>