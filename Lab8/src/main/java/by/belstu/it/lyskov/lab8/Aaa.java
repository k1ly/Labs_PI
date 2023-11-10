package by.belstu.it.lyskov.lab8;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Aaa extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        HttpClient httpClient = new HttpClient();
        PostMethod method = new PostMethod("http://localhost:8080" + req.getContextPath() + "/GoBbb");
        method.addParameter("X-A1", "1");
        method.addParameter("X-A2", "2");
        method.addParameter("X-A3", "3");
        method.addRequestHeader("X-A1", "1");
        method.addRequestHeader("X-A2", "2");
        method.addRequestHeader("X-A3", "3");
        httpClient.executeMethod(method);
        writer.println(method.getResponseBodyAsString());
        writer.println("Response headers:\n" + Arrays.stream(method.getResponseHeaders())
                .map(element -> element.getName() + " = " + String.join(", ", element.getValue()))
                .collect(Collectors.joining(";\n")));
        Arrays.stream(method.getResponseHeaders()).forEach((header -> resp.addHeader(header.getName(), header.getValue())));
    }
}