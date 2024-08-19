import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;


public class result extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        // Get the regno and dob from the form
        String t1 = request.getParameter("t1");
        String t2 = request.getParameter("t2");


        // JDBC setup
        String jdbcURL = "jdbc:ucanaccess://d:\\Resultshow.accdb";
        
        String query = "SELECT * FROM Studentdetails WHERE Regno = ? AND dob = ?";

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

	 		out.println("<!DOCTYPE html><html>");
    			out.println("<head>");
        		out.println("<title>result</title>");
    			out.println("</head>");

    			out.println("<body style=\"background-color: cyan;\">");


        try {
            // Load JDBC driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            // Establish connection
            Connection connection = DriverManager.getConnection(jdbcURL);

            // Create a prepared statement
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, t1);
            statement.setString(2, t2);

            // Execute the query
            ResultSet ps = statement.executeQuery();

            if (ps.next()) {
               
				out.println("<center>");

                		out.println("Name:"+ps.getString(1)); 
				out.println("<br>");
				out.println("Dob :"+ps.getString(2));
				out.println("<br>"); 
				out.println("Reg No :"+ps.getInt(3)); 
				out.println("<br>");
				out.println(ps.getString(4)+":"+ps.getInt(5));
				out.println("<br>"); 
				out.println(ps.getString(6)+":"+ps.getInt(7));
				out.println("<br>"); 	
				out.println(ps.getString(8)+":"+ps.getInt(9));
				out.println("<br>"); 
				out.println(ps.getString(10)+":"+ps.getInt(11));			
				out.println("<br>");
				out.println(ps.getString(12)+":"+ps.getInt(13));
				out.println("<br>");
				out.println(ps.getString(14)+":"+ps.getInt(15));
				out.println("<br>");
				out.println("Tottal:"+ps.getInt(16));
				out.println("<br>");
				out.println("Result :"+ps.getString(17));
			
				out.println("</center>");

            } else {
                // If the record is not found, output failure
		out.println("<center>");
                out.println("<h1>Verification Failed</h1>");
		out.println("<br>");
                out.println("<p>Registration Number or Date of Birth is incorrect.</p>");		
		out.println("<br>");
		out.println("<a href=http://localhost:8080/Stu/index.html><input type=button value=back></a>");
		out.println("</center>");
            }

            // Close the resources
            ps.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<h1>Error: " + e.getMessage() + "</h1>");
        } finally {
            out.close();
        }
    }
}