<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Lady C</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"
	media="all" />
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">


<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.js"></script>


<script> 
jQuery(document).ready(function($){
  $("#header").load("${pageContext.request.contextPath}/views/header.jsp"); 
  /* $("#footer").load("footer.html"); 
 */});
jQuery(document).ready(function($){
	  $("#footer").load("${pageContext.request.contextPath}/views/footer.jsp"); 
	 });
</script>
</head>

<body>
	<%-- <% //allow access only if session exists
Object cart = null;
if(session.getAttribute("cart") == null){
	response.sendRedirect("index.html");
}else cart =  session.getAttribute("cart");
%> --%>
	<div id="header"></div>
	<div class="login">
		<div class="container">
		<div>
						<center><h4 class="m_10">${currentSessionUser}<br> ${message}</h4></center>
					</div>
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
										<form action="*.do">
											<button type="SUBMIT"
												class="btn btn-primary btn-sm btn-block">
												<span class="glyphicon glyphicon-share-alt"></span> Continue
												shopping
											</button>
										</form>
									</div>
								</div>
							</div>
						</div>
						<div class="panel-body">
							<c:forEach items="${products}" var="prod">
								<div class="row">
									<div class="col-xs-2">
										<img class="img-responsive" src="http://placehold.it/100x70">
									</div>
									<div class="col-xs-4">
										<h4 class="product-name">
											<strong>${prod.getProduct_name()}</strong>
										</h4>
										<h4>
											<small>${prod.getCode()}</small>
										</h4>
									</div>
									<div class="col-xs-6">
										<div class="col-xs-6 text-right">
											<h6>
												<strong>${prod.getPrice()}<span class="text-muted"></span></strong>
											</h6>
										</div>
										<form method="POST" action="cart.do">
											<input type="hidden" name="productId"
												value="${prod.getProduct_id()}" />
											<div class="col-xs-4">
												<input type="text" name="quantity"
													class="form-control input-sm" value="${prod.getQuantity()}">
											</div>
											<button type="submit" class="btn btn-link btn-xs"
												name="action" value="update">
												<span class="glyphicon glyphicon-pencil"> </span>
											</button>
										</form>
										<div class="col-xs-2">
											<form method="POST" action="cart.do">
												<input type="hidden" name="productId"
													value="${prod.getProduct_id()}" />
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

						</div>
						<div class="panel-footer">
							<div class="row text-center">
								<div class="col-xs-9">
									<h4 class="text-right">
										Total <strong>$${total}</strong>
									</h4>
								</div>
								<div class="col-xs-3">
									<form method="POST" action="checkout.do">
										<%-- <input type="hidden" name="orderTotal" value="${total}" />
										 --%>
										<input type="hidden" name="action" value="checkout" />
										<button type="submit" class="btn btn-success btn-block">
											Checkout</button>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div id="footer"></div>
</body>
</html>