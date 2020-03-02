package com.taxi24.controllers;

import com.taxi24.dao.DriverRepo;
import com.taxi24.dao.RiderRepo;
import com.taxi24.dao.TripRepo;
import com.taxi24.models.Driver;
import com.taxi24.models.Rider;
import com.taxi24.models.Trip;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class TripController {

    @Autowired
    private TripRepo tripRepo;

    @Autowired
    private DriverRepo driverRepo;

    @Autowired
    private RiderRepo riderRepo;

    @PostMapping("/trip/new")
    public Trip createTrip(@RequestBody String tripBody) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(tripBody);
        UUID driverId = UUID.fromString((String)json.get("driverId"));
        UUID riderId = UUID.fromString((String)json.get("riderId"));
        Driver driver = driverRepo.getOne(driverId);
        Rider rider = riderRepo.getOne(riderId);
        Trip trip = new Trip();
        trip.setCost((Long) json.get("cost"));
        trip.setDeparture((String)json.get("departure"));
        trip.setDestination((String)json.get("destination"));
        trip.setDriver(driver);
        trip.setRider(rider);
        return tripRepo.save(trip);
    }

    @GetMapping("/trip/{tripId}")
    public Trip findOneTrip(@PathVariable(value = "tripId") String tripId){
        UUID trip = UUID.fromString(tripId);
        return tripRepo.getOne(trip);
    }
}
