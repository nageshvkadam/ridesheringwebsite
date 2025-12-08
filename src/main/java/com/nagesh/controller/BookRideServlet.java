package com.nagesh.controller;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

import com.nagesh.entity.Ride;
import com.nagesh.service.RideService;

@WebServlet("/bookRide")
public class BookRideServlet extends HttpServlet {
    private RideService rideService = new RideService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String pickup = request.getParameter("pickup_location");
        String drop = request.getParameter("drop_location");
        String date = request.getParameter("ride_date");
        String time = request.getParameter("ride_time");
        String cabType = request.getParameter("cab_type");
        int passengers = Integer.parseInt(request.getParameter("passengers"));

        Ride ride = new Ride();
        ride.setPickupLocation(pickup);
        ride.setDropLocation(drop);
        ride.setRideDate(date);
        ride.setRideTime(time);
        ride.setCabType(cabType);
        ride.setPassengers(passengers);

        rideService.bookRide(ride);

        response.getWriter().println("✅ Ride booked successfully using JPA!");
    }
}
