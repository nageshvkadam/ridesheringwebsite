package com.nagesh.repository;

import java.io.*;
import java.sql.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Rideservlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String cabType = request.getParameter("cab_type");
        String dropLocation = request.getParameter("drop_location");
        int passengers = Integer.parseInt(request.getParameter("passengers"));
        String pickupLocation = request.getParameter("pickup_location");
        String rideDate = request.getParameter("ride_date");
        String rideTime = request.getParameter("ride_time");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/your_db", "root", "your_password");

            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO ride (cab_type, drop_location, passengers, pickup_location, ride_date, ride_time) VALUES (?, ?, ?, ?, ?, ?)");
            ps.setString(1, cabType);
            ps.setString(2, dropLocation);
            ps.setInt(3, passengers);
            ps.setString(4, pickupLocation);
            ps.setString(5, rideDate);
            ps.setString(6, rideTime);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                response.getWriter().println("Ride booked successfully!");
            } else {
                response.getWriter().println("Failed to book ride.");
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
