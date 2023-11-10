package by.belstu.it.lyskov.lab9;

import jakarta.servlet.*;

public class L1 implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println(getClass().getSimpleName() + "::contextInitialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println(getClass().getSimpleName() + "::contextDestroyed");
    }
}
