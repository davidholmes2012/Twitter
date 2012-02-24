<%@include file="header.jsp" %>
<html>

<%String un = request.getParameter("sun");
if (un==null) {
response.sendRedirect("home.jsp");
}
String admin = session.getAttribute("admin").toString(); %>
<%@page import="java.sql.*,java.util.*" %>
<%@ page import="java.io.*" %> 
<jsp:useBean id="server"
	scope="page"
	class="twitter.server" />
	<%
try
{
Statement st = null;
ResultSet rs = null;
String query = 
"SELECT * from users WHERE username LIKE '%"+un+"%'";
Connection dbcon = null;
Class.forName("com.mysql.jdbc.Driver").newInstance();
 dbcon =DriverManager.getConnection(server.getURL(),server.getUN(),server.getPW());
   		st = dbcon.createStatement();
		rs = st.executeQuery(query);
	int count = 0;
%>
<head>
<link href="stylesheet.css" rel="stylesheet" type="text/css">
<title>Search Results</title>
</head>
<body>
<h1>View Search Results</h1>
<table style="width: 100%">
	<tr>
		<td style="width: 422px; height: 23px"><strong>Username</strong></td>
		<td style="height: 23px"><strong>Actual Name</strong></td>
		<td style="height: 23px; width: 126px;"><strong>Image</strong></td>
		<td style="height: 23px"><strong>Add</strong></td>
		<% if (admin.equals("1"))
		{
		%>
		<td style="height: 23px"><strong>Delete User</strong></td>
		<td style="height: 23px"><strong>Reset Password</strong></td>
		<td style="height: 23px"><strong>Make Admin</strong></td>
		<%
		}
		%>
	</tr>	
<% while (rs.next()) { %>
	<tr>
		<td style="width: 422px"><%=rs.getString(1)%></td>
		<td><%=rs.getString(4)%></td>
		<td style="width: 126px">
		<img alt="" height="57" src="image/face.png" width="79"></td>
		<td>
		<form action="addFreind" method="post">
			<input name="Submit1" type="submit" value="Add <%=rs.getString(4)%>"><input name="un" type="hidden" value="<%=rs.getString(1)%>"></form>
		</td>
		<% if (admin.equals("1"))
		{
		%>
		<td style="height: 23px">
		<form action="admin" method="post">
			<input name="Delete" type="submit" value="Delete"><input name="type" type="hidden" value="delete"><input name="un" type="hidden" value=<%=rs.getString(1)%>></form>
		</td>
		<td style="height: 23px"><form action="admin" method="post">
			<input name="Reset" type="submit" value="Reset"><input name="type" type="hidden" value="reset"><input name="un" type="hidden" value=<%=rs.getString(1)%>></form>
</td>
<td style="height: 23px"><form action="admin" method="post">
			<input name="Admin" type="submit" value="Admin"><input name="type" type="hidden" value="admin"><input name="un" type="hidden" value=<%=rs.getString(1)%>></form>
</td>

		<%
		}
		%>
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