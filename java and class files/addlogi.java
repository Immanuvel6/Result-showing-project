import java.sql.*;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class addlogi
 extends HttpServlet 
{

    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
	      response.setContentType("text/html");
              PrintWriter out = response.getWriter();

	try
	{
    	Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
    	Connection con=DriverManager.getConnection("jdbc:ucanaccess://d:\\Resultshow.accdb");
    	PreparedStatement ps=con.prepareStatement("select username,pass from Admindet where username=? and pass=?");
	out.println("hello");
	String t1=request.getParameter("t1");
	String t2=request.getParameter("t2");
	ps.setString(1,t1);
	ps.setString(2,t2);
	ResultSet y=ps.executeQuery();
	int a=0;
	while(y.next())
	{
	a=1;
	}
	
	
 	if(a==1)
	{
 		response.sendRedirect("http://localhost:8080/Stu/AdminHome.html");
		 
		
	}
	else
	response.sendRedirect("http://localhost:8080/Stu/adminlog.html");
	
	con.commit();
	con.close();	
	}
	catch(Exception e)
	{out.println(e);}
}
}