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
            <h3>未通過驗證！</h3>
            <h3>未登入、登入不正確或無登入的權限（在校生、教職員工和校友）。 <a href="<c:url value='/' />" class="btn btn-sm btn-danger">回到首頁</a></h3>
        </div>
    </div>
    <script src="<c:url value='/resources/js/jquery-1.11.1.min.js'/>"></script>
    <script src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>

    <script src="<c:url value='/resources/js/themes.js'/>"></script>
</body>
</html> 