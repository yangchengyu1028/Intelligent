package com.novo.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Log4jlistener implements ServletContextListener {
    final static String LOG4J_HOME = "log4j.home";
    final static String ENV_HOME = "LOG4J_HOME";
        
    public void contextDestroyed(ServletContextEvent servletcontextevent) {
        System.getProperties().remove(LOG4J_HOME);
    }
    
    public void contextInitialized(ServletContextEvent servletcontextevent) {
        String logsHome = System.getenv(ENV_HOME);
        if(logsHome == null){
            logsHome = System.getProperty("catalina.home")+"/log4j";
        }
        System.out.println("*********log4j dir:"+logsHome);
        System.setProperty(LOG4J_HOME, logsHome);
    }
}