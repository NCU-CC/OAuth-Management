
<!DOCTYPE html>
<%--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]--%>
<%--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]--%>
<%--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]--%>
<%--[if gt IE 8]><%--%> <html class="no-js"> <%--<![endif]--%>
    <head>

    <title>NCU OAuth</title>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta name="description" content="">
	<meta name="author" content="" />
	
	

	<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,800italic,400,600,800" type="text/css">
	<link rel="stylesheet" href="./css/font-awesome.min.css" type="text/css" />		
	<link rel="stylesheet" href="./css/bootstrap.min.css" type="text/css" />	
	<link rel="stylesheet" href="./js/libs/css/ui-lightness/jquery-ui-1.9.2.custom.css" type="text/css" />	
	
	<link rel="stylesheet" href="./css/App.css" type="text/css" />
	<link rel="stylesheet" href="./css/Login.css" type="text/css" />

	<link rel="stylesheet" href="./css/custom.css" type="text/css" />
	<style type="text/css">
a:link {
    text-decoration: none;
}

a:visited {
    text-decoration: none;
}

a:hover {
    text-decoration: none;
}

a:active {
    text-decoration: none;
}
  </style>
</head>

<body>

<div id="login-container">

	<div id="logo">
		<a href="./login.html">
			<img src="./img/logos/logo-login.png" alt="Logo" />
		</a>
	</div>

	<div id="login">

		<h3>Welcome to NCU OAuth</h3>
			<div class="form-group">

			<a href="${loginUrl}">
				<button  id="login-btn"  class="btn btn-primary btn-block">登入<i class="fa fa-play-circle"></i></button>
				</a>
			</div>
		<a href="http://www.cc.ncu.edu.tw/net/password.php" class="btn btn-default">忘記密碼?</a>
	</div> <%-- /#login --%>
</div> <%-- /#login-container --%>


</body>
</html>