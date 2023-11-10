package by.belstu.it.lyskov.lab4;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

public class AfternoonServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("Servlet: Good afternoon");
    }
}