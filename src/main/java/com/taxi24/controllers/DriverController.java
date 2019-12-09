/**
 * 
 */
package com.taxi24.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.taxi24.dao.DriverRepo;
import com.taxi24.models.Driver;
import com.taxi24.utils.DriverUtils;

/**
 * @author niyomwungeri
 *
 */
@RestController
public class DriverController {
	
	@Autowired
	DriverRepo driverRepo;
	
	@GetMapping("/drivers/available")
	public List<Driver> getAvailable(){
		return driverRepo.findByIsAvailableTrue(); 
	}
	
	@GetMapping("/drivers/{kilometers}/available")
	public List<Driver> availableWithIn3KM(
			@PathVariable(value = "kilometers") String kilometers, 
			@RequestParam(name = "latitude") String latitude, 
			@RequestParam(name = "longitude") String longitude,
			@RequestParam(name = "unit", required = false) String unit){

		List<Driver> driversWithInRange = new ArrayList<Driver>();
	
		for (Driver driver : driverRepo.findByIsAvailableTrue()) {
			String[] location = driver.getLocation().split(",");
			if(DriverUtils.distance(
					Double.parseDouble(location[0]), 
					Double.parseDouble(location[1]), 
					Double.parseDouble(latitude), 
					Double.parseDouble(longitude), unit) <= Double.parseDouble(kilometers)) {
				driversWithInRange.add(driver);
			}
		}
		return driversWithInRange;
	}
}
