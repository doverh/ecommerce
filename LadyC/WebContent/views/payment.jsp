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
		$("#header").load("header.jsṕ");
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
			<center>
				<h3 class="m_10">${currentSessionUser}<br> Review your
					order!
					</h4>
			</center>
		</div>
	</div>


	<div class="container">
		<div class="row">
			<div class="col-xs-8">
				<div class="panel panel-info">
					<div class="panel-heading">
						<div class="panel-title">
							<div class="row">
								<div class="col-xs-6">
									<h5>
										<span class="glyphicon glyphicon-shopping-cart"></span>
										Shopping Cart
									</h5>
								</div>
								<div class="col-xs-6">
									<form action="index">
										<button type="SUBMIT" class="btn btn-primary btn-sm btn-block">
											<span class="glyphicon glyphicon-share-alt"></span> Continue
											shopping
										</button>
									</form>
								</div>
							</div>
						</div>
					</div>
					<div class="panel-body">
					<form method="POST" action="OrderController">	
						<input type="hidden" name="user_id" value="${user_id}" />
						<input type="hidden" name="order_total" value="${cart.getOrderTotal()}" />
						<% String listProducts = request.getParameter("products"); 
						request.setAttribute("productList",listProducts);%>
						<c:forEach items="${products}" var="products">
							<div class="row">
								<div class="col-xs-2">
									<img class="img-responsive" src="http://placehold.it/100x70">${item.getImage()}
								</div>
								<div class="col-xs-4">
									<h4 class="product-name">
										<strong>${products.getProduct_name()}</strong>
									</h4>
									<h4>
										<small>${products.getCode()}</small>
									</h4>
								</div>
								<div class="col-xs-6">
									<div class="col-xs-6 text-right">
										<h6>
											<strong>$${products.getPrice()}<span class="text-muted"></span></strong>
										</h6>
									</div>
									<%-- 	<%-- <form method="POST" action="CartController"> --%>
									<div class="col-xs-4">
										<input type="text" class="form-control input-sm"
											name="quantity" value="${products.getQuantity()}">
									</div>
									<%-- 	<div class="col-xs-1">
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
									</div>--%>

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
									<button type="submit" class="btn btn-danger">PAY NOW</button>
								</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

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