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
	<div id="header"></div>
	<div class="clear"></div>
	<div class="login">
		<div class="wrap">
			<div class="cont span_2_of_3">
				<div class="mens-toolbar">
					<div class="sort">
						<div class="sort-by">
							<label>Sort By</label> <select>
								<option value="">Popularity</option>
								<option value="">Price : High to Low</option>
								<option value="">Price : Low to High</option>
							</select> <a href=""><img src="${pageContext.request.contextPath}/images/arrow2.gif" alt=""
								class="v-middle"></a>
						</div>
					</div>
					<div class="pager">
						<div class="limiter visible-desktop">
							<label>Show</label> <select>
								<option value="" selected="selected">9</option>
								<option value="">15</option>
								<option value="">30</option>
							</select> per page
						</div>
						<ul class="dc_pagination dc_paginationA dc_paginationA06">
							<li><a href="#" class="previous">Pages</a></li>
							<li><a href="#">1</a></li>
							<li><a href="#">2</a></li>
						</ul>
						<div class="clear"></div>
					</div>
					<div class="clear"></div>
				</div>
				<div class="box1">
					<div class="clear"></div>
					<div>
						<center><h3 class="m_10">${param.currentSessionUser}<br> ${param.message}</h4></center>
					</div>
					<div class="clear"></div>
					<c:forEach items="${products}" var="products">
						<div class="col_1_of_single1 span_1_of_single1">
							<a href="single.html">
								<div class="view1 view-fifth1">
									<div class="top_box">
										<h3 class="m_1">${products.getProduct_name()}</h3>
										<p class="m_2">${products.getCode()}</p>
										<div class="grid_img">
											<div class="css3">
												<img src="../${products.getImage()}" />
											</div>
											<!-- 
											<div class="mask1">
												<div class="info">Quick View</div>
											</div> -->
										</div>
										<div class="price">$ ${products.getPrice()}</div>

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
									<ul class="list2">

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
									</ul>
								</div>
						</div>
							</c:forEach>
				</div>
			
				<div class="clear"></div>




				<script type="text/javascript">
					$(document).ready(function() {

						var defaults = {
							containerID : 'toTop', // fading element id
							containerHoverID : 'toTopHover', // fading element hover id
							scrollSpeed : 1200,
							easingType : 'linear'
						};

						$().UItoTop({
							easingType : 'easeOutQuart'
						});

					});
				</script>
				<a href="#" id="toTop" style="display: block;"><span
					id="toTopHover" style="opacity: 1;"></span></a>
				<div id="footer"></div>
</body>
</html>