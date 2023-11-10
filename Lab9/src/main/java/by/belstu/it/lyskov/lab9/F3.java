package by.belstu.it.lyskov.lab9;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;

public class F3 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        System.out.println(getClass().getSimpleName() + "::init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        System.out.println(getClass().getSimpleName() + "::doFilter");
        if (request.getParameter("Value3") != null && !request.getParameter("Value3").isEmpty())
            chain.doFilter(request, response);
        else writer.println(getClass().getSimpleName() + "::doFilter");
    }
}
