package twitter;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.sql.*;
import java.sql.*;
public class loginscript extends HttpServlet{ 
 public void doPost(HttpServletRequest request, HttpServletResponse response)
   throws ServletException,IOException{
   server svr = new server();
	response.setContentType("text/html");
  PrintWriter out = response.getWriter(); 
  HttpSession session = request.getSession(true);
   try
   {
    Connection dbcon = null;
   
String username = request.getParameter("username");
String password = request.getParameter("password");
   String strQuery ="";
   Statement st = null;
   ResultSet rs = null;
  
   Class.forName("com.mysql.jdbc.Driver").newInstance();
   dbcon =DriverManager.getConnection(svr.getURL(),svr.getUN(),svr.getPW());
   strQuery="select * from users where username='"+username+"' and password ='"+password+"'";
		st = dbcon.createStatement();
		rs = st.executeQuery(strQuery);
		int count = 0;
		while(rs.next())
		{
		session.setAttribute("username",rs.getString(1));
		session.setAttribute("email",rs.getString(3));
		session.setAttribute("admin",rs.getString(5));
		session.setAttribute("name",rs.getString(4));
		session.setAttribute("image",rs.getString(6));
		session.setAttribute("ErrorMessage",false);
		count++;
		}
		
		if (count >0)
		{
		session.setAttribute("loggedin",true);
		 response.sendRedirect("home.jsp");
		 }
		 else
		 {
		 session.setAttribute("loggedin",false);
		 response.sendRedirect("login.jsp");
		 }
   
   dbcon.close();	
	}	
	catch (Exception ex)
	{
	session.setAttribute("loggedin",false);
	response.sendRedirect("error.jsp");
		}
	}
	}
	