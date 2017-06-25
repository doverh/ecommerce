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
	<%-- <% //allow access only if session exists
Object cart = null;
if(session.getAttribute("cart") == null){
	response.sendRedirect("index.html");
}else cart =  session.getAttribute("cart");
%> --%>
	<div id="header"></div>
	<div class="login">
		<div class="container">
			<div class="row">
				<div class="col-xs-8">
					<div class="panel panel-info">
						<div class="panel-heading">
							<div class="panel-title">
								<div class="row">
									<div class="col-xs-6">
										<h5>
											<span class="glyphicon glyphicon-shopping-cart"></span> My
											Account
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
							<table align="center">
								<tr>
									<th>ORDER#</th>
									<th>DATE</th>
									<th>CODE</th>
									<th>PRODUCT</th>
									<th>QTY</th>
									<th>PRICE</th>
								</tr>
								<c:forEach items="${orders}" var="ord">
									<tr>
										<td><h4>
												<small><c:out value="${ord[0]}" /></small>
											</h4></td>
										<td><h4>
												<small><c:out value="${ord[1]}" /></small>
											</h4></td>
										<td><h4>
												<small><c:out value="${ord[2]}" /></small>
											</h4></td>
										<td><h4>
												<small><c:out value="${ord[3]}" /></small>
											</h4></td>
										<td><h4>
												<small><c:out value="${ord[4]}" /></small>
											</h4></td>
										<td><h4>
												<small><c:out value="${ord[5]}" /></small>
											</h4></td>
											

									</tr>
								</c:forEach>
							</table>
						</div>

					</div>


				</div>
			</div>
			<hr>

		</div>
		<div class="panel-footer">
			<div class="row text-center">
				<div class="col-xs-9">
					<h4 class="text-right"></h4>
				</div>
			</div>
		</div>
	</div>
	<div id="footer"></div>
</body>
</html>