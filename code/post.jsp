<%@include file="header.jsp" %>
<html>
<%
String un = request.getParameter("profileUN");
if (un==null) {
un="";
}
%>
<head>
<title>Post a Tweet</title>
<link href="stylesheet.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h1>Post a Tweet</h1>
<form method="post" action="post">
	Tweet
	<input name="text" type="text" size="139" maxlength="139"> <br>
	<br>Tag&nbsp;&nbsp;&nbsp; 
	<input name="tag" type="text" size="45" value = "<%=un%>" maxlength="45" style="width: 188px">
	<input name="Submit1" type="submit" value="Submit Tweet">&nbsp;&nbsp;
	<input name="Reset1" type="reset" value="Reset Form"></form>
</body>
</html>
