<!DOCTYPE HTML>
<html>
<head>
<title>Lady C</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../css/style.css" rel="stylesheet" type="text/css" media="all" />
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800'
	rel='stylesheet' type='text/css'>
<!-- <script type="text/javascript" src="../js/jquery.min.js"></script>
 -->
<script src="../js/jquery-3.2.1.js"></script>


<script> 
jQuery(document).ready(function($){
  $("#header").load("header.jsp"); 
  /* $("#footer").load("footer.html"); 
 */});
jQuery(document).ready(function($){
	  $("#footer").load("footer.html"); 
	 });
</script>
</head>
<body>
	<div id="header"></div>


	<div class="login">
		<div class="wrap">
			<div class="col_1_of_login span_1_of_login">
				<h4 class="title">New Customers</h4>
				<h5 class="sub_title">Register Account</h5>
				<p>Register here and experience one of our products.</p>
				<div class="button1">
					<a href="register.jsp"><input type="submit" name="Submit"
						value="Continue"></a>
				</div>
				<div class="clear"></div>
			</div>
			<div class="col_1_of_login span_1_of_login">
				<div class="login-title">
					<h4 class="title">Registered Customers</h4>
					<div class="comments-area">
						<form action="login.do" method="POST">
							<p>
								<label>Username</label> <span>*</span> <input type="text"
									name="username" value="">
							</p>
							<p>
								<label>Password</label> <span>*</span> <input type="password"
									name="pwd" value="">
							</p>
							<p>${param.message}</p>
							<p id="login-form-remember">
								<label><a href="#">Forget Your Password ? </a></label>
							</p>
							<p>
							  <input type="hidden" name="action" value="login"/>
   								<input type="submit" value="Login">
							</p>
						</form>
					</div>
				</div>
			</div>
			<div class="clear"></div>
		</div>
	</div>

	<div id="footer"></div>
</body>
</html>