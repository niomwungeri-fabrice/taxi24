package com.taxi24.dao;


import com.taxi24.models.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TripRepo extends JpaRepository<Trip, UUID> {
    public List<Trip> findByIsCompleteFalse();
}
