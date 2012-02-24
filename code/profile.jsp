<%@include file="header.jsp" %>
<html>
<%String un = request.getParameter("profileUN");
if (un==null) {
un =  session.getAttribute("username").toString();
} %>
<%@page import="java.sql.*,java.util.*" %>
<%@ page import="java.io.*" %> 
<jsp:useBean id="server"
	scope="page"
	class="twitter.server" />
	<%
try
{
String username = session.getAttribute("username").toString();
Statement st = null;
ResultSet rs = null;
String query = 
"SELECT * FROM twitter2012.tweets WHERE tag = '"+un+"' OR PosterUsername = '"+un+"' ORDER BY Date";
Connection dbcon = null;
Class.forName("com.mysql.jdbc.Driver").newInstance();
 dbcon =DriverManager.getConnection(server.getURL(),server.getUN(),server.getPW());
   		st = dbcon.createStatement();
		rs = st.executeQuery(query);
	int count = 0;
%>
<head>
<link href="stylesheet.css" rel="stylesheet" type="text/css">
<title><%=un%> Profile</title>
</head>
<body>
<h1>
<img alt="" height="87" src="image/face.png" style="float: right" width="121">View <%=un%> Profile</h1>
<table style="width: 100%">
	<tr>
		<td style="width: 422px; height: 23px"><strong>Poster Username</strong></td>
		<td style="height: 23px"><strong>Text</strong></td>
		<td style="height: 23px"><strong>Tag</strong></td>
		<td style="height: 23px"><strong>Date</strong></td>
		<td style="height: 23px"></td>
	</tr>	
<% while (rs.next()) { %>
	<tr>
		<td style="width: 422px"><%=rs.getString(5)%></td>
		<td><%=rs.getString(3)%></td>
		<td><%=rs.getString(4)%></td>
		<td><%=rs.getString(2)%></td>
		<td>
		<%if(rs.getString(5).equals(session.getAttribute("username").toString()))
		{ %>
		<form action="deletePost" method="post">
			<input name="Submit" type="Submit" value="Delete Post"><input name="id" type="hidden" value="<%=rs.getInt(1)%>">
			</form>		
			<%}%>
		</td>
	</tr>
<%}%>	
</table>
</body>
</html>
<%
dbcon.close();
}
catch (Exception ex)
{
response.sendRedirect("error.jsp");
} %>