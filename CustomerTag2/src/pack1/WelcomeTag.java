package pack1;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class WelcomeTag extends BodyTagSupport {
	private int count=1;
	public int doStartTag() throws JspException{
		try {
			JspWriter out= pageContext.getOut();
			out.println("Welcome to Body tag <br> ");
		}
		catch(Exception e)
		{}
		return EVAL_BODY_INCLUDE;
	}
	public int doAfterBody() throws JspException
	{
		count++;
		if (count<=2)
		{
			return EVAL_BODY_AGAIN;
		}
		else
		{
			return SKIP_BODY;
		}
	}
	public int doEndTag() throws JspException
	{
		try{
			JspWriter out=pageContext.getOut();
			out.println("Bye bye body tag");
		}
		catch (Exception e){}
		return EVAL_PAGE;
	}
}
