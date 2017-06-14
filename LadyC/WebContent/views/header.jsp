<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>

<head>
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
</head>
<body>
	<script type="text/javascript">
		function sendLogout() {
			document.forms["checkoutForm"].submit();
		}
		function sendMyAccount() {
			document.forms["myAccountForm"].submit();
		}
	</script>
	<div class="header-top">
		<div class="wrap">

			<div class="logo">
				<a href="<c:url value="/views/index"/>"><img src="../images/logo.png" alt="" /></a>
			</div>

			<script type="text/javascript">
				$(document)
						.ready(
								function() {
									$(".dropdown img.flag").addClass(
											"flagvisibility");

									$(".dropdown dt a").click(function() {
										$(".dropdown dd ul").toggle();
									});

									$(".dropdown dd ul li a")
											.click(
													function() {
														var text = $(this)
																.html();
														$(".dropdown dt a span")
																.html(text);
														$(".dropdown dd ul")
																.hide();
														$("#result")
																.html(
																		"Selected value is: "
																				+ getSelectedValue("sample"));
													});

									function getSelectedValue(id) {
										return $("#" + id).find(
												"dt a span.value").html();
									}

									$(document)
											.bind(
													'click',
													function(e) {
														var $clicked = $(e.target);
														if (!$clicked
																.parents()
																.hasClass(
																		"dropdown"))
															$(".dropdown dd ul")
																	.hide();
													});

									$("#flagSwitcher")
											.click(
													function() {
														$(".dropdown img.flag")
																.toggleClass(
																		"flagvisibility");
													});
								});
			</script>
			<link href="../css/megamenu.css" rel="stylesheet" type="text/css"
				media="all" />
			<script type="text/javascript" src="../js/megamenu.js"></script>
			<script>
				$(document).ready(function() {
					$(".megamenu").megamenu();
				});
			</script>
			<!-- end menu -->
			<!-- top scrolling -->
			<script type="text/javascript" src="../js/move-top.js"></script>
			<script type="text/javascript" src="../js/easing.js"></script>
			<script type="text/javascript">
				jQuery(document).ready(function($) {
					$(".scroll").click(function(event) {
						event.preventDefault();
						$('html,body').animate({
							scrollTop : $(this.hash).offset().top
						}, 1200);
					});
				});
			</script>


			<!----------------------------BEGINNING OF MENU-------------------------------->

			<div class="cssmenu">
				<ul>
					<li class="active"><a href="register.jsp">Sign up</a></li>
					<li><form id="myAccountForm" method="POST"
							action="MyAccountController">
							<a href="javascript:sendMyAccount()">My Account</a>
						</form></li>
					<li><a href="shop.html"></a></li>
					<li><a href="login.jsp">Login</a></li>
					<li><form id="checkoutForm" method="POST"
							action="LogoutController">
							<a href="javascript:sendLogout()">Logout</a>
						</form></li>
					<li><form method="POST" action="CartController">
							<button type="submit">
								<span class="glyphicon glyphicon-shopping-cart">CART</span>
							</button>
						</form></li>
				</ul>
			</div>
			<!-- <ul class="icon2 sub-icon2 profile_img">
			<li><a class="active-icon c2" href="#"> </a>
				<ul class="sub-icon2 list">
					<li><h3>Products</h3><a href=""></a></li>
					<li><p>Lorem ipsum dolor sit amet, consectetuer  <a href="">adipiscing elit, sed diam</a></p></li>
				</ul>
			</li>
		</ul> -->
			<div class="clear"></div>
			<div class="clear"></div>
			<form class="search-wrapper cf" action="ProductController"
				method="POST">
				<input type="text" placeholder="Search here..." name="search">
				<button type="submit">Search</button>
			</form>
		</div>
	</div>
	</br>
	<div class="header-bottom">
		<div class="wrap">
			<!-- start header menu -->
			<ul class="megamenu skyblue">
				<li><a class="color1" href="#">Home</a></li>
				<li class="grid"><a class="color2" href="#">Bags</a>
					<div class="megapanel">
						<div class="row">
							<div class="col1">
								<div class="h_nav">
									<h4>Styles</h4>
									<ul>
										<li><a href="backpack.html">Backpack</a></li>
										<li><a href="bucket.html">Bucket</a></li>
										<li><a href="clutch.html">Clutch</a></li>
										<li><a href="handbag.html">Handbag</a></li>
										<li><a href="envelope.html">Envelope</a></li>
									</ul>
								</div>
							</div>
							<div class="col1"></div>
							<div class="col1"></div>
							<div class="col1"></div>
							<div class="col1"></div>
							<img src="../images/nav_img.jpg" alt="" />
						</div>
					</div></li>
				<li class="active grid"><a class="color4" href="#">Boots</a>
					<div class="megapanel">
						<div class="row">
							<div class="col1">
								<div class="h_nav">
									<h4>shop</h4>
									<ul>
										<li><a href="shop.html">new arrivals</a></li>
									</ul>
								</div>
							</div>
							<div class="col1">
								<div class="h_nav">
									<img src="../images/nav_img1.jpg" alt="" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col2"></div>
							<div class="col1"></div>
							<div class="col1"></div>
							<div class="col1"></div>
							<div class="col1"></div>
						</div>
					</div></li>
				<li><a class="color5" href="#">Flats</a>
					<div class="megapanel">
						<div class="row">
							<div class="col1">
								<div class="h_nav">
									<h4>Shop</h4>
									<ul>
										<li><a href="shop.html">new arrivals</a></li>

									</ul>
								</div>
							</div>

							<div class="col1"></div>
							<div class="col1"></div>
							<div class="col1"></div>
							<div class="col1"></div>
							<img src="../images/nav_img2.jpg" alt="" />
						</div>
					</div>
				<li><a class="color5" href="#">Oxfords</a>
					<div class="megapanel">
						<div class="row">
							<div class="col1">
								<div class="h_nav">
									<h4>Shop</h4>
									<ul>
										<li><a href="shop.html">new arrivals</a></li>

									</ul>
								</div>
								<img src="../images/nav_img3.jpg" alt="" />
							</div>
						</div>
					</div></li>
				<li><a class="color5" href="#">Sales</a></li>


			</ul>
</body>
</html>