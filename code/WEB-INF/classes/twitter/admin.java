package twitter;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.sql.*;
import java.sql.*;
import java.util.*; 
public class admin extends HttpServlet{ 
 public void doPost(HttpServletRequest request, HttpServletResponse response)
   throws ServletException,IOException{
   server svr = new server();
   	response.setContentType("text/html");
  PrintWriter out = response.getWriter();
  try
  {
   HttpSession session = request.getSession(true);
   String un = request.getParameter("un");
   String type = request.getParameter("type");
Statement st = null;
 Connection dbcon = null;
   Class.forName("com.mysql.jdbc.Driver").newInstance();
   dbcon =DriverManager.getConnection(svr.getURL(),svr.getUN(),svr.getPW());
   String command = null;
   out.println(type);
   if (type.equals("delete"))
   {
   command = "DELETE FROM users WHERE username='"+un+"'";
   }

else if (type.equals("admin"))
{
command = "UPDATE users SET admin=1 WHERE username='"+un+"'";
}
else if (type.equals("reset"))
{
command = "UPDATE users SET password='abc123' WHERE username='"+un+"'";
}
else if (type.equals("tweet"))
{
command = "DELETE FROM tweets WHERE idTweets='"+un+"'";
}
   		st = dbcon.createStatement();
		st.executeUpdate(command);		
dbcon.close();
session.setAttribute("ErrorMessage","Completed");
response.sendRedirect("home.jsp");
  }
  catch (Exception e)
  {
  response.sendRedirect("error.jsp");
  }
  }
  }