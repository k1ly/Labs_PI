package by.belstu.it.lyskov.lab6;

import java.io.*;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

public class UrlnServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        String urln = req.getParameter("urln");
        if (urln != null) {
            ServletContext context = getServletContext();
            String urlnParam = context.getInitParameter("URL" + urln);
            if (urlnParam != null) {
                HttpClient httpClient = new HttpClient();
                GetMethod method = new GetMethod("http://localhost:8080" + req.getContextPath() + "/" + urlnParam);
                httpClient.executeMethod(method);
                writer.println(method.getResponseBodyAsString());
            } else writer.println("initialization parameter URLn not found");
        } else writer.println("parameter URLn not found");
    }
}