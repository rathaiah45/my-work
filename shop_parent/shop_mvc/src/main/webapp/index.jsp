<html>
<script>
	var request;
	function sendInfo() {
		var v = document.fname.id.value;
		var url = "./person.jsp?val=" + v;
		if (window.XMLHttpRequest) {
			request = new XMLHttpRequest();
		} else if (window.ActiveXObject) {
			request = new ActiveXObject("Microsoft.XMLHTTP");
		}
		try {
			request.onreadystatechange = getInfo;
			request.open("GET", url, true);
			request.send();
		} catch (e) {
			alert("Unable to connect to server");
		}
	}
	function getInfo() {
		if (request.readyState == 4) {
			var val = request.responseText;
			document.getElementById('amit').innerHTML = val;
		}
	}
</script>
<body>
	<h2>Hello World!</h2>

	<form action="./home/save-person" method="post" name="person">
		<table>
			<tr>
				<td>FULLANME</td>
				<td><input type="text" name="full_name" /></td>
			</tr>
			<tr>
				<td>EMAIL</td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td>USERNAME</td>
				<td><input type="text" name="username" /></td>
			</tr>
			<tr>
				<td>PASSWORD</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" /></td>
				<td><input type="reset" value="Reset" /></td>
			</tr>
		</table>
	</form>
	<form action="" name="fname">
		<input type="text" name="id" />
	</form>
	<input type="button" value="ShowTable" onClick="sendInfo()">
	<span id="amit"> </span>
	<a href="./home/login">login</a>
</body>
</html>
