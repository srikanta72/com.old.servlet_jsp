package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RegisterServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String username= request.getParameter("uname");
		String password= request.getParameter("pwd");
		String confirmPassword= request.getParameter("cpwd");
		if (confirmPassword.equals(password))
		{
			String encryptedPassword=BCrypt.hashpw(password,BCrypt.gensalt());
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
				PreparedStatement pstmt= con.prepareStatement("insert into login values (?,?)");
				pstmt.setString(1, username);
				pstmt.setString(2, encryptedPassword);
				pstmt.executeUpdate();
				pstmt.close();
				con.close();
				out.println("Registered Succesfully");
			}
			catch (Exception e )
			{
				e.printStackTrace();
			}			
	}
		else
		{
			out.println("<font color='red' size=7> Sorry Confirm Password doesn't match with Password</font>");
		}
		out.println("<br>");
		out.println("<a href=index.html> Home</a>");
		out.close();
	}
}
