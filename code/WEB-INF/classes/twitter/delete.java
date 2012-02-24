package twitter;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.sql.*;
import java.sql.*;

public class delete extends HttpServlet
{ 
public void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException,IOException
{
server svr = new server();
response.setContentType("text/html");
PrintWriter out = response.getWriter();
HttpSession session = request.getSession(true);
String delUN = request.getParameter("delUN");
try
{
Statement st = null;
  
   String strQuery = "DELETE FROM `twitter2012`.`freindship` WHERE `Username2`='"+delUN+"'";
 Connection dbcon = null;
   Class.forName("com.mysql.jdbc.Driver").newInstance();
   dbcon =DriverManager.getConnection(svr.getURL(),svr.getUN(),svr.getPW());
   st = dbcon.createStatement();
   st.executeUpdate(strQuery);
   session.setAttribute("ErrorMessage","Freind Deleted");
   response.sendRedirect("home.jsp");
   }
catch(Exception e)
{
response.sendRedirect("error.jsp");
}
}
}