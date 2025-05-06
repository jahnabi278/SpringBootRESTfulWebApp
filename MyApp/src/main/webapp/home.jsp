<html>
<head>
<title>First JSP</title>
</head>
<body>
<h3>SignUp</h3><br>

<form action="addSynUser">
	<input type ="text" name = "userName"><br><br>
	<input type ="text" name ="passWord"><br><br>
	<input type ="text" name ="city"><br><br>
	<input type ="text" name = "mobile"><br><br>
	<input type ="text" name ="name"><br><br>
	<input type = "submit"><br>	
</form>

<br><br>
<h3>SignIn</h3><br>

<form action="validateUser">
	<input type ="text" name = "userName"><br><br>
	<input type ="text" name ="passWord"><br><br>
	<input type = "submit"><br>
		
</form>

<br><br>
<h3>showUser</h3><br>

<form action="getUser">
	<input type ="text" name = "userName"><br><br>
	<input type = "submit"><br>
			
</form>


</body>
</html>
