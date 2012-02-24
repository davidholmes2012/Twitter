package twitter;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.sql.*;
import java.sql.*;
import java.util.*;
public class update extends HttpServlet
{ 
public void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException,IOException

{
server svr = new server();
response.setContentType("text/html");
HttpSession session = request.getSession(true);
PrintWriter out = response.getWriter();
String email = request.getParameter("email");
String pw1 = request.getParameter("pw1");
String pw2 = request.getParameter("pw2");
String error = null;
String username = session.getAttribute("username").toString();
if (pw1.compareTo(pw2) != 0)
{
error = "Passwords do not match";
session.setAttribute("ErrorMessage",error);
response.sendRedirect("home.jsp");
}
try
{
Statement st = null;
String strQuery = null;
if((pw1.length() == 0) && (email.length()==0))
{
session.setAttribute("ErrorMessage","Nothing to change!");
response.sendRedirect("home.jsp");
}
else if ((pw1.length() != 0) && (email.length() !=0))
{
strQuery = 
"UPDATE `twitter2012`.`users` SET `password`='"+pw1+"', `email_address`='"+email+"' WHERE `username`='"+username+"'";
session.setAttribute("email",email);
}
else if ((pw1.length()==0) && (email.length() !=0))
{
strQuery = 
"UPDATE `twitter2012`.`users` SET `email_address`='"+email+"' WHERE `username`='"+username+"'";
session.setAttribute("email",email);
}

else if ((pw1.length()!=0) && (email.length() ==0))
{
strQuery = 
"UPDATE `twitter2012`.`users` SET `password`='"+pw1+"' WHERE `username`='"+username+"'";
}
   Connection dbcon = null;
   Class.forName("com.mysql.jdbc.Driver").newInstance();
   dbcon =DriverManager.getConnection(svr.getURL(),svr.getUN(),svr.getPW());
   		st = dbcon.createStatement();
		st.executeUpdate(strQuery);
		session.setAttribute("ErrorMessage","Details Changed");
dbcon.close();
session.setAttribute("ErrorMessage","Details Changed");
response.sendRedirect("home.jsp");
}
catch(Exception ex)
{
out.println(ex);
}
}
}