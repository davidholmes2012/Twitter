package twitter;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.sql.*;
import java.sql.*;
import java.util.*; 
public class addFreind extends HttpServlet{ 
 public void doPost(HttpServletRequest request, HttpServletResponse response)
   throws ServletException,IOException{
   server svr = new server();
   	response.setContentType("text/html");
  PrintWriter out = response.getWriter();
  try
  {
  HttpSession session = request.getSession(true);
Statement st = null;
   ResultSet rs = null;
   String n1 = session.getAttribute("username").toString();
   String n2 =  request.getParameter("un");
   String strQuery = 
   "SELECT * FROM freindship WHERE Username1 = '"+n1+"' AND Username2 = '"+n2+"'";
   Connection dbcon = null;
   Class.forName("com.mysql.jdbc.Driver").newInstance();
   dbcon =DriverManager.getConnection(svr.getURL(),svr.getUN(),svr.getPW());
   		st = dbcon.createStatement();
		rs = st.executeQuery(strQuery);
		int count =0;
		while(rs.next())
		{
		count++;
		}
if (count==0)
{
	String strInsert = "INSERT INTO `twitter2012`.`freindship` (`Username1`, `Username2`) VALUES ('"+n1+"', '"+n2+"')";
	st = dbcon.createStatement();
	st.executeUpdate(strInsert);
   }
   dbcon.close();
	session.setAttribute("ErrorMessage","Freind Addded");
	response.sendRedirect("home.jsp");
   }
   
   catch(Exception e)
   {
   out.println(e);
  response.sendRedirect("error.jsp");
   }
   
   }
   }