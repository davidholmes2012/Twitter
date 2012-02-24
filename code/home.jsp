<%@include file="header.jsp" %>
<html>
<head>
<title>Main Menu</title>
<link href="stylesheet.css" rel="stylesheet" type="text/css">
</head>
<% String errorm = "";
if (false == session.getAttribute("ErrorMessage"))
{  
}
else
{
errorm = session.getAttribute("ErrorMessage").toString();
}
%>
<body>
<h1>Main Menu</h1>
<h2><%=errorm%></h2>
<p>Welcome to this version of Twitter, it allows you to search for 
and view your friends profiles, add people as friends, send them tweets, and 
send tweets about general items.</p>
<p>To maintain the security of the site, please always remember to logout when 
you leave.</p>
<p>If you forget your password, you can contact a memeber of the administration 
team to reset it for you.</p>
<p><a href="changeDetails.jsp">Change your stored 
details</a></p>
<p><a href="findFreinds.jsp">Search for Freinds</a></p>
<p><a href="post.jsp">Post a tweet</a></p>
<p><a href="profile.jsp">View your profile</a></p>
<p><a href="tweetSearch.jsp">Search Tweets</a></p>
<p><a href="view_friends.jsp">View your freinds list</a></p>

<form action="logout" method="get">
<input name="Logout" type="submit" value="Logout"></form>
</body>

</html>
<%session.setAttribute("ErrorMessage",false);%>