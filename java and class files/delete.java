import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;


public class delete extends HttpServlet {

    private static final String DB_URL = "jdbc:ucanaccess://d:\\Resultshow.accdb";
    private static final String DB_USER = "Regno";
    private static final String DB_PASSWORD = "dob";

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String t1 = request.getParameter("t1");
        String t2 = request.getParameter("t2");

        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            // Check if the email and password exist in the database
            String selectQuery = "SELECT * FROM Studentdetails WHERE Regno = ? AND dob = ?";
            try (PreparedStatement selectStmt = conn.prepareStatement(selectQuery)) {
                selectStmt.setString(1, t1);
                selectStmt.setString(2, t2);
                ResultSet rs = selectStmt.executeQuery();

                if (rs.next()) {
                    // Data exists, proceed to delete
                    String deleteQuery = "DELETE FROM Studentdetails WHERE Regno = ? AND dob = ?";
                    try (PreparedStatement deleteStmt = conn.prepareStatement(deleteQuery)) {
                        deleteStmt.setString(1, t1);
                        deleteStmt.setString(2, t2);
                        int rowsAffected = deleteStmt.executeUpdate();
                        
                        if (rowsAffected > 0) {
			   response.sendRedirect("http://localhost:8080/Stu/deleted.html");
                        } else {     response.sendRedirect("http://localhost:8080/Stu/error.html");
                        }
                    }
                } else {  response.sendRedirect("http://localhost:8080/Stu/error.html");
                }
            }
        } catch (SQLException e) {
            throw new ServletException("Database access error", e);
        }
    }
}