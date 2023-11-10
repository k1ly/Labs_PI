package by.belstu.it.lyskov.lab11;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class Sss_XML extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(getClass().getSimpleName() + ":doGet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        System.out.println(getClass().getSimpleName() + ":doPost");
        Integer n = Integer.parseInt(req.getHeader("XRand-N"));
        System.out.println("N = " + n);
        XXRand num = new XXRand(n);
        resp.setContentType("text/xml");
        StringBuilder xml = new StringBuilder("<?xml version=\"1.0\" encoding=\"utf-8\"?><rand>");
        for (int i = 0; i < 10; i++) {
            xml.append("<num>").append(num.getNumber()).append("</num>");
        }
        xml.append("</rand>");
        System.out.println (xml);
        writer.print(xml);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}