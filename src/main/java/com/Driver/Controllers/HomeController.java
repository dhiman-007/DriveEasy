package com.Driver.Controllers;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Driver.Models.Chalaan;
import com.Driver.Models.DriverModel;
import com.Driver.Service.DriverService;

@RestController
public class HomeController {

	Logger logger = org.slf4j.LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private DriverService DriverService;

	@PostMapping("/register")
	public String register(@RequestBody DriverModel driverModel) {
		logger.info("Inside register Controller");
		return DriverService.register(driverModel);
	}

	@GetMapping("/drivers")
	public List<DriverModel> getAllDrivers() {
		logger.info("Inside getAllDrivers Controller");
		return DriverService.getAllDrivers();

	}

	@GetMapping("driver/profile/{MobNo}")
	public DriverModel getDriver(@PathVariable String MobNo) {
		logger.info("Inside getDriver Controller");
		return DriverService.getDriver(MobNo);

	}

	@PostMapping("driver/fillChalaan/{MobNo}")
	public void fillChalaan(@RequestBody Chalaan chalaan, @PathVariable String MobNo) {
		logger.info("Inside fillChalaan Controller");
		DriverService.fillChalaan(chalaan, MobNo);
	}

	@PostMapping("/driver/payChalaan/{MobNo}/{ChalaanNo}")
	public void payChalaan(@PathVariable String MobNo, @PathVariable String ChalaanNo) {
		logger.info("Inside payChalaan Controller");
		DriverService.payChalaan(MobNo, ChalaanNo);
	}

	@PutMapping("/driver/updateProfile/{MobNo}")
	public DriverModel UpdateYourDetails(@RequestBody DriverModel driverModel, @PathVariable String MobNo) {
		logger.info("Inside updateYourProfile Controller");
		return DriverService.updateYourDetails(driverModel, MobNo);
	}

}
