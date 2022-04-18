<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	Enter Login Details:<br>
 	<form action="loginacnt" method="post">
		Enter User-ID: <input type="text" name="uid"><br>
		Enter Password: <input type="password" name="pword"><br>
		<input type="submit" value="Login">
	</form>

	<br>
	<br>
	<a href="forgotpassword.jsp">Forgot Password</a>
	<br>
	<br>
	<a href="createacc.jsp"> Create Account </a>
	<br>
	<a href="test.jsp">Check this out</a>
	
</body>
</html>