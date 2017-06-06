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

<script type="text/javascript">
	$(document).ready(
			function() {
				$(".dropdown img.flag").addClass("flagvisibility");

				$(".dropdown dt a").click(function() {
					$(".dropdown dd ul").toggle();
				});

				$(".dropdown dd ul li a").click(
						function() {
							var text = $(this).html();
							$(".dropdown dt a span").html(text);
							$(".dropdown dd ul").hide();
							$("#result").html(
									"Selected value is: "
											+ getSelectedValue("sample"));
						});

				function getSelectedValue(id) {
					return $("#" + id).find("dt a span.value").html();
				}

				$(document).bind('click', function(e) {
					var $clicked = $(e.target);
					if (!$clicked.parents().hasClass("dropdown"))
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

<script src="../js/jquery-3.2.1.js"></script>


<script>
	jQuery(document).ready(function($) {
		$("#header").load("header.html");
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
		<h4 class="title">Payment total is ${param.orderTotal}</h4>
		<div class="container">
			<div class="row">
				<div class="col-xs-8">
					<div class="panel-body">
						<c:forEach items="${cart.getCartItems()}" var="item">
							<div class="row">
								<div class="col-xs-2">
									<img class="img-responsive" src="http://placehold.it/100x70">${item.getImage()}
								</div>
								<div class="col-xs-4">
									<h4 class="product-name">
										<strong>${item.getItem_name()}</strong>
									</h4>
									<h4>
										<small>${item.getCode()}</small>
									</h4>
								</div>
								<div class="col-xs-6">
									<div class="col-xs-6 text-right">
										<h6>
											<strong>$${item.getPrice()}<span class="text-muted"></span></strong>
										</h6>
									</div>
									<form method="POST" action="CartController">
										<div class="col-xs-4">
											<input type="text" class="form-control input-sm"
												name="quantity" value="${item.getQuantity()}">
										</div>
										<div class="col-xs-1">
											<input type="hidden" name="itemId"
												value="${item.getItem_id()}" />
											<button type="submit" class="btn btn-link btn-xs"
												name="action" value="update">
												<span class="glyphicon glyphicon-pencil"> </span>
											</button>
										</div>
									</form>
									<div class="col-xs-2">
										<form method="POST" action="CartController">
											<input type="hidden" name="itemId"
												value="${item.getItem_id()}" />
											<button type="submit" class="btn btn-link btn-xs"
												name="action" value="delete">
												<span class="glyphicon glyphicon-trash"> </span>
											</button>
										</form>
									</div>


								</div>
							</div>
						</c:forEach>
						<hr>
						<div class="panel-footer">
							<div class="row text-center">
								<div class="col-xs-9">
									<h4 class="text-right">
										Total <strong>$${cart.getOrderTotal()}</strong>
									</h4>
								</div>
								<div class="col-xs-3">
									<button type="button" class="btn btn-success btn-block">
										Checkout</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div> --%>

</div>
		<%-- 
	
	
			<ul>
					<li class="row list-inline columnCaptions">
						<span>QTY</span>
						<span>ITEM</span>
						<span>Price</span>
					</li>
								<c:forEach items="${cart.getCartItems()}" var="item">
								<li class="row"><span class="quantity">${item.getQuantity()}</span>
									<span class="itemName">${item.getItem_name()}</span> <span
									class="popbtn"><a class="arrow"></a></span> <span class="price">$${item.getPrice()}</span></li>

								<!-- The popover content -->
								<div id="popover" style="display: none">
									<form method="POST" action="CartController">
										<span class="glyphicon glyphicon-pencil">
										<input type="hidden" name="itemId" value="${item.getItem_id()}"/>
										<input type="submit" name="action" value="X"></span></a>
									</form>

								</div>


							</c:forEach>
							<li class="row totals">	<span class="itemName">Total:</span>
								<span class="price">$${cart.getOrderTotal()}</span> <span
								class="order"> <a class="text-center">ORDER</a></span></li>
						</ul>
					</div>

	

				<!-- JavaScript includes -->

				<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
				<script src="../js/bootstrap.min.js"></script>
				<script src="../js/customjs.js"></script>
				</p>
 --%>
		<div id="footer"></div>
</body>
</html>