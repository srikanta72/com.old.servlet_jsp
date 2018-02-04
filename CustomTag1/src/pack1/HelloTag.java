package pack1;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class HelloTag extends TagSupport{
	String username;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public int doStartTag() throws JspException
	{
		try
		{
			JspWriter out=pageContext.getOut();
			out.println("Hello: "+ username +"<br>");
		}
		catch(Exception e)
		{
			
		}
		return SKIP_BODY;
	}
	public int doEndTag() throws JspException
	{
		try{
			JspWriter out=pageContext.getOut();
			out.println("Bye: "+username);
		}
		catch (Exception e)
		{
			
		}
		return EVAL_PAGE;
		//return SKIP_PAGE;
	}
	

}
