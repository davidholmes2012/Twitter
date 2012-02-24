<%@include file="header.jsp" %>
<%String error = null;
if (null == session.getAttribute("error")){  
error = "  ";
}
else
{
error = session.getAttribute("error").toString();
}%>
<html>
<head>

<title>Find Freinds</title>
<link href="stylesheet.css" rel="stylesheet" type="text/css">
</head>
<body>
<h1>Find Friends</h1>
<h2><%=error%></h2>
<p>To search for freinds to follow please enter part of their username in the 
box.</p>
<p>If you wish to view all the users of the site then simply click submit.</p>

<form action ="fResult.jsp" method="post">
<p>Username:&nbsp;&nbsp;&nbsp;
<input name="sun" type="text" ></p>
<p><input name="Submit1" type="submit" value="submit">
</form>

</body>

</html>
