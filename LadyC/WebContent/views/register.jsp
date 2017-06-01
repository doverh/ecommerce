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

	<div class="register_account">
		<div class="wrap">
			<h4 class="title">Create an Account</h4>
			<form method="post" action="RegistrationController">
				<div class="col_1_of_2 span_1_of_2">
					<div>
						<input type="text" name="username" value="Username"
							onfocus="this.value = '';"
							onblur="if (this.value == '') {this.value = 'Username';}">
					</div>
					<div>
						<input type="text" name="pwd" value="Password"
							onfocus="this.value = '';"
							onblur="if (this.value == '') {this.value = 'password';}">
					</div>
					<div>
						<input type="text" name="fisrtname" value="First Name"
							onfocus="this.value = '';"
							onblur="if (this.value == '') {this.value = 'First Name';}">
					</div>
					<div>
						<input type="text" name="lastname" value="Last Name"
							onfocus="this.value = '';"
							onblur="if (this.value == '') {this.value = 'Phone';}">
					</div>
					<div>
						<input type="text" name="email" value="E-mail"
							onfocus="this.value = '';"
							onblur="if (this.value == '') {this.value = 'E-Mail';}">
					</div>

				</div>
				<div class="col_1_of_2 span_1_of_2">
					<div>
						<input type="text" name="address" value="Address"
							onfocus="this.value = '';"
							onblur="if (this.value == '') {this.value = 'Address';}">
					</div>
					<div>
						<input type="text" name="city" value="City"
							onfocus="this.value = '';"
							onblur="if (this.value == '') {this.value = 'City';}">
					</div>
					<div>
						<select id="state" name="state" value="State"
							onchange="change_country(this.value)" class="frm-field required">
							<option value="null">Select a State</option>
							<option value="AL">Alabama</option>
							<option value="AK">Alaska</option>
							<option value="AZ">Arizona</option>
							<option value="AR">Arkansas</option>
							<option value="CA">California</option>
							<option value="CO">Colorado</option>
							<option value="CT">Connecticut</option>
							<option value="DE">Delaware</option>
							<option value="DC">District Of Columbia</option>
							<option value="FL">Florida</option>
							<option value="GA">Georgia</option>
							<option value="HI">Hawaii</option>
							<option value="ID">Idaho</option>
							<option value="IL">Illinois</option>
							<option value="IN">Indiana</option>
							<option value="IA">Iowa</option>
							<option value="KS">Kansas</option>
							<option value="KY">Kentucky</option>
							<option value="LA">Louisiana</option>
							<option value="ME">Maine</option>
							<option value="MD">Maryland</option>
							<option value="MA">Massachusetts</option>
							<option value="MI">Michigan</option>
							<option value="MN">Minnesota</option>
							<option value="MS">Mississippi</option>
							<option value="MO">Missouri</option>
							<option value="MT">Montana</option>
							<option value="NE">Nebraska</option>
							<option value="NV">Nevada</option>
							<option value="NH">New Hampshire</option>
							<option value="NJ">New Jersey</option>
							<option value="NM">New Mexico</option>
							<option value="NY">New York</option>
							<option value="NC">North Carolina</option>
							<option value="ND">North Dakota</option>
							<option value="OH">Ohio</option>
							<option value="OK">Oklahoma</option>
							<option value="OR">Oregon</option>
							<option value="PA">Pennsylvania</option>
							<option value="RI">Rhode Island</option>
							<option value="SC">South Carolina</option>
							<option value="SD">South Dakota</option>
							<option value="TN">Tennessee</option>
							<option value="TX">Texas</option>
							<option value="UT">Utah</option>
							<option value="VT">Vermont</option>
							<option value="VA">Virginia</option>
							<option value="WA">Washington</option>
							<option value="WV">West Virginia</option>
							<option value="WI">Wisconsin</option>
							<option value="WY">Wyoming</option>
						</select>
					</div>
					<div>
						<input type="text" name="phone" value="Phone Number"
							onfocus="this.value = '';"
							onblur="if (this.value == '') {this.value = 'Phone';}">
					</div>

				</div>
				<button class="grey">Submit</button>
				<p class="terms">
					By clicking 'Create Account' you agree to the <a href="#">Terms
						&amp; Conditions</a>.
				</p>
				<div class="clear"></div>
			</form>
		</div>
	</div>
	<div id="footer"></div>
</body>
</html>