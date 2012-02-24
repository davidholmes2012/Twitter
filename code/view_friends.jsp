<%@include file="header.jsp" %>
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
Blob image;
byte b;
byte imgData[] = null;
String query = 
"SELECT users.username, users.name, users.image FROM freindship INNER JOIN users on freindship.Username2 = users.username AND freindship.Username1 = '"+username+"'";
Connection dbcon = null;
Class.forName("com.mysql.jdbc.Driver").newInstance();
 dbcon =DriverManager.getConnection(server.getURL(),server.getUN(),server.getPW());
   		st = dbcon.createStatement();
		rs = st.executeQuery(query);
	int count = 0;

%>
<html>
<head>
<title>View Friends</title>
<link href="stylesheet.css" rel="stylesheet" type="text/css">
</head>
<body>
<h1>View Friends</h1>
<p>You are friends with the following people:</p>
<table style="width: 75%" cellpadding="2" class="auto-style1">
	<tr>
		<td style="height: 22px" ><b>Username</b></td>
		<td style="height: 22px; width: 186px;"><strong>Actual Name</strong></td>
		<td style="height: 22px; width: 87px;" ><strong>Photo</strong></td>
		<td style="height: 22px" ><strong>Delete</strong></td>
		<td style="height: 22px" ><strong>View Profile</strong></td>
		<td style="height: 22px" ><strong>Tweet</strong></td>
	</tr>
	<% while (rs.next()) { 
	%>
	<tr>
		<td><%=rs.getString(1)%></td>
		<td style="width: 186px"><%=rs.getString(2)%></td>
		<td style="width: 87px" >
		<img height="70" src="face.png" width="71"></td>
		<td>
	
		
		<form action="delete" method="post">
			<input name="Delete" type="submit" value="Delete <%=rs.getString(1)%>"><input name="delUN" type="hidden" value="<%=rs.getString(1)%>"></form>
	
		
		</td>
		<td >
		<form action="profile.jsp" method="post">
			<input name="View" type="submit" value="View <%=rs.getString(1)%>">
			<input name="profileUN" type="hidden" value="<%=rs.getString(1)%>"></form>
		</td>
		<td >
		<form action="post.jsp" method="post">
			<input name="Tweet" type="submit" value="Tweet <%=rs.getString(1)%>">
			<input name="profileUN" type="hidden" value="<%=rs.getString(1)%>"></form>
</td>
</tr>
	<% }%>
</table>
</body>

</html>
<% 
dbcon.close();}
catch(Exception ex)
{
response.sendRedirect("error.jsp");
}