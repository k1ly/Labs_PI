package by.belstu.it.lyskov.lab2;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

public class Sss extends HttpServlet {
    public Sss() {
        super();
        System.out.println(getClass().getSimpleName() + "::constructor");
    }

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println(getClass().getSimpleName() + "::init");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        System.out.println(getClass().getSimpleName() + "::service");
        writer.println(getClass().getSimpleName() + "::service");
        writer.println("Method - " + req.getMethod());
        writer.println("Server name - " + req.getServerName());
        writer.println("IP address - " + req.getLocalAddr());
        writer.println("Parameters: " + req.getParameterMap().entrySet().stream()
                .map(entry -> entry.getKey() + " = " + String.join(", ", entry.getValue()))
                .collect(Collectors.joining(", ")));
        if (req.getMethod().equals("GET"))
            doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        System.out.println(getClass().getSimpleName() + "::doGet");
        writer.println(getClass().getSimpleName() + "::doGet");
        writer.println("URI - " + req.getRequestURL() + "?" + req.getQueryString());
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println(getClass().getSimpleName() + "::destroy");
    }
}