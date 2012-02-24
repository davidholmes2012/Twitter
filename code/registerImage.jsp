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
<p>If you wish to upload an image please do it below, then press continue, or 
simply press continue if you do not wish to upload one.</p>
<form action="image" method="post" enctype="multipart/form-data"  >
	<table style="width: 100%">
		<tr>
			<td style="width: 429px">Upload an image&nbsp;</td>
			<td>
	<input name="file" tabindex="5" type="file" id="file" /></td>
		</tr>
		<tr>
			<td style="width: 429px">
	<input name="Submit1" tabindex="10" type="submit" value="Continue!" /></td>
			<td>
			&nbsp;</td>
		</tr>
	</table>
	</form>	
</body>
</html>