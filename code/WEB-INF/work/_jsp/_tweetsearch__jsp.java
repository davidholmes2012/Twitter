/*
 * JSP generated by Resin-4.0.25 (built Tue, 24 Jan 2012 11:09:58 PST)
 */

package _jsp;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;

public class _tweetsearch__jsp extends com.caucho.jsp.JavaPage
{
  private static final java.util.HashMap<String,java.lang.reflect.Method> _jsp_functionMap = new java.util.HashMap<String,java.lang.reflect.Method>();
  private boolean _caucho_isDead;
  private boolean _caucho_isNotModified;
  private com.caucho.jsp.PageManager _jsp_pageManager;
  
  public void
  _jspService(javax.servlet.http.HttpServletRequest request,
              javax.servlet.http.HttpServletResponse response)
    throws java.io.IOException, javax.servlet.ServletException
  {
    javax.servlet.http.HttpSession session = request.getSession(true);
    com.caucho.server.webapp.WebApp _jsp_application = _caucho_getApplication();
    com.caucho.jsp.PageContextImpl pageContext = _jsp_pageManager.allocatePageContext(this, _jsp_application, request, response, null, session, 8192, true, false);

    TagState _jsp_state = null;

    try {
      _jspService(request, response, pageContext, _jsp_application, session, _jsp_state);
    } catch (java.lang.Throwable _jsp_e) {
      pageContext.handlePageException(_jsp_e);
    } finally {
      _jsp_pageManager.freePageContext(pageContext);
    }
  }
  
  private void
  _jspService(javax.servlet.http.HttpServletRequest request,
              javax.servlet.http.HttpServletResponse response,
              com.caucho.jsp.PageContextImpl pageContext,
              javax.servlet.ServletContext application,
              javax.servlet.http.HttpSession session,
              TagState _jsp_state)
    throws Throwable
  {
    javax.servlet.jsp.JspWriter out = pageContext.getOut();
    final javax.el.ELContext _jsp_env = pageContext.getELContext();
    javax.servlet.ServletConfig config = getServletConfig();
    javax.servlet.Servlet page = this;
    javax.servlet.jsp.tagext.JspTag _jsp_parent_tag = null;
    com.caucho.jsp.PageContextImpl _jsp_parentContext = pageContext;
    response.setContentType("text/html");
    response.setCharacterEncoding("utf-8");

    out.write(_jsp_string0, 0, _jsp_string0.length);
    if (false == session.getAttribute("loggedin")){  
response.sendRedirect("login.jsp");
}
else if (null == session.getAttribute("loggedin"))
{
response.sendRedirect("login.jsp");
}
    out.write(_jsp_string1, 0, _jsp_string1.length);
  }

  private com.caucho.make.DependencyContainer _caucho_depends
    = new com.caucho.make.DependencyContainer();

  public java.util.ArrayList<com.caucho.vfs.Dependency> _caucho_getDependList()
  {
    return _caucho_depends.getDependencies();
  }

  public void _caucho_addDepend(com.caucho.vfs.PersistentDependency depend)
  {
    super._caucho_addDepend(depend);
    _caucho_depends.add(depend);
  }

  protected void _caucho_setNeverModified(boolean isNotModified)
  {
    _caucho_isNotModified = true;
  }

  public boolean _caucho_isModified()
  {
    if (_caucho_isDead)
      return true;

    if (_caucho_isNotModified)
      return false;

    if (com.caucho.server.util.CauchoSystem.getVersionId() != -4459662849186645341L)
      return true;

    return _caucho_depends.isModified();
  }

  public long _caucho_lastModified()
  {
    return 0;
  }

  public void destroy()
  {
      _caucho_isDead = true;
      super.destroy();
    TagState tagState;
  }

  public void init(com.caucho.vfs.Path appDir)
    throws javax.servlet.ServletException
  {
    com.caucho.vfs.Path resinHome = com.caucho.server.util.CauchoSystem.getResinHome();
    com.caucho.vfs.MergePath mergePath = new com.caucho.vfs.MergePath();
    mergePath.addMergePath(appDir);
    mergePath.addMergePath(resinHome);
    com.caucho.loader.DynamicClassLoader loader;
    loader = (com.caucho.loader.DynamicClassLoader) getClass().getClassLoader();
    String resourcePath = loader.getResourcePathSpecificFirst();
    mergePath.addClassPath(resourcePath);
    com.caucho.vfs.Depend depend;
    depend = new com.caucho.vfs.Depend(appDir.lookup("tweetSearch.jsp"), -3076669215319968785L, false);
    _caucho_depends.add(depend);
    depend = new com.caucho.vfs.Depend(appDir.lookup("header.jsp"), 7773134504633206276L, false);
    _caucho_depends.add(depend);
  }

  final static class TagState {

    void release()
    {
    }
  }

  public java.util.HashMap<String,java.lang.reflect.Method> _caucho_getFunctionMap()
  {
    return _jsp_functionMap;
  }

  public void caucho_init(ServletConfig config)
  {
    try {
      com.caucho.server.webapp.WebApp webApp
        = (com.caucho.server.webapp.WebApp) config.getServletContext();
      init(config);
      if (com.caucho.jsp.JspManager.getCheckInterval() >= 0)
        _caucho_depends.setCheckInterval(com.caucho.jsp.JspManager.getCheckInterval());
      _jsp_pageManager = webApp.getJspApplicationContext().getPageManager();
      com.caucho.jsp.TaglibManager manager = webApp.getJspApplicationContext().getTaglibManager();
      com.caucho.jsp.PageContextImpl pageContext = new com.caucho.jsp.InitPageContextImpl(webApp, this);
    } catch (Exception e) {
      throw com.caucho.config.ConfigException.create(e);
    }
  }

  private final static char []_jsp_string0;
  private final static char []_jsp_string1;
  static {
    _jsp_string0 = "<html>\r\n<link rel=\"icon\" \r\n      type=\"image/png\" \r\n      href=\"image/logo.png\">\r\n".toCharArray();
    _jsp_string1 = "\r\n<head>\r\n<style type=\"text/css\">\r\n.auto-style1 {\r\n	text-align: center;\r\n}\r\n.auto-style2 {\r\n	color: #000080;\r\n}\r\n</style>\r\n</head>\r\n\r\n<body>\r\n\r\n<table style=\"width: 100%\">\r\n	<tr>\r\n		<td class=\"auto-style1\" colspan=\"4\"><strong>Welcome to Twitter</strong></td>\r\n		<td rowspan=\"2\">\r\n		<img alt=\"logo\" height=\"50\" src=\"image/logo.png\" style=\"float: right\" width=\"50\"></td>\r\n	</tr>\r\n	<tr>\r\n		<td><a href=\"home.jsp\">Main Menu</a></td>\r\n		<td><a href=\"tweetSearch.jsp\">Search Tweets</a></td>\r\n		<td><a href=\"profile.jsp\">View my Profile</a></td>\r\n		<td><a href=\"logout\">Logout</a></td>\r\n	</tr>\r\n</table>\r\n\r\n<hr class=\"auto-style2\" noshade=\"noshade\" style=\"height: 3\">\r\n\r\n</body>\r\n\r\n</html>\r\n\r\n<html>\r\n<head>\r\n\r\n<title>Search</title>\r\n<link href=\"stylesheet.css\" rel=\"stylesheet\" type=\"text/css\">\r\n</head>\r\n<body>\r\n<h1>Search Tweets</h1>\r\n\r\n<p>To search for a tweet enter the whole tag or part of the tag in the box below.</p>\r\n<p>If you wish to view all the tweets then simply press submit</p>\r\n\r\n<form action =\"searchTweetResults.jsp\" method=\"post\">\r\n<p>Tag:&nbsp;&nbsp;&nbsp;\r\n<input name=\"search\" type=\"text\" ></p>\r\n<p><input name=\"Submit1\" type=\"submit\" value=\"submit\"></p>&nbsp;\r\n</form>\r\n</body>\r\n</html>\r\n".toCharArray();
  }
}
