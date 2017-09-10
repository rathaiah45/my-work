<html>
<%@include file="header.jsp"%>
<%@include file="link.jsp" %>
<body>
	<form action="./submit" method="post" name="login">
		<table>
			<tr>
				<td>USERNAME*</td>
				<td><input type="text" name="username"/></td>
			</tr>
			<tr>
				<td>PASSWORD</td>
				<td><input type="password" name="password"/></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>