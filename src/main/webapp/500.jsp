        <%@ page language="java" contentType="text/html; charset=UTF-8" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
    <title>NCU - Oauth Management</title>
    <meta name="description" content="Srikandi Responsive Admin Templates" />
    <meta name="keywords" content="resposinve, admin dashboard, admin page, admin template" />
    <meta name="author" content="Candra Dwi Waskito" />
    <link rel="shortcut icon" href="<c:url value='/favicon.ico'/>">
    <link rel="stylesheet" href="<c:url value='/css/font-awesome.min.css'/>" />
    <link rel="stylesheet" href="<c:url value='/css/bootstrap.min.css'/>">
    <link rel="stylesheet" href="<c:url value='/css/bootstrap-reset.css'/>">
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>">
</head>
<body id="wrapper-500">

    <!-- start:wrapper -->
    <div class="container">
        <div class="errorpage">
            <i class="fa fa-flash fa-4x"></i>
            <h1>Ouch!</h1>
            <p>500 Page Error</p>
            <h5>Looks like Something went wrong. <a href="/manage" class="btn btn-sm btn-danger">Return Home</a></h5>
        </div>
    </div>
    <!-- end:wrapper -->

    <!-- start:javascript -->
    <!-- javascript default for all pages-->
    <script src="<c:url value='/js/jquery-1.11.1.min.js'/>"></script>
    <script src="<c:url value='/js/bootstrap.min.js'/>"></script>

    <!-- javascript for Srikandi admin -->
    <script src="<c:url value='/js/themes.js'/>"></script>
    <!-- end:javascript -->

</body>
</html> 