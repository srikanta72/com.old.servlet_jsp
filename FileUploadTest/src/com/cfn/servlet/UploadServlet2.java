package com.cfn.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UploadServlet2
 */
@WebServlet("/srv1")
public class UploadServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		DiskFileItemFactory itemFactory= new DiskFileItemFactory();
		ServletFileUpload upload=new ServletFileUpload(itemFactory);
		try
		{
			List list= upload.parseRequest(request);
			Iterator it=list.iterator();
			while (it.hasNext())
			{
				FileItem fi=(FileItem)it.next();
				if(fi.isFormField()==false)
				{
					if(!fi.getContentType().equals("text/xml"))
					{
						throw new Exception();
					}
					if (fi.getSize()==0)
					{
						throw new Exception();
					}
					String fileName=fi.getName();
					ServletContext ctx= getServletContext();
					String path= ctx.getInitParameter("location");
					File file=new File(path+"/"+fileName);
					fi.write(file);
					out.println("file Uploaded sucessfully");
				}
			}
		}
		catch (Exception e)
		{
			out.println("<font color='red'>You must choose xml files only and file should not be empty</font>");
			out.println("<hr>");
			RequestDispatcher rd= request.getRequestDispatcher("index.html");
			rd.include(request, response);
		}
		out.close();
	}

}
