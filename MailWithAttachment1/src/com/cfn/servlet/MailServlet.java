package com.cfn.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class MailServlet
 */
@WebServlet("/srv1")
public class MailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MailServlet() {
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
		
		Map<String, String> m=new HashMap<String, String>();
		String fileName="";
		DiskFileItemFactory itemFactory= new DiskFileItemFactory();
		ServletFileUpload upload= new ServletFileUpload(itemFactory);
		try{
			List list=upload.parseRequest(request);
			Iterator it=list.iterator();
			while(it.hasNext())
			{
				FileItem fi=(FileItem)it.next();
				if (fi.isFormField()==false)
				{
					fileName=fi.getName();
					File file=new File("G:"+fileName);
					fi.write(file);
				}
				else
				{
					String s1=fi.getFieldName();
					String s2=fi.getString();
					m.put(s1, s2);
				}
			}
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println(e);
		}
		
		String to=(String)m.get("to");
		String subject=(String)m.get("subject");
		String message=(String)m.get("message");
		Properties prop= new Properties();
		prop.put("mail.smtp.host","smtp.gmail.com");
		prop.put("mail.smtp.port","587");
		prop.put("mail.smtp.auth","true");
		prop.put("mail.smtp.starttls.enable","true");
		try{
			Session session= Session.getInstance(prop, new javax.mail.Authenticator(){
				protected PasswordAuthentication getPasswordAuthentication(){
					return new PasswordAuthentication("sndy60@gmail.com","sandy9178");
				}});
			Message message1= new MimeMessage(session);
			
			MimeBodyPart part1= new MimeBodyPart();
			part1.setText(message);
			
			DataSource ds=new FileDataSource("G:/"+fileName);
			
			MimeBodyPart part2= new MimeBodyPart();
			part2.setDataHandler(new DataHandler(ds));
			part2.setFileName(fileName);
			
			MimeMultipart multi=new MimeMultipart();
			multi.addBodyPart(part1);
			multi.addBodyPart(part2);			
			
			message1.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message1.setSubject(subject);
			message1.setContent(multi);
			Transport t= session.getTransport("smtp");
			
			t.send(message1);
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			out.println("delivered");
			out.close();
	}catch(Exception e){
		e.printStackTrace();
		}
	}
}
