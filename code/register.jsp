<%String error = null;
String name = null;
String username = null;
String email = null;
if (null == session.getAttribute("ErrorMessage")){  
error = "  ";
}
else if (session.getAttribute("ErrorMessage").toString().equals("false"))
{
error = "  ";

}
else
{
error = session.getAttribute("ErrorMessage").toString();
}
if (null == session.getAttribute("name")){  
name = "";
}
else
{
name = session.getAttribute("name").toString();
}
if (null == session.getAttribute("username")){  
username = "";
}
else
{
username = session.getAttribute("username").toString();
}
if (null == session.getAttribute("email")){  
email = "";
}
else
{
email = session.getAttribute("email").toString();
}
%>
<html>

<head>
<link rel="icon" 
      type="image/png" 
      href="image/logo.png">

<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<title>User Registration</title>
<link href="stylesheet.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h1>User Registration</h1>
<h2><%=error%></h2>
<p>Please enter your details below:</p>
<p>Fields marked with an asterisk (*) are mandatory</p>
<form action="registerVerify" method="post" >
	<table style="width: 100%">
		<tr>
			<td style="width: 429px">Actual Name*&nbsp;</td>
			<td>
	<input name="name" type="text" tabindex="0" size="45" maxlength="25" value="<%=name%>"/></td>
		</tr>
		<tr>
			<td style="width: 429px">Username*</td>
			<td>
	<input name="username" tabindex="1" type="text" size="20"value="<%=username%>" /></td>
		</tr>
		<tr>
			<td style="width: 429px">Email Address*&nbsp;</td>
			<td>
	<input name="email" tabindex="2" type="text" size="45" style="width: 132px" value="<%=email%>" /></td>
		</tr>
		<tr>
			<td style="width: 429px">Password*</td>
			<td> 
	<input name="pw1" tabindex="3" type="password" size="20" maxlength="20"/></td>
		</tr>
		<tr>
			<td style="width: 429px">Re-enter Password*</td>
			<td>
	<input name="pw2" tabindex="4" type="password" size="20" /></td>
		</tr>
		
		<tr>
			<td style="width: 429px">I have read and accept the 
	<br> 
	<a href="terms_and_conditions.html" target="_self">terms and conditions</a> of using this site:
			</td>
			<td>
	<select name="TandC" tabindex="9">
	<option selected="selected">Yes</option>
	<option>No</option>
	</select></td>
		</tr>
		<tr>
			<td style="width: 429px">
	<input name="Submit1" tabindex="10" type="submit" value="Register!" /></td>
			<td>
	<input name="Reset" type="reset" value="Reset" /></td>
		</tr>
	</table>
	</form>	
</body>
</html>