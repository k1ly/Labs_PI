package by.belstu.it.lyskov.lab8;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

public class Bbb extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        resp.addHeader("X-B1","1");
        resp.addHeader("X-B2","2");
        writer.println("Parameters: " + req.getParameterMap().entrySet().stream()
                .map(entry -> entry.getKey() + " = " + String.join(", ", entry.getValue()))
                .collect(Collectors.joining(", ")));
        writer.println("Request headers:\n" + req.getParameterMap().entrySet().stream()
                .map(entry -> entry.getKey() + " = " + String.join(", ", entry.getValue()))
                .collect(Collectors.joining(";\n")));
    }
}