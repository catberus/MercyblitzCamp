package org.geektimes.projects.user.context;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import java.rmi.Naming;
import java.util.NoSuchElementException;

public class ComponentContext {

    public static final String CONTEXT_NAME= ComponentContext.class.getName();

    private Context context;


    // 利用servletContext使其变为全局上下文
    private static ServletContext servletContext;

    public static void setServletContext(ServletContext servletContext) {
        ComponentContext.servletContext = servletContext;
    }

    public static ComponentContext getInstance(){
        return (ComponentContext) servletContext.getAttribute(CONTEXT_NAME);
    }


    public void init(ServletContext servletContext) throws RuntimeException {

        try {
            this.context = (Context) new InitialContext().lookup("java:comp/env");
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }

        //保存servletContext的引用
        servletContext.setAttribute(CONTEXT_NAME,this);
        ComponentContext.servletContext = servletContext;
    }

    public void destory() throws RuntimeException {
        if (this.context != null) {
            try {
                context.close();
            } catch (NamingException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public <C> C getComponent(String name) {
        C component = null;
        try {
            component = (C) context.lookup(name);
        } catch (NamingException e) {
            throw new NoSuchElementException(e.getMessage());
        }
        return component;
    }
}
