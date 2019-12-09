/**
 * 
 */
package com.taxi24.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taxi24.dao.DriverRepo;
import com.taxi24.models.Driver;

/**
 * @author niyomwungeri
 *
 */
@RestController
public class DriverController {
	
	@Autowired
	private DriverRepo driverRepo;
	
	@GetMapping("/drivers/available")
	public List<Driver> getAvailable(){
		return driverRepo.findByIsAvailableTrue(); 
	}
}
