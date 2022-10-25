package jspclass;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class Submit extends TagSupport {
    String submitContent = "<input type='submit' value='ok' />" + " <input type='button' value='close' />";

    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            out.print(submitContent);
        } catch (IOException e) {
            System.out.println("jspclass.Submit:" + e);
        }
        return SKIP_BODY;
    }
}