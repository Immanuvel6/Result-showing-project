import java.sql.*;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class Studdet extends HttpServlet 
{

    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
	      response.setContentType("text/html");
              PrintWriter out = response.getWriter();

	try
	{
	String t17="";
    	Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
    	Connection con=DriverManager.getConnection("jdbc:ucanaccess://d:\\Resultshow.accdb");
    	PreparedStatement ps=con.prepareStatement("insert into Studentdetails(name,dob,Regno,Subn1,Sub1,Subn2,Sub2,Subn3,Sub3,Subn4,Sub4,Subn5,Sub5,Subn6,Sub6,Total,Res) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        	
	String t1=request.getParameter("t1");
	String t2=request.getParameter("t2");
	int t3=Integer.parseInt(request.getParameter("t3"));
	String t4=request.getParameter("t4");		
 	int t5=Integer.parseInt(request.getParameter("t5"));
	String t6=request.getParameter("t6");		
	int t7=Integer.parseInt(request.getParameter("t7"));
	String t8=request.getParameter("t8");
 	int t9=Integer.parseInt(request.getParameter("t9"));
	String t10=request.getParameter("t10");		
	int t11=Integer.parseInt(request.getParameter("t11"));
	String t12=request.getParameter("t12");			
	int t13=Integer.parseInt(request.getParameter("t13"));
	String t14=request.getParameter("t14");
	int t15=Integer.parseInt(request.getParameter("t15"));
	int t16=t5+t7+t9+t11+t13+t15;
	if(t5>34 && t7>34 && t9>34 && t11>34 && t13>34 && t15>34)
	
		t17="pass";

	else
		t17="faill";

	ps.setString(1,t1);ps.setString(2,t2);ps.setInt(3,t3);
	ps.setString(4,t4);ps.setInt(5,t5);ps.setString(6,t6);
	ps.setInt(7,t7);ps.setString(8,t8);ps.setInt(9,t9);ps.setString(10,t10);
	ps.setInt(11,t11);ps.setString(12,t12);ps.setInt(13,t13);ps.setString(14,t14);
	ps.setInt(15,t15);ps.setInt(16,t16);ps.setString(17,t17);

	ps.executeUpdate();
	con.commit();
	con.close();	
	//out.println("<a href=http://localhost:8080/Hykin/hello.html>Back</a>")

	response.sendRedirect("http://localhost:8080/Stu/insert.html");
	}
	catch(Exception e)
	{out.println(e);}
}
}