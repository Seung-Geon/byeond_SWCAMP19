package com.ohgiraffers.listener.section01.contextlistener;

import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener, ServletContextAttributeListener {
    public ContextListener() {
        System.out.println("ContextListener created");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
//        ServletContextListener.super.contextInitialized(sce);
        System.out.println("context Init!!");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
//        ServletContextListener.super.contextDestroyed(sce);
        System.out.println("context Destroy!!");
    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
//        ServletContextAttributeListener.super.attributeAdded(event);
        System.out.println("attribute add!!: " + event.getName());
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
//        ServletContextAttributeListener.super.attributeRemoved(event);
        System.out.println("attribute remove!!");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
//        ServletContextAttributeListener.super.attributeReplaced(event);
        System.out.println("attribute replace!!");
    }
}
