<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<body>
	<div class="header-top">
		<div class="wrap">
			<div class="logo">
				<a href="index.html"><img src="../images/logo.png" alt="" /></a>
			</div>


			<!----------------------------BEGINNING OF MENU-------------------------------->

			<div class="cssmenu">
				<ul>
					<li class="active"><a href="register.jsp">Sign up & Save</a></li>
					<li><a href="shop.html">Store Locator</a></li>
					<li><a href="login.jsp">My Account</a></li>
					<li>  
  		
      <li><a href="#" id="cart"><i class="fa fa-shopping-cart"></i> Cart <span class="badge">3</span></a></li>
   
  </div> <!--end container -->


<div class="container">
  <div class="shopping-cart">
    <div class="shopping-cart-header">
      <i class="fa fa-shopping-cart cart-icon"></i><span class="badge">3</span>
      <div class="shopping-cart-total">
        <span class="lighter-text">Total:</span>
        <span class="main-color-text">$2,229.97</span>
      </div>
    </div> <!--end shopping-cart-header -->

    <ul class="shopping-cart-items">
      <li class="clearfix">
        <img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/195612/cart-item1.jpg" alt="item1" />
        <span class="item-name">Sony DSC-RX100M III</span>
        <span class="item-price">$849.99</span>
        <span class="item-quantity">Quantity: 01</span>
      </li>

      <li class="clearfix">
        <img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/195612/cart-item2.jpg" alt="item1" />
        <span class="item-name">KS Automatic Mechanic...</span>
        <span class="item-price">$1,249.99</span>
        <span class="item-quantity">Quantity: 01</span>
      </li>

      <li class="clearfix">
        <img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/195612/cart-item3.jpg" alt="item1" />
        <span class="item-name">Kindle, 6" Glare-Free To...</span>
        <span class="item-price">$129.99</span>
        <span class="item-quantity">Quantity: 01</span>
      </li>
    </ul>

    <a href="#" class="button">Checkout</a>
  </div> <!--end shopping-cart -->
</div> <!--end container -->
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

    <script src="../js/index.js"></script></li>
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
								<!-- <div class="h_nav">
								<h4 class="top">men</h4>
								<ul>
									<li><a href="shop.html">new arrivals</a></li>
									<li><a href="shop.html">men</a></li>
									<li><a href="shop.html">women</a></li>
									<li><a href="shop.html">accessories</a></li>
									<li><a href="shop.html">kids</a></li>
									<li><a href="shop.html">style videos</a></li>
								</ul>	
							</div> -->
								<!-- </div>
						<div class="col1">
							<div class="h_nav">
								<h4>style zone</h4>
								<ul>
									<li><a href="shop.html">men</a></li>
									<li><a href="shop.html">women</a></li>
									<li><a href="shop.html">accessories</a></li>
									<li><a href="shop.html">kids</a></li>
									<li><a href="shop.html">brands</a></li>
								</ul>	
							</div> -->
							</div>
							<div class="col1"></div>
							<div class="col1"></div>
							<div class="col1"></div>
							<div class="col1"></div>
							<img src="images/nav_img.jpg" alt="" />
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
									<img src="images/nav_img1.jpg" alt="" />
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
							<img src="images/nav_img2.jpg" alt="" />
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
								<img src="images/nav_img3.jpg" alt="" />
							</div>
						</div>
					</div></li>
				<li><a class="color5" href="#">Sales</a></li>


			</ul>
</body>
</html>