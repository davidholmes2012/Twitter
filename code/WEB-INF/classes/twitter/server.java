package twitter;
public class server
{
//database details
String url = "jdbc:mysql://SQL09.FREEMYSQL.NET/twitter2012";
String dbUsername = "dundeetwitter";
String dbPW = "password";
public String getURL()
{
return url;
}
public String getUN()
{
return dbUsername;
}
public String getPW()
{
return dbPW;
}
}