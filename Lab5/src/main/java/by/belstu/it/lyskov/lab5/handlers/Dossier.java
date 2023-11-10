package by.belstu.it.lyskov.lab5.handlers;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.TagSupport;

import java.io.IOException;

public class Dossier extends TagSupport {

    private String action = "";

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public int doStartTag() throws JspException {
        JspWriter writer = pageContext.getOut();
        try {
            writer.println("<form action=\"" + getAction() + "\" method=\"post\">");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return EVAL_BODY_INCLUDE;
    }

    @Override
    public int doEndTag() throws JspException {
        JspWriter writer = pageContext.getOut();
        try {
            writer.println("</form>");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return EVAL_BODY_INCLUDE;
    }
}
