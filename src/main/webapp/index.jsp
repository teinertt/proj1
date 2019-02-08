<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" name="viewport"
	content="width=device-width, initial-scale=1">
<title>Log In</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
</head>
<body>
	<h1>Employee Reimbursement System</h1>
	<form action="FrontController" method="get">
		<div class="form-group">
			<label for="EnterUsername">Enter Username</label> <input
				type="text" class="form-control" name="username"
				aria-describedby="emailHelp" placeholder="Enter username"> 
		</div>
		<div class="form-group">
			<label for="InputPassword1">Password</label> <input
				type="password" class="form-control" name="password"
				placeholder="Enter Password">
		</div>
		<button type="submit" class="btn btn-primary" id="login_button" value="login">Submit</button>
	</form>
</body>
</html>