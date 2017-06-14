<html>
<head>
<link href="/resources/css/style.css" rel="stylesheet" />
<link href="/resources/css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="/resources/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/resources/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="/resources/js/bootstrap.js"></script>
</head>
<body>

	<h2>Hello World!</h2>

	<!-- <form action="./home/save-data" method="post">
		<table>
			<tr>
				<td>FirstName</td>
				<td><input type="text" name="first_name" /></td>
			</tr>
			<tr>
				<td>LastName</td>
				<td><input type="text" name="last_name" /></td>
			</tr>
			<tr>
				<td>JoiningDate</td>
				<td><input type="date" name="joining_date" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td>MobileNumber</td>
				<td><input type="number" name="mobile_number" /></td>
			</tr>
			<tr>
				<td>HouseNo</td>
				<td><input type="text" name="house_no" /></td>
			</tr>
			<tr>
				<td>Street</td>
				<td><input type="text" name="street" /></td>
			</tr>
			<tr>
				<td>City</td>
				<td><input type="text" name="city" /></td>
			</tr>
			<tr>
				<td>Pincode</td>
				<td><input type="number" name="pincode" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" /></td>
				<td><input type="reset" value="Reset" /></td>
			</tr>
		</table>
	</form> -->
	<div class="container">
		<form action="" method="post">
			<div class="form-group">
				<label for="email">Email:</label> <input type="email"
					class="form-control" id="email" placeholder="Enter email"
					name="email">
			</div>
			<div class="form-group">
				<label for="pwd">Password:</label> <input type="password"
					class="form-control" id="pwd" placeholder="Enter password"
					name="pwd">
			</div>
			<div class="checkbox">
				<label><input type="checkbox" name="remember">
					Remember me</label>
			</div>
			<button type="submit" class="btn btn-default">Submit</button>
		</form>
	</div>
</body>
</html>
