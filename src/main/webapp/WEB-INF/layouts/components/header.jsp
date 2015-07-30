<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

    <head>
        <meta charset="UTF-8">
        <title>NCU OAuth | 國立中央大學</title>
        <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
        <link href="<c:url value='/resources/css/bootstrap.min.css'/>" rel="stylesheet" type="text/css" />
        <link href="<c:url value='/resources/css/font-awesome.min.css'/>" rel="stylesheet" type="text/css" />
        <%-- Ionicons --%>
        <link href="<c:url value='/resources/css/ionicons.min.css'/>" rel="stylesheet" type="text/css" />
        <%-- Theme style --%>
        <link href="<c:url value='/resources/css/AdminLTE.css'/>" rel="stylesheet" type="text/css" /> 
        <link rel="shortcut icon" href="<c:url value='/resources/favicon.ico'/>" type="image/x-icon" />
        <%-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries --%>
        <%-- WARNING: Respond.js doesn't work if you view the page via file:// --%>
        <%--[if lt IE 9]>
          <script src="<c:url value='/js/html5shiv.js'/>"></script>
          <script src="<c:url value='js/respond.min.js'/>"></script>
        <![endif]--%>
    </head>
    <body class="skin-blue">
        <%-- header logo: style can be found in header.less --%>
        <header class="header">
            <a href="/manage" class="logo">
                <%-- Add the class icon to your logo image or logo icon to add the margining --%>
                NCU OAuth
            </a>
            <%-- Header Navbar: style can be found in header.less --%>
            <nav class="navbar navbar-static-top" role="navigation">
                <%-- Sidebar toggle button--%>
                <a href="#" class="navbar-btn sidebar-toggle" data-toggle="offcanvas" role="button">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </a>
                <div class="navbar-right">
                    <ul class="nav navbar-nav">
                        
                        
                        <%-- User Account: style can be found in dropdown.less --%>
                        <li class="dropdown user user-menu">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="glyphicon glyphicon-user"></i>
                                <span>${session.personInfo.getAccount()} <i class="caret"></i></span>
                            </a>
                            <ul class="dropdown-menu">
                                <%-- User image --%>
                                <li class="user-header bg-light-blue">
                                    <img src="<c:url value='/resources/img/avatar3.png'/>" class="img-circle" alt="User Image" />
                                    <p>歡迎來到中央大學<small>National Central University</small></p>
                                </li>
                                <%-- Menu Body --%>
                                
                                <%-- Menu Footer--%>
                                <li class="user-footer">
                                    <div class="pull-right">
                              
                                    
                                        <a href="<c:url value='/logout'/>" class="btn btn-default btn-flat">登出</a>
                                    </div>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>
    </body>