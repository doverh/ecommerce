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
<script type="text/javascript">
        $(document).ready(function() {
            $(".dropdown img.flag").addClass("flagvisibility");

            $(".dropdown dt a").click(function() {
                $(".dropdown dd ul").toggle();
            });
                        
            $(".dropdown dd ul li a").click(function() {
                var text = $(this).html();
                $(".dropdown dt a span").html(text);
                $(".dropdown dd ul").hide();
                $("#result").html("Selected value is: " + getSelectedValue("sample"));
            });
                        
            function getSelectedValue(id) {
                return $("#" + id).find("dt a span.value").html();
            }

            $(document).bind('click', function(e) {
                var $clicked = $(e.target);
                if (! $clicked.parents().hasClass("dropdown"))
                    $(".dropdown dd ul").hide();
            });


            $("#flagSwitcher").click(function() {
                $(".dropdown img.flag").toggleClass("flagvisibility");
            });
        });
     </script>
<link href="../css/megamenu.css" rel="stylesheet" type="text/css"
	media="all" />
<script type="text/javascript" src="../js/megamenu.js"></script>
<script>$(document).ready(function(){$(".megamenu").megamenu();});</script>
<!-- end menu -->
<!-- top scrolling -->
<script type="text/javascript" src="../js/move-top.js"></script>
<script type="text/javascript" src="../js/easing.js"></script>
<script type="text/javascript">
		jQuery(document).ready(function($) {
			$(".scroll").click(function(event){		
				event.preventDefault();
				$('html,body').animate({scrollTop:$(this.hash).offset().top},1200);
			});
		});
	</script>

<script src="../js/jquery-3.2.1.js"></script>


<script> 
jQuery(document).ready(function($){
  $("#header").load("header.html"); 
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
						<form action="LoginController" method="POST">
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