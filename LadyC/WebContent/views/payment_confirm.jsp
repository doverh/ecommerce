<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Lady C</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../css/style.css" rel="stylesheet" type="text/css"
	media="all" />
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800'
	rel='stylesheet' type='text/css'>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link href="../css/style.css" rel="stylesheet" type="text/css"
	media="all" />
</head>

<script src="../js/jquery-3.2.1.js"></script>


<script>
	jQuery(document).ready(function($) {
		$("#header").load("header.jsp");
		/* $("#footer").load("footer.html"); 
		 */});
	jQuery(document).ready(function($) {
		$("#footer").load("footer.html");
	});
</script>
</head>
<body>
	<div id="header"></div>
	<div class="clear"></div>

	<div class="login">
		<div>
						<center><h3 class="m_10">Your order #${orderNum}<br> with total $ ${total} has been approved!</h4></center>
					</div>
					
					<div class="clear"></div>
					<div class="clear"></div>
	<div id="footer"></div>
</body>
</html>