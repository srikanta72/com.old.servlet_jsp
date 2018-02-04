package pack1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
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
		String str= request.getParameter("s");
		String engine=request.getParameter("engine");
		try {
			if (str.trim().length()==0)
				throw new Exception();
			if (engine==null)
				throw new Exception();
			String url="";
			if (engine.equals("google"))
			{
				url="http://www.google.co.in/#q="+str;
			}
			else if (engine.equals("yahoo"))
			{
				url="http://in.search.yahoo.com/search?p="+str;
			}
			else 
			{
				url="http://www.bing.com/search?q="+str;
			}
			response.sendRedirect(url);
		}
		catch(Exception e)
		{
			response.sendRedirect("error.html");
		}
	}

}
