package pack1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SelectServlet
 */
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private String driverClassName, driverUrl, username, password;
       public void init(ServletConfig config) throws ServletException
       {
    	   driverClassName=config.getInitParameter("p1");
    	   driverUrl= config.getInitParameter("p2");
    	   username= config.getInitParameter("p3");
    	   password= config.getInitParameter("p4");
       }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		String tablename=request.getParameter("s");
		try {
			Class.forName(driverClassName);
			Connection con=DriverManager.getConnection(driverUrl, username, password);
			Statement stmt= con.createStatement();
			ResultSet rs= stmt.executeQuery("select * from "+tablename);
			ResultSetMetaData rsmd= rs.getMetaData();
			int count= rsmd.getColumnCount();
			out.println("<center>");
			out.println("<table border=2 bgcolor=red>");
			out.println("<tr>");
			for (int i=1;i<=count; i++)
			{
				out.println("<th>"+rsmd.getColumnName(i)+"</th>");
			}
			out.println("</tr>");
			while (rs.next())
			{
				out.println("<tr>");
				for (int k=1; k<=count;k++)
				{
					out.println("<td>"+rs.getString(k)+"</td>");
				}
				out.println("</tr>");
			}
			out.println("</table>");
			rs.close();
			stmt.close();
			con.close();
			out.println("<br>");
			out.println("<a href=index.html> Home</a>");
			out.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
