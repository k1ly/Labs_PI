package by.belstu.it.lyskov.lab6;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class Ccc extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        getServletContext().setAttribute("atrCBean", new CBean());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CBean atrCBean = (CBean) getServletContext().getAttribute("atrCBean");
        if (req.getParameter("CBean") != null && req.getParameter("CBean").equals("new")) {
            atrCBean = new CBean();
            getServletContext().setAttribute("atrCBean", atrCBean);
        }
        if (req.getParameter("Value1") != null && !req.getParameter("Value1").isEmpty())
            atrCBean.setValue1(req.getParameter("Value1"));
        if (req.getParameter("Value2") != null && !req.getParameter("Value2").isEmpty())
            atrCBean.setValue2(req.getParameter("Value2"));
        if (req.getParameter("Value3") != null && !req.getParameter("Value3").isEmpty())
            atrCBean.setValue3(req.getParameter("Value3"));
        req.getRequestDispatcher("Ccc.jsp").forward(req, resp);
    }
}