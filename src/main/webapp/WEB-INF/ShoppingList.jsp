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

		<p>Hello, ${userName}. <a href ="login?logout">Log out</a></p>
		
		<h2>List</h2>
		
		<form action="ShoppingList" method="post">
			<input type="hidden" name="action" value="add">
			
			<label for="addItem">Add Item:</label>
			<input type="text" name=""addItem" id=""addItem">
			<button type="submit" action=""add">Add</button>
		</form>
		
		<form>
			<p>
				<input type="radio" name=""item" value="apples">
				Apples
			</p>
			<button type="submit" action="delete">Delete</button>		
		</form>
	</body>
</html>
