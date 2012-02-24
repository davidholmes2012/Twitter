<html>
<link rel="icon" 
      type="image/png" 
      href="image/logo.png">
<%if (false == session.getAttribute("loggedin")){  
response.sendRedirect("login.jsp");
}
else if (null == session.getAttribute("loggedin"))
{
response.sendRedirect("login.jsp");
}%>
<head>
<style type="text/css">
.auto-style1 {
	text-align: center;
}
.auto-style2 {
	color: #000080;
}
</style>
</head>

<body>

<table style="width: 100%">
	<tr>
		<td class="auto-style1" colspan="4"><strong>Welcome to Twitter</strong></td>
		<td rowspan="2">
		<img alt="logo" height="50" src="image/logo.png" style="float: right" width="50"></td>
	</tr>
	<tr>
		<td><a href="home.jsp">Main Menu</a></td>
		<td><a href="tweetSearch.jsp">Search Tweets</a></td>
		<td><a href="profile.jsp">View my Profile</a></td>
		<td><a href="logout">Logout</a></td>
	</tr>
</table>

<hr class="auto-style2" noshade="noshade" style="height: 3">

</body>

</html>
