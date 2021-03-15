package com.Driver.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.Driver.Models.Chalaan;
import com.Driver.Models.DriverModel;

@Service
public class DriverService {

	private static List<DriverModel> list = new ArrayList<>();

	static {
		list.add(new DriverModel("Shubham", "8570671673", "XYZ", "10-05-2014", "XCVD123",
				new ArrayList<Chalaan>(Arrays.asList(new Chalaan("600", "unpaid", "Shub@123", "01-01-2021")))));
	}

	public String register(DriverModel driverModel) {
		list.add(driverModel);
		return "you have Been Sucessfully Saved to our test DB, have Good times";

	}

	public List<DriverModel> getAllDrivers() {
		return list;
	}

	public DriverModel getDriver(String mobNo) {

//		Stream<DriverModel> driver = list.stream().filter(p -> p.getMobNo().equals(mobNo));
//
//		return (DriverModel) driver;

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

	public String isWarning(String MobNo, String ChalannNo) throws Exception {
		Date warningChalaanDate = new Date();
		for (DriverModel driver : list) {
			if (driver.getMobNo().equals(MobNo)) {
				List<Chalaan> chalaan = driver.getChalaan();
				for (Chalaan ch : chalaan) {
					if (ch.getChallanNumber().equals(ChalannNo)) {
						String dateOfChalaanUnParsed = ch.getDateOfChalaan();
						Date date = new SimpleDateFormat("dd-MM-yyyy").parse(dateOfChalaanUnParsed);
						Calendar cal = Calendar.getInstance();
						cal.setTime(date);
						cal.add(Calendar.DAY_OF_MONTH, 45);
						warningChalaanDate = cal.getTime();
						if (new Date().compareTo(warningChalaanDate) > 0) {
							double chalaanAmount = Double.parseDouble(ch.getChallanAmount());
							double newChalaanAmount = chalaanAmount + (chalaanAmount * 0.01);
							ch.setChallanAmount(String.valueOf(newChalaanAmount));
							return "Since, You have Not paid your Chalaan Amount." + "\n"
									+ "The New Amount of Chalaan is " + newChalaanAmount + "rs." + "\n"
									+ "The due Date of your Chalaan Was " + warningChalaanDate + ".";
						}

					}
				}
			}
		}

		return "Pay your Chalann before" + warningChalaanDate;
	}

}

// TODO Auto-generated method stub
//List<Chalaan> chalaans = (List<Chalaan>) list.stream().map(p -> p.getChalaan());
//Chalaan chalaan = (Chalaan) chalaans.stream().filter(p -> p.getChallanNumber().equals(ChalannNo));
//SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
//System.out.print(chalaan.getDateOfChalaan());
