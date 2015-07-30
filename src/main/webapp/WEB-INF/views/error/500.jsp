        <%@ page language="java" contentType="text/html; charset=UTF-8" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
    <title>NCU - OAuth Management</title>
    <meta name="description" content="Srikandi Responsive Admin Templates" />
    <meta name="keywords" content="resposinve, admin dashboard, admin page, admin template" />
    <meta name="author" content="Candra Dwi Waskito" />
    <link rel="shortcut icon" href="<c:url value='/resources/favicon.ico'/>">
    <link rel="stylesheet" href="<c:url value='/resources/css/font-awesome.min.css'/>" />
    <link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.min.css'/>">
    <link rel="stylesheet" href="<c:url value='/resources/css/bootstrap-reset.css'/>">
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>">
</head>
<body id="wrapper-500">
    <div class="container">
        <div class="errorpage">
            <i class="fa fa-flash fa-4x"></i>
            <h1>Ouch!</h1>
            <p>500 Page Error</p>
            <h5>Looks like Something went wrong. <a href="<c:url value='/' />" class="btn btn-sm btn-danger">回到首頁</a></h5>
        </div>
    </div>
    <script src="<c:url value='/resources/js/jquery-1.11.1.min.js'/>"></script>
    <script src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>

    <script src="<c:url value='/resources/js/themes.js'/>"></script>
</body>
</html> 