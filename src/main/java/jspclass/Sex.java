package jspclass;
import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class Sex extends TagSupport {
    String sexContent = "<label>jspclass.Sex</label>" +
            "<br/>" +
            "<input name='sex' type='radio' value='male' /> <label>Male</label>" +
            "<br/>" +
            "<input name='sex' type='radio' value='female' /> <label>Female</label>";

    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            out.print(sexContent);
        } catch (IOException e) {
            System.out.println("jspclass.Sex: " + e);
        }
        return SKIP_BODY;
    }
}