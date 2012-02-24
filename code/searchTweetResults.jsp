<%@include file="header.jsp" %>
<html>
<%String search = request.getParameter("search");
if (search==null) {
response.sendRedirect("home.jsp");
}
String admin = session.getAttribute("admin").toString();
 %>
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
"SELECT * from tweets WHERE Tag LIKE '%"+search+"%' ORDER BY Date";
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
<h1>
View  Search Results</h1>
<table style="width: 100%">
	<tr>
		<td style="width: 422px; height: 23px"><strong>Poster Username</strong></td>
		<td style="height: 23px"><strong>Text</strong></td>
		<td style="height: 23px"><strong>Tag</strong></td>
		<td style="height: 23px"><strong>Date</strong></td>
		<% if (admin.equals("1"))
		{
		%>
		<td style="height: 23px"><strong>Delete Tweet</strong></td>
		<%
		}
		%>
	</tr>	
<% while (rs.next()) { %>
	<tr>
		<td style="width: 422px"><%=rs.getString(5)%></td>
		<td><%=rs.getString(3)%></td>
		<td><%=rs.getString(4)%></td>
		<td><%=rs.getString(2)%></td>
		<% if (admin.equals("1"))
		{
		%>
		<td style="height: 23px"><form action="admin" method="post">
			<input name="Tweet" type="submit" value="Delete"><input name="type" type="hidden" value="tweet"><input name="un" type="hidden" value=<%=rs.getString(1)%>></form>
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