package by.belstu.it.lyskov.lab11;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class Sss_JSON extends HttpServlet {

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
        resp.setContentType("text/json");
        StringBuilder json = new StringBuilder("{\"X\":[");
        for (int i = 0; i < 10; i++) {
            json.append("{\"rand\":").append(num.getNumber().toString()).append("}").append((i < 9) ? "," : " ");
        }
        json.append("]}");
        writer.print(json);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}