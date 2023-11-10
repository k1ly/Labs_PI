package by.belstu.it.lyskov.lab3;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

import java.io.IOException;
import java.io.PrintWriter;

public class Sss extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        PrintWriter writer = resp.getWriter();
        switch (req.getParameter("request")) {
            case "forwardToServlet":
            case "forwardToPage":
                req.getRequestDispatcher("GoGgg").forward(req, resp);
                break;
            case "redirectToServlet":
            case "redirectToPage":
                resp.sendRedirect("GoGgg");
                break;
            case "httpClient":
                HttpClient httpClient = new HttpClient();
                HttpMethod method = null;
                switch (req.getMethod()) {
                    case "GET":
                        method = new GetMethod("http://localhost:8080" + req.getContextPath() + "/GoGgg?request=httpClient&firstname=kirill&lastname=lyskov");
                        break;
                    case "POST":
                        method = new PostMethod("http://localhost:8080" + req.getContextPath() + "/GoGgg");
                        ((PostMethod) method).addParameter("request", "httpClient");
                        ((PostMethod) method).addParameter("firstname", "kirill");
                        ((PostMethod) method).addParameter("lastname", "lyskov");
                        break;
                }
                if (method != null) {
                    httpClient.executeMethod(method);
                    writer.println(method.getResponseBodyAsString());
                }
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        System.out.println(getClass().getSimpleName() + "::doGet");
        writer.println(getClass().getSimpleName() + "::doGet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        System.out.println(getClass().getSimpleName() + "::doPost");
        writer.println(getClass().getSimpleName() + "::doPost");
    }
}