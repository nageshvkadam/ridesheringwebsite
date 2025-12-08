package com.nagesh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagesh.entity.UserTrip;

public interface UserTripRepository extends JpaRepository<UserTrip , Long> {

}
