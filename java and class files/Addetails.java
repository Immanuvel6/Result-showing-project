import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class Addetails
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
    	PreparedStatement ps=con.prepareStatement("insert into admindet(name,Age,Dob,username,pass,mobilono) values(?,?,?,?,?,?)");
        String t1=request.getParameter("t1");
	int t2=Integer.parseInt(request.getParameter("t2"));
	String t3=request.getParameter("t3");
 	String t4=request.getParameter("t4");
	String t5=request.getParameter("t5");
	String t6=request.getParameter("t6");

	ps.setString(1,t1);ps.setInt(2,t2);ps.setString(3,t3);
	ps.setString(4,t4);ps.setString(5,t5);ps.setString(6,t6);

	ps.executeUpdate();
	con.commit();
	con.close();	
	//out.println("<a href=http://localhost:8080/Hykin/hello.html>Back</a>")

	response.sendRedirect("http://localhost:8080/Stu/adminlog.html");
	}
	catch(Exception e)
	{out.println(e);}
}
}