package com.ohgiraffers.listener.section02.sessionlistener;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener, HttpSessionAttributeListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
//        HttpSessionListener.super.sessionCreated(se);
        System.out.println("session create");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
//        HttpSessionListener.super.sessionDestroyed(se);
        System.out.println("session destroy");
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
//        HttpSessionAttributeListener.super.attributeAdded(event);
        System.out.println("session attribute add");
        System.out.println("session에 추가된 attr: " + event.getSession() + ", value: " + event.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
//        HttpSessionAttributeListener.super.attributeRemoved(event);
        System.out.println("session attribute remove");
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
//        HttpSessionAttributeListener.super.attributeReplaced(event);
        System.out.println("session attribute replace");
    }



}
