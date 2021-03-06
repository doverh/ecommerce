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
<link href= "${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" media="all" />
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800'
	rel='stylesheet' type='text/css'>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
 

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
	<center><h3 class="m_10">${param.message}</h3></center>
	<div id="header"></div>
	<div class="clear"></div>
	<div class="index-banner">
		<div class="wmuSlider example1" style="height: 560px;">
			<div class="wmuSliderWrapper">
				<article style="position: relative; width: 100%; opacity: 1;">
					<div class="banner-wrap">
						<div class="slider-leparam.ft">
							<img src="images/banner1.jpg" alt="" />
						</div>
						<div class="slider-right">
							<h1>Classic</h1>
							<h2>Handbag</h2>
							<p>New Colection</p>
							<div class="btn">
								<a href="shop.html">Shop Now</a>
							</div>
						</div>
						<div class="clear"></div>
					</div>
				</article>
				<article style="position: absolute; width: 100%; opacity: 0;">
					<div class="banner-wrap">
						<div class="slider-left">
							<img src="images/banner2.jpg" alt="" />
						</div>
						<div class="slider-right">
							<h1>Classic</h1>
							<h2>Bags</h2>
							<p>New Colection</p>
							<div class="btn">
								<a href="shop.html">Shop Now</a>
							</div>
						</div>
						<div class="clear"></div>
					</div>
				<!-- </article>
				<article style="position: absolute; width: 100%; opacity: 0;">
					<div class="banner-wrap">
						<div class="slider-left">
							<img src="/LadyC/src/main/resources/images/banner1.jpg" alt="" />
						</div>
						<div class="slider-right">
							<h1>Classic</h1>
							<h2>Shoes</h2>
							<p>Confortable</p>
							<div class="btn">
								<a href="shop.html">Shop Now</a>
							</div>
						</div>
						<div class="clear"></div>
					</div>
				</article>
 -->			</div>
			<a class="wmuSliderPrev">Previous</a><a class="wmuSliderNext">Next</a>
			<ul class="wmuSliderPagination">
				<li><a href="#" class="">0</a></li>
				<li><a href="#" class="">1</a></li>
			</ul>
			<a class="wmuSliderPrev">Previous</a><a class="wmuSliderNext">Next</a>
			<ul class="wmuSliderPagination">
				<li><a href="#" class="wmuActive">0</a></li>
				<li><a href="#" class="">1</a></li>
			</ul>
		</div>
		<script src="${pageContext.request.contextPath}/js/jquery.wmuSlider.js"></script>
		<script type="text/javascript" src="js/modernizr.custom.min.js"></script>
		<script>
       						 $('.example1').wmuSlider();         
   						</script>
	</div>
	<div class="clear"></div>
	<div class="login">
		<div class="wrap">
			<div class="cont span_2_of_3">
				<div class="mens-toolbar">
				<div class="box1">
					<div class="clear"></div>
					<c:forEach items="${products}" var="products">
						<div class="col_1_of_single1 span_1_of_single1">
							<a href="single.html"> </a>
								<div class="view1 view-fifth1">
									<div class="top_box">
										<h3 class="m_1">${products.getProduct_name()}</h3>
										<p class="m_2">${products.getCode()}</p>
										<div class="grid_img">
											<div class="css3">
												<img src="${pageContext.request.contextPath}/${products.getImage()}" />
											</div>
											<!-- 
											<div class="mask1">
												<div class="info">Quick View</div>
											</div> -->
										</div>
										<div class="price">$ ${products.getPrice()}</div>
									</div>
									</div>
									


									<span class="rating1"> <input type="radio"
										class="rating-input" id="rating-input-1-5"
										name="rating-input-1"> <label for="rating-input-1-5"
										class="rating-star1"></label> <input type="radio"
										class="rating-input" id="rating-input-1-4"
										name="rating-input-1"> <label for="rating-input-1-4"
										class="rating-star1"></label> <input type="radio"
										class="rating-input" id="rating-input-1-3"
										name="rating-input-1"> <label for="rating-input-1-3"
										class="rating-star1"></label> <input type="radio"
										class="rating-input" id="rating-input-1-2"
										name="rating-input-1"> <label for="rating-input-1-2"
										class="rating-star"></label> <input type="radio"
										class="rating-input" id="rating-input-1-1"
										name="rating-input-1"> <label for="rating-input-1-1"
										class="rating-star"></label>&nbsp; (45)
									</span>
									<div>	
									
										<form method="POST" action="cart.do">
											<input type="hidden" name="product_id"
												value="${products.getProduct_id()}" /> <input type="hidden"
												name="product_code" value="${products.getCode()}" /> <input
												type="hidden" name="product_price"
												value="${products.getPrice()}" /> <input type="hidden"
												name="product_quantity" value="1" /> <input type="hidden"
												name="product_name" value="${products.getProduct_name()}" />
											<input type="hidden" name="action" value="add" />
											<button type="submit" class="btn btn-danger">BUY</button>
										</form>
									</div>
									
								</div>
											</c:forEach>
						</div>
				
				</div>
			
				<div class="clear"></div>


	<div id="footer"></div>
</body>
</html>
