package cfn;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class TempServlet
 */
public class TempServlet extends GenericServlet implements Servlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
	DataSource ds;
    public TempServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		try{
			Context initContext= new InitialContext();
			Context envContext= (Context)initContext.lookup("java:/comp/env");
			ds=(DataSource)envContext.lookup("jdbc/myoracle");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {		
		// TODO Auto-generated method stub
		try{
			Connection con=ds.getConnection();
			Statement st= con.createStatement();
			ResultSet rs=st.executeQuery("select empno, ename, sal, deptno from emp");
			response.setContentType("text/html");
			PrintWriter out= response.getWriter();
			out.println("<h1>");
			while(rs.next())
			{
				out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
				out.println("<br>");
			}
			out.println("<h1>");
			out.close();
			st.close();
			con.close();
			rs.close();
		}
		catch( Exception e)
		{
			e.printStackTrace();
		}
	}

}
