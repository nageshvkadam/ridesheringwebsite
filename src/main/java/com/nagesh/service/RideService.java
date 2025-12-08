package com.nagesh.service;

import com.nagesh.entity.Ride;
import com.nagesh.repository.RideDAO;

public class RideService {
    private RideDAO rideDAO = new RideDAO();

    public void bookRide(Ride ride) {
        rideDAO.saveRide(ride);
    }
}
