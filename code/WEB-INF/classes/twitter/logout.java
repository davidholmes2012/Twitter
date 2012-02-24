package twitter;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class logout extends HttpServlet{
public void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException{
HttpSession session = request.getSession(true);
response.setContentType("text/html");
session.setAttribute("loggedin",false);
session.setAttribute("name",null);
session.setAttribute("username",null);
session.setAttribute("email",null);
session.setAttribute("admin",null);
response.sendRedirect("login.jsp");
}
}