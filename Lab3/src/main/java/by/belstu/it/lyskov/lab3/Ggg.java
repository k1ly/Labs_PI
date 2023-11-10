package by.belstu.it.lyskov.lab3;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

public class Ggg extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        PrintWriter writer = resp.getWriter();
        switch (req.getParameter("request")) {
            case "forwardToPage":
                req.getRequestDispatcher("page.html").forward(req, resp);
                break;
            case "redirectToPage":
                resp.sendRedirect("page.html");
                break;
            case "httpClient":
                writer.println("Parameters: " + req.getParameterMap().entrySet().stream()
                        .map(entry -> entry.getKey() + " = " + String.join(", ", entry.getValue()))
                        .collect(Collectors.joining(", ")));
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