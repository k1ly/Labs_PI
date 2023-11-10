package by.belstu.it.lyskov.lab9;

import jakarta.servlet.http.*;

public class L2 implements HttpSessionAttributeListener {

    @Override
    public void attributeAdded(HttpSessionBindingEvent sbe) {
        System.out.println(getClass().getSimpleName() + "::attributeAdded");
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent sbe) {
        System.out.println(getClass().getSimpleName() + "::attributeRemoved");
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent sbe) {
        System.out.println(getClass().getSimpleName() + "::attributeReplaced");
    }
}
