<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forgot Password</title>
</head>
<body>
	Change Password below:<br><br><br>
	<form action="forgotpswrd" method="post">
		Enter User-ID: <input type="text" name="uid"><br>
		Enter User-Name: <input type="text" name="name"><br>
		Enter new Password: <input type="password" name="pswrd1"><br>
		Re-Enter new Password: <input type="password" name="pswrd2"><br>
		<input type="submit">
	</form> 
</body>
</html>