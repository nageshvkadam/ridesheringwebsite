package com.nagesh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nagesh.entity.Ride;
import com.nagesh.entity.UserTrip;
import com.nagesh.repository.Riderepositry;
import com.nagesh.repository.UserTripRepository;

@Controller
public class RideController {

    @Autowired
    private Riderepositry rideRepository;
    private UserTripRepository userTripRepository;
    
    
    @PostMapping("/bookRide")
    @ResponseBody
    public String bookRide(@ModelAttribute Ride ride) {
        rideRepository.save(ride);
        return "Your Ride is Booked Successfully";
    }
    
    @PostMapping("/userTrip")
    @ResponseBody
    public String saveUserTrip(@RequestBody UserTrip userTrip) {
		userTripRepository.save(userTrip);
		return "User Trip details saved successfully";
	}
}









