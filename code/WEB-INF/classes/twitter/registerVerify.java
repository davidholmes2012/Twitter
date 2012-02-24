package twitter;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.sql.*;
import java.sql.*;
import org.apache.commons.fileupload.*;
import org.apache.commons.io.output.*;
import org.apache.commons.fileupload.servlet.*;
import org.apache.commons.fileupload.disk.*;
import java.util.*;
public class registerVerify extends HttpServlet
{ 
public void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException,IOException

{
server svr = new server();
response.setContentType("text/html");
  PrintWriter out = response.getWriter();
HttpSession errorSession = request.getSession(true);
HttpSession session = request.getSession(true);
String name = request.getParameter("name");
String username = request.getParameter("username");
String email = request.getParameter("email");
String pw1 = request.getParameter("pw1");
String pw2 = request.getParameter("pw2");

String TandC = request.getParameter("TandC");

String error=null;

// check nulls
if (name.length() == 0)
{
error = "No name provided!";
callError(error,response,name,username,email,request);

}
else if (username.length() == 0)
{
error = "No username provided";
callError(error,response,name,username,email,request);
}
else if (pw1.length() == 0)
{
error = "No password provided";
callError(error,response,name,username,email,request);
}
else if (pw2.length() == 0)
{
error = "No password provided";
callError(error,response,name,username,email,request);
}
else if (pw1.compareTo(pw2) != 0)
{
error = "Passwords do not match";
callError(error,response,name,username,email,request);
}
else if (TandC.equals("No"))
{
error = "You must accept the terms and conditions before you can use this site!";
callError(error,response,name,username,email,request);
}
else
{
try {
Statement st = null;
   ResultSet rs = null;
   String strQuery = "Select * from users where username = '"+username+"'";
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
	PreparedStatement insert = null;
	//File image = new File("C:\\Users\\David\\Desktop\\resin-4.0.25\\webapps\\ROOT\\image\\face.png");
	//FileInputStream fis;
	insert = dbcon.prepareStatement
	("INSERT INTO users (username,password,name,email_address,admin)" + "values(?,?,?,?,?)");
	//st.executeUpdate(insert);//st = dbcon.createStatement();
	insert.setString(1,username);
	insert.setString(2,pw1);
	insert.setString(3,name);
	insert.setString(4,email);
	insert.setInt(5,0);
	//fis = new FileInputStream(image);
//	insert.setBinaryStream(6, (InputStream)fis,(int)(image.length()));
	insert.executeUpdate();
	session.setAttribute("password",pw1);
	session.setAttribute("name",name);
	session.setAttribute("email",email);
	session.setAttribute("loggedin",true);
	
}
else
{
error = "username taken";
callError(error,response,name,username,email,request);
}
   
response.sendRedirect("home.jsp");
dbcon.close();
}
catch (Exception ex)
{
out.println(ex);
response.sendRedirect("error.jsp");
}
}
}


public void callError(String error,HttpServletResponse response,String name,String username,String email,HttpServletRequest request)
throws ServletException,IOException

{
HttpSession errorSession = request.getSession(true);

errorSession.setAttribute("ErrorMessage",error);
errorSession.setAttribute("Name",name);
errorSession.setAttribute("Username",username);
errorSession.setAttribute("Email",email);
response.sendRedirect("register.jsp");
}
}