<%@include file="header.jsp" %>
<% String email = null;
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
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<title>Change Details</title>
<link href="stylesheet.css" rel="stylesheet" type="text/css" />
<style type="text/css">
.auto-style1 {
	text-align: left;
}
</style>
</head>
<body>
<h1>Change your details</h1>
<p>Please make any changes below</p>
<form action="update" method="post" >
<table style="width: 100%">
	<tr>
		<td style="width: 277px">Email Address</td>
		<td class="auto-style1">
	<input name="email" tabindex="2" type="text" size="45" style="width: 124px" value="<%=email%>" maxlength="45" class="auto-style1" /></td>
	</tr>
	<tr>
		<td style="width: 277px">Password</td>
		<td>
	<input name="pw1" tabindex="3" type="password" size="20" maxlength="20" /></td>
	</tr>
	<tr>
		<td style="width: 277px">Re-enter Password</td>
		<td>
	<input name="pw2" tabindex="4" type="password" size="20" /></td>
	</tr>
	<tr>
		<td style="width: 277px">

	<input name="Submit1" tabindex="10" type="submit" value="Update" /></td>
		<td>
	<input name="Reset1" type="reset" value="Reset" /></td>
	</tr>
</table>

</form>
	
</body>

</html>
