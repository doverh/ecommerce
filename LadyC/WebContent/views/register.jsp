<!DOCTYPE HTML>
<html>
<head>
<title>Lady C</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../css/style.css" rel="stylesheet" type="text/css"
	media="all" />
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800'
	rel='stylesheet' type='text/css'>
<!-- <script type="text/javascript" src="../js/jquery.min.js"></script>
 -->

<script src="../js/jquery-3.2.1.js"></script>


<script>
	jQuery(document).ready(function($) {
		$("#header").load("header.jsp");
		/* $("#footer").load("footer.html"); 
		 */});
	jQuery(document).ready(function($) {
		$("#footer").load("footer.html");
	});

	$(document).ready(function() {
		$('#id_password_field').val('password');
		$('#id_password_field').click(function() {
			if ($(this).val() == 'password') {
				$(this).val('')
			}
		});
		$('#id_password_field').focus(function() {
			if ($(this).val() == 'password') {
				$(this).val('')
			}
		});
	});

	function checkRegistration() {
		var emailRegex = /^[A-Za-z0-9._]*\@[A-Za-z]*\.[A-Za-z]{2,5}$/;
		//var uname = document.getElementById('uname'); 
		var fname = document.getElementById('firstname'), 
		lname = document.getElementById('lastname'), 
		femail = document.getElementById('email'),
		fpassword = document.getElementById('pwd'), 
		faddress = document.getElementById('address'), 
		fcity = document.getElementById('city'),
		fphone = document.getElementById('phone');
		

		 if (uname.value == "Username") {
			document.form.uname.focus();
			alert("Enter the Username!")
			return false
		} 
		if (fname.value == "First Name") {
			document.form.fisrtname.focus();
			alert("Enter the first name")
			return false
		}
		if (lname.value == "Last Name") {
			document.form.lastName.focus();
			Alert("Enter the last name!");
			return false;
		}

		if (femail.value == "E-mail") {
			document.form.email.focus();
			alert("Enter the e-mail");
			return false;
		} else if (!emailRegex.test(femail)) {
			document.form.email.focus();
			alert("Enter a valid e-mail");
			return false;
		}

		if (fpassword.value == "Password") {
			document.form.pwd.focus();
			alert("Enter the password");

			return false;
		}

		if (faddress.value == "Address") {
			document.form.address.focus();
			alert("Enter the address");
			return false;
		}
		if (fcity.value == "City") {
			document.form.city.focus();
			alert("Enter the city");
			return false;
		}
		if (fphone.value == "Phone Number") {
			document.form.phone.focus();
			alert("Enter the phone number");
			return false;
		}
	}
</script>
</head>
<body>
	<div id="header"></div>

	<div class="register_account">
		<div class="wrap">
			<h4 class="title">Create an Account</h4>
			<form name="form" method="post" action="register.do">
				<div class="col_1_of_2 span_1_of_2">
					<div>
						<input type="text" name="username" id="uname" value="Username"
							onfocus="this.value = '';"
							onblur="if (this.value == '') {this.value = 'Username';}">
					</div>
					<div>
						<input type="password" name="pwd" id="pwd" value="Password"
							placeholder="Password" onfocus="this.value = '';"
							onblur="if (this.value == '') {this.value = 'password';}">
					</div>
					<div>
						<input type="text" name="firstname" id="firstname" value="First Name"
							onfocus="this.value = '';"
							onblur="if (this.value == '') {this.value = 'First Name';}">
					</div>
					<div>
						<input type="text" name="lastname" id="lastname" value="Last Name"
							onfocus="this.value = '';"
							onblur="if (this.value == '') {this.value = 'Last Name';}">
					</div>
					<div>
						<input type="text" name="email" id="email" value="E-mail"
							onfocus="this.value = '';"
							onblur="if (this.value == '') {this.value = 'E-Mail';}">
					</div>

				</div>
				<div class="col_1_of_2 span_1_of_2">
					<div>
						<input type="text" name="address" id="address" value="Address"
							onfocus="this.value = '';"
							onblur="if (this.value == '') {this.value = 'Address';}">
					</div>
					<div>
						<input type="text" name="city" id="city" value="City"
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
						<input type="text" name="phone" id="phone" value="Phone Number"
							onfocus="this.value = '';"
							onblur="if (this.value == '') {this.value = 'Phone';}">
					</div>

				</div>
				<input type="hidden" name="action" value="register" />
				<button class="grey" type="submit"
					onclick="return checkRegistration()">Submit</button>
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