package twitter;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.sql.*;
import java.sql.*;
import java.util.*; 
public class post extends HttpServlet{ 
 public void doPost(HttpServletRequest request, HttpServletResponse response)
   throws ServletException,IOException{
   server svr = new server();
   	response.setContentType("text/html");
  PrintWriter out = response.getWriter();
   HttpSession session = request.getSession(true);
   String text = request.getParameter("text");
   String tag = request.getParameter("tag");
   //Check if text null
   if (text.length()==0)
   {
   session.setAttribute("ErrorMessage","No text entered!");
   response.sendRedirect("home.jsp");
   }
   else
   {
   try
   {
   Statement st = null;
    Connection dbcon = null;
   Class.forName("com.mysql.jdbc.Driver").newInstance();
   dbcon =DriverManager.getConnection(svr.getURL(),svr.getUN(),svr.getPW());
   String insert = 
   "INSERT INTO `twitter2012`.`tweets` (`Text`, `Tag`, `PosterUsername`) VALUES ('"+text+"', '"+tag+"', '"+session.getAttribute("username").toString()+"')";
   	st = dbcon.createStatement();
	st.executeUpdate(insert);
	dbcon.close();
	session.setAttribute("ErrorMessage","Tweet posted");
	response.sendRedirect("home.jsp");
	}
	catch(Exception e)
   {
   response.sendRedirect("error.jsp");
   }
   }   
   }
   }