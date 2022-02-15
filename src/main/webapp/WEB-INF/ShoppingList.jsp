<%-- 
    Author: Leila Nalivkina, Nick Hemnett
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JSP Page</title>
	</head>
	<body>
		<h1>Shopping List</h1>

		<h5>Hello ${userName}.</h5>
		<a href ="login?logout">Log out</a>
		
		<h2>List</h2>
		
		<form>
			<label for="addItem">Add Item:</label>
			<input type="text" name=""addItem" id=""addItem">
			<button type="submit">Add</button>
		</form>
		
		<form>
			<p>
				<input type="radio" name=""item" value="apples">
				Apples
			</p>
			<button type="submit">Delete</button>		
		</form>
	</body>
</html>
