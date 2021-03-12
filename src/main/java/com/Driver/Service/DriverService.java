package com.Driver.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import com.Driver.Models.Chalaan;
import com.Driver.Models.DriverModel;

@Service
public class DriverService {

	Logger logger = org.slf4j.LoggerFactory.getLogger(DriverService.class);

	private static List<DriverModel> list = new ArrayList<>();

	static {
		list.add(new DriverModel("Shubham", "8570671673", "XYZ", "10-05-2014", "XCVD123",
				new ArrayList<Chalaan>(Arrays.asList(new Chalaan("600", "unpaid", "Shub@123", "12-05-19")))));
	}

	public String register(DriverModel driverModel) {
		list.add(driverModel);
		return "you have Been Sucessfully Saved to our test DB, have Good times";

	}

	public List<DriverModel> getAllDrivers() {
		return list;
	}

	public DriverModel getDriver(String mobNo) {
		DriverModel driver;
		for (int i = 0; i < list.size(); i++) {
			driver = list.get(i);
			if (driver.getMobNo().equals(mobNo)) {
				return driver;
			}
		}
		return null;
	}

	public void fillChalaan(Chalaan chalaan, String mobNo) {
		DriverModel driver;
		for (int i = 0; i < list.size(); i++) {
			driver = list.get(i);
			if (driver.getMobNo().equals(mobNo)) {
				List<Chalaan> chalanData = driver.getChalaan();
				chalanData.add(chalaan);
				System.out.print("Your Challans has Been Updated");
				return;
			}

		}
		System.out.println("No Driver found with Given Credentials");
	}

	public void payChalaan(String mobNo, String chalaanNo) {
		DriverModel driver;
		for (int i = 0; i < list.size(); i++) {
			driver = list.get(i);
			if (driver.getMobNo().equals(mobNo)) {
				List<Chalaan> chalanData = driver.getChalaan();
				for (int j = 0; j < chalanData.size(); j++) {
					if (chalanData.get(j).getChallanNumber().equals(chalaanNo)) {
						Chalaan chal = chalanData.get(j);
						chal.setChalaanStatus("paid");
						chal.setChallanAmount("0");
						System.out.print("Your Payemt is Successful. You Paid for Your Chalaan");
						return;
					}
				}
			}
		}
		System.out.println("No Driver found with Given Credentials");
	}

	public DriverModel updateYourDetails(DriverModel driverModel, String mobNo) {

		DriverModel driver;
		for (int i = 0; i < list.size(); i++) {
			driver = list.get(i);
			if (driver.getMobNo().equals(mobNo)) {
				driver.setDname(driverModel.getDname());
				driver.setMobNo(driverModel.getMobNo());
				return driver;
			}

		}
		return null;
	}

}
