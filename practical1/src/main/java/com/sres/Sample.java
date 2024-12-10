package com.sres;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Sample
 */
@WebServlet("/Sample")
public class Sample extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sample() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Setting the content type to display text in the browser
        response.setContentType("text/html");
        java.io.PrintWriter out = response.getWriter();

        String chParam = request.getParameter("ch");

        if (chParam != null && !chParam.isEmpty()) {
            try {
                int x = Integer.parseInt(chParam);

                // Load MySQL driver
                Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("Driver class is loaded");

                // Establish connection to the MySQL database
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/datab", "root", "");
                
                if (con != null) {
                    System.out.println("Connection established");

                    if (x == 1) {
                        // Insert operation
                        int id = Integer.parseInt(request.getParameter("id"));
                        String name1 = request.getParameter("name");
                        String email = request.getParameter("email"); // Changed to String
                        String mobile1 = request.getParameter("mobile"); // Changed to String
                        
                        PreparedStatement ps = con.prepareStatement("INSERT INTO ass6 (ID, name, email, mobile) VALUES (?, ?, ?, ?)");
                        ps.setInt(1, id);
                        ps.setString(2, name1);
                        ps.setString(3, email); // Set as String
                        ps.setString(4, mobile1); // Set as String

                        int rowAffected = ps.executeUpdate();
                        out.println("<p>Insertion Operation</p>");
                        out.println("<p>The number of rows affected: " + rowAffected + "</p>");
                        ps.close();
                    } else if (x == 2) {
                        // Update operation
                        int id = Integer.parseInt(request.getParameter("id"));
                        String name = request.getParameter("name");

                        PreparedStatement ps = con.prepareStatement("UPDATE ass6 SET name=? WHERE ID=?");
                        ps.setString(1, name);  
                        ps.setInt(2, id);      

                        int rowAffected = ps.executeUpdate();
                        out.println("<p>Update Operation</p>");
                        out.println("<p>The number of rows affected: " + rowAffected + "</p>");
                        ps.close();
                    } else if (x == 3) {
                        // Delete operation
                        int id = Integer.parseInt(request.getParameter("id"));

                        PreparedStatement ps = con.prepareStatement("DELETE FROM ass6 WHERE ID=?");
                        ps.setInt(1, id);  

                        int rowAffected = ps.executeUpdate();
                        out.println("<p>Deletion Operation</p>");
                        out.println("<p>The number of rows affected: " + rowAffected + "</p>");
                        ps.close();
                    } else if (x == 4) {
                        // Select operation
                        PreparedStatement ps = con.prepareStatement("SELECT * FROM ass6");
                        ResultSet rs = ps.executeQuery();

                        out.println("<h3>Student Records</h3>");
                        while (rs.next()) {
                            out.println("<p>Student ID: " + rs.getInt(1) + "</p>");
                            out.println("<p>Student Name: " + rs.getString(2) + "</p>");
                            out.println("<p>Student Email: " + rs.getString(3) + "</p>");
                            out.println("<p>Student Mobile: " + rs.getString(4) + "</p>");
                            out.println("<br>");
                        }

                        rs.close();
                        ps.close();
                    }
                } else {
                    out.println("<p>Connection Failed</p>");
                }

                con.close(); 
            
            } catch (ClassNotFoundException e) {
                out.println("<p>JDBC Driver not found: " + e.getMessage() + "</p>");
            } catch (SQLException e) {
                out.println("<p>SQL Exception: " + e.getMessage() + "</p>");
            }
        } else {
            out.println("<p>Parameter 'ch' is missing or empty</p>");
        }
    }
}