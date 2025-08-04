package com.cassiopea.world_airlines.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.cassiopea.world_airlines.enumerations.Gender;
import com.cassiopea.world_airlines.models.Passenger;

/**
 * Servlet implementation class PassengersController
 */
@WebServlet("/PassengersController")
public class PassengersController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PassengersController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter( "action" ) ;

        if ( "add-passenger".equals( action ) ) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/passengers/AddPassenger.jsp");
            dispatcher.forward ( request, response ) ;
        }
        else {

            // get servlet context :
            ServletContext context = this.getServletContext() ;
            // get passengers list from servlet context :
            List<Passenger> passengers = (List<Passenger>) context.getAttribute("passengers");
            request.setAttribute("totalPassengers", passengers.size());

            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/passengers/PassengersList.jsp");
            dispatcher.forward(request, response);
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter( "username" ) ;
        String email = request.getParameter ( "email" ) ;
        String password = request.getParameter ( "password" ) ;
        LocalDate dateOfBirth = LocalDate.parse(request.getParameter("dateOfBirth"));
        String gender = request.getParameter ("gender" ) ;


        // create a new Passenger object :
        Passenger passenger = new Passenger () ;
        passenger.setUsername(username);
        passenger.setEmail(email);
        passenger.setPassword(password);
        passenger.setDateOfBirth ( java.sql.Date.valueOf(dateOfBirth) );
        passenger.setGender(Gender.valueOf(gender.toUpperCase()));

        // initialize a servlet context :
        ServletContext context = this.getServletContext();


        // synchronized operation on passengers list :
        synchronized (this) {

            // save passengers in servlet context :
            List<Passenger> passengers = (List<Passenger>) context.getAttribute ("passengers") ;
            passengers.add(passenger);
            context.setAttribute("passenger", passengers);
        }


        // redirect to the Passengers List page using response.sendRedirect()
        response.sendRedirect("PassengersController");


    }

}
