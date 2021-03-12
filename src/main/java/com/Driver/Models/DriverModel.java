package com.Driver.Models;

import java.util.List;

public class DriverModel {
	private String Dname;
	private String MobNo;
	private String VehicleNo;
	private String VehicleBuyDate;
	private String LicenceNo;
	private List<Chalaan> chalaan;

	protected DriverModel() {

	}

	public DriverModel(String dname, String mobNo, String vehicleNo, String vehicleBuyDate, String licenceNo,
			List<Chalaan> chalaan) {
		super();
		Dname = dname;
		MobNo = mobNo;
		VehicleNo = vehicleNo;
		VehicleBuyDate = vehicleBuyDate;
		LicenceNo = licenceNo;
		this.chalaan = chalaan;
	}

	public String getDname() {
		return Dname;
	}

	public void setDname(String dname) {
		Dname = dname;
	}

	public String getMobNo() {
		return MobNo;
	}

	public void setMobNo(String mobNo) {
		MobNo = mobNo;
	}

	public String getVehicleNo() {
		return VehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		VehicleNo = vehicleNo;
	}

	public String getVehicleBuyDate() {
		return VehicleBuyDate;
	}

	public void setVehicleBuyDate(String vehicleBuyDate) {
		VehicleBuyDate = vehicleBuyDate;
	}

	public String getLicenceNo() {
		return LicenceNo;
	}

	public void setLicenceNo(String licenceNo) {
		LicenceNo = licenceNo;
	}

	public List<Chalaan> getChalaan() {
		return chalaan;
	}

	public void setChalaan(List<Chalaan> chalaan) {
		this.chalaan = chalaan;
	}

}
