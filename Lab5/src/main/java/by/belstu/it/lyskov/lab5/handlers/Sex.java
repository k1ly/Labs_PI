package by.belstu.it.lyskov.lab5.handlers;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.TagSupport;

import java.io.IOException;

public class Sex extends TagSupport {

    @Override
    public int doStartTag() throws JspException {
        JspWriter writer = pageContext.getOut();
        try {
            writer.println("<div><label>Sex</label></div>" +
                    "<input id=\"male\" type=\"radio\" name=\"sex\" value=\"male\"/>" +
                    "<label for=\"male\">Male</label>"+
                    "<input id=\"female\" type=\"radio\" name=\"sex\" value=\"female\"/>" +
                    "<label for=\"female\">Female</label>");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return SKIP_BODY;
    }
}