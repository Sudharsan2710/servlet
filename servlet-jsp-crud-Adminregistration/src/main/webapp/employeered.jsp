<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RegisterPage</title>
</head>
<style>
	
		.container {
    max-width: 400px;
    margin: 50px auto;
    padding: 20px;
    background-color: #fff;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

h2 {
    margin-bottom: 20px;
    text-align: center;
}

.form-group {
    margin-bottom: 20px;
}

label {
    display: block;
    margin-bottom: 5px;
}

input[type="text"],
input[type="email"],
input[type="password"],
input[type="date"],
input[type="submit"]
select {
    width: 100%;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}

button {
    display: block;
    width: 100%;
    padding: 10px;
    background-color: #00ff44;
    color: #fff;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    transition: background-color 0.3s ease;
}


button:hover {
    background-color: #00e63e;
}
.container {
    max-width: 400px;
    margin: 50px auto;
    padding: 20px;
    background-color: #fff;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

h2 {
    margin-bottom: 20px;
    text-align: center;
}

p {
    margin-bottom: 10px;
    text-align: center;
}
.main-div{
    border-radius: 0px;

}
body{
    margin: 0;
    font-family: Arial, Helvetica, sans-serif;
}
.topnav{
    overflow: hidden;
    background-color: rgb(0, 12, 12);
}
.topnav a{
    float : left;
    display: block;
    color: black;
    text-align: center;
    padding: 12px 14px;
    text-decoration: none;
    font-size: 16px;
}
.topnav a:hover{
    background-color: #ddd;
    color: white;
    font-size: medium;
    font-weight: 100;
}
html,body{
    display: flexbox;
    height: 100%;
    width: 100%;
    place-items: center;
    background: -webkit-linear-gradient(left, #9896F0,#FBC8D5);
    padding-bottom: 0%;

  }

		

</style>
	
<body>

<form action="<%=request.getContextPath() %>/EmployeeServlet" method="post">
        
        <div class="container">
            <h2>Add Employee Registration</h2>

            <div class="form-group">
                <label for="fullname">Full Name:</label>
                <input type="text" id="fullname" name="fullname" placeholder="Enter your full name" required>
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" placeholder="Enter your email" required>
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" placeholder="Enter your password" required>
            </div>
           
            <div class="form-group">
                <label for="contact">contact:</label>
                <input type="text" id="contact" name="contact" placeholder="Enter your contact" required>
            </div>
           
           
            <div class="container">
                <button type="submit" class="registerbtn">Register</button>
            </div>
            
        </div>
        



    </form>

</body>
</html>