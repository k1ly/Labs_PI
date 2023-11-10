package by.belstu.it.lyskov.lab12;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

public class Sss extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Servlet:SSS");
    }
}