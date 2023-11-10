package by.belstu.it.lyskov.lab11;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

public class Sss_Header extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(getClass().getSimpleName() + ":doGet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(getClass().getSimpleName() + ":doPost");
        System.out.println("Value-X = " + req.getHeader("Value-X"));
        System.out.println("Value-Y = " + req.getHeader("Value-Y"));
        Float x = Float.parseFloat(req.getHeader("Value-X"));
        Float y = Float.parseFloat(req.getHeader("Value-Y"));
        float z = x + y;
        System.out.println("Value-Z = " + z);
        resp.setHeader("Value-Z", Float.toString(z));
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}