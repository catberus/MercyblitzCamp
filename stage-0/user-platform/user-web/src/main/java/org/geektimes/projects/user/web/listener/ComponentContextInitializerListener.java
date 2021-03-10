package org.geektimes.projects.user.web.listener;

import org.geektimes.projects.user.context.ComponentContext;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@WebListener
public class ComponentContextInitializerListener implements ServletContextListener {

    private ServletContext servletContext;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        this.servletContext = sce.getServletContext();
        //创建应用上下文，并放入servletContext
        ComponentContext context = new ComponentContext();
        context.init(servletContext);
//        servletContext.setAttribute(ComponentContext.CONTEXT_NAME, context);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ComponentContext context = (ComponentContext)servletContext.getAttribute(ComponentContext.CONTEXT_NAME);
        context.destory();
    }

}
