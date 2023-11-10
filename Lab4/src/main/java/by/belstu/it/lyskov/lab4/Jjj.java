package by.belstu.it.lyskov.lab4;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class Jjj extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LocalDateTime date = LocalDateTime.now();
        int hours = date.getHour();
        String partOfDay;
        if (hours <= 5)
            partOfDay = "night";
        else if (hours <= 11)
            partOfDay = "morning";
        else if (hours <= 17)
            partOfDay = "afternoon";
        else partOfDay = "evening";
        req.getRequestDispatcher(partOfDay + ".jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        LocalDateTime date = LocalDateTime.now();
        int hours = date.getHour();
        String partOfDay;
        if (hours <= 5)
            partOfDay = "night";
        else if (hours <= 11)
            partOfDay = "morning";
        else if (hours <= 17)
            partOfDay = "afternoon";
        else partOfDay = "evening";
        HttpClient httpClient = new HttpClient();
        PostMethod method = new PostMethod("http://localhost:8080" + req.getContextPath() + "/" + partOfDay + ".jsp");
        httpClient.executeMethod(method);
        writer.println(method.getResponseBodyAsString());
    }
}