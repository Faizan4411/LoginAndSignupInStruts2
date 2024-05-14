<!DOCTYPE html>
<!-- Coding by CodingLab | www.codinglabweb.com-->
<%@ taglib uri="/struts-tags" prefix="s" %> 
<html lang="en" dir="ltr">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> Registration or Sign Up form in HTML CSS | CodingLab </title>
    <link rel="stylesheet" href="style.css">
   </head>
<body>
  <div class="wrapper">
    <h2>Registration</h2>
	
    <form action="registrationAction" method="post">
      <!-- <div class="input-box"> -->
        <!-- <input type="text" placeholder="Enter your name" name="userName"	required> -->
      <!-- </div> -->
      <div class="input-box">
        <!-- <input type="text" placeholder="Enter your email" name="email" require>-->
		<s:textfield name="email" />
      </div>
      <div class="input-box">
        <!--<input type="password" placeholder="Create password" name="password" required>-->
		<s:textfield name="password" />
      </div>
      <div class="input-box">
       <!--<input type="password" placeholder="Confirm password" name="confirmPassword" required>-->
	   <s:textfield name="confirmPassword" />
      </div>
      <div class="policy">
        <input type="checkbox">
        <h3>I accept all terms & condition</h3>
      </div>
      <div class="input-box button">
        <input type="Submit" value="Register Now">
      </div>
      <div class="text">
        <h3>Already have an account? <a href="http://localhost:8080/LoginFormStruts2/index.jsp">Login now</a></h3>
      </div>
	  
	  <input type="hidden" name="action" value="/signup.jsp"/>
    </form>
  </div>

</body>
</html>
