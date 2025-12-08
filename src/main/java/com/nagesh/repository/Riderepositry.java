package com.nagesh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagesh.entity.Ride;

public interface Riderepositry extends JpaRepository<Ride, Long> {
}
