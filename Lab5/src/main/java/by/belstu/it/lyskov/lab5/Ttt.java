package by.belstu.it.lyskov.lab5;

import java.io.*;
import java.util.stream.Collectors;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

public class Ttt extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.println("Parameters: " + req.getParameterMap().entrySet().stream()
                .map(entry -> entry.getKey() + "=" + String.join(", ", entry.getValue()))
                .collect(Collectors.joining(", ")));
    }
}