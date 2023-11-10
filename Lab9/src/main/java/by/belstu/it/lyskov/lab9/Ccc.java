package by.belstu.it.lyskov.lab9;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class Ccc extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CBean requestAtrCBean = (CBean) req.getAttribute("atrCBean");
        CBean sessionAtrCBean = (CBean) req.getSession().getAttribute(req.getSession().getId());
        if (requestAtrCBean == null || (req.getParameter("CBean") != null && req.getParameter("CBean").equals("new"))) {
            requestAtrCBean = new CBean();
            req.setAttribute("atrCBean", requestAtrCBean);
        }
        if (sessionAtrCBean == null || (req.getParameter("CBean") != null && req.getParameter("CBean").equals("new"))) {
            sessionAtrCBean = new CBean();
            req.getSession().setAttribute(req.getSession().getId(), sessionAtrCBean);
        }
        if (req.getParameter("Value1") != null && !req.getParameter("Value1").isEmpty()) {
            requestAtrCBean.setValue1(req.getParameter("Value1"));
            sessionAtrCBean.setValue1(req.getParameter("Value1"));
        }
        if (req.getParameter("Value2") != null && !req.getParameter("Value2").isEmpty()) {
            requestAtrCBean.setValue2(req.getParameter("Value2"));
            sessionAtrCBean.setValue2(req.getParameter("Value2"));
        }
        if (req.getParameter("Value3") != null && !req.getParameter("Value3").isEmpty()) {
            requestAtrCBean.setValue3(req.getParameter("Value3"));
            sessionAtrCBean.setValue3(req.getParameter("Value3"));
        }
        req.getRequestDispatcher("Ccc.jsp").forward(req, resp);
    }
}