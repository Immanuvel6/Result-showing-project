import java.sql.*;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class view extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
    	throws IOException, ServletException
	{
 		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		try
   		{	 out.println("<!DOCTYPE html><html>");
    			out.println("<head>");
        		out.println("<title>view</title>");
    			out.println("</head>");

    			out.println("<body style=\"background-color: cyan;\">");
   			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
   			Connection con=DriverManager.getConnection("jdbc:ucanaccess://d:\\Resultshow.accdb");
   			Statement st=con.createStatement();
			ResultSet ps=st.executeQuery("select * from Studentdetails");
			int f=1;
			out.println("<center>");
   			while(ps.next())
   			{	
				out.println("<b>Student no:"+f+"</b>");
				out.println("Name:"+ps.getString(1)); 
				out.println("Dob :"+ps.getString(2)); 
				out.println("Reg No :"+ps.getInt(3)); 
				out.println(ps.getString(4)+":"+ps.getInt(5)); 
				out.println(ps.getString(6)+":"+ps.getInt(7)); 	
				out.println(ps.getString(8)+":"+ps.getInt(9)); 
				out.println(ps.getString(10)+":"+ps.getInt(11));
				out.println(ps.getString(12)+":"+ps.getInt(13));
				out.println(ps.getString(14)+":"+ps.getInt(15));
				out.println("Tottal:"+ps.getInt(16));
				out.println("Result :"+ps.getString(17));
				out.println("<br>");
				f++;
   			}out.println("</center>"); 
		out.println("<a href=http://localhost:8080/Stu/AdminHome.html><input type=button value=back></a>");
		out.println("</body");
		
  		}
  		catch(Exception e)
 		{e.printStackTrace();}
 	}
 	
}