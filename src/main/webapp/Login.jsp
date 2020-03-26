<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h1>
		Please, Enter your credentials
	</h1>
	
	<form action="login" method="POST">
	
		<label>Email: <input type="email" name="email" id="email" /></label><br>
		<label>Name: <input type="text" name="nome" id="nome" /></label>
		<label>Surname: <input type="text" name="cognome" id="cognome" /></label>
		<label>Password: <input type="password" name="pwd" id="pwd"/></label>
		
		<input type="submit" value="Submit"/>
		
	</form>
	
</body>
</html>