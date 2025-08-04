package com.cassiopea.world_airlines.listeners;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import com.cassiopea.world_airlines.models.Passenger;

@WebListener
public class AppStartupListener implements ServletContextListener {

    public void contextInitialized ( ServletContextEvent event ) {
        // initialize passengers list :
        List<Passenger> passengers = Collections.synchronizedList( new ArrayList<Passenger>() );
        event.getServletContext().setAttribute("passengers", passengers);
    }

    public void contextDestroyed (ServletContextEvent event ) {

    }

}
