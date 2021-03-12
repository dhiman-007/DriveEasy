package com.Driver.Models;

public class Chalaan {

	private String ChallanAmount;
	private String ChalaanStatus;
	private String ChallanNumber;
	private String DateOfChalaan;

	protected Chalaan() {

	}

	public Chalaan(String challanAmount, String chalaanStatus, String challanNumber, String dateOfChalaan) {
		super();
		this.ChallanAmount = challanAmount;
		this.ChalaanStatus = chalaanStatus;
		this.ChallanNumber = challanNumber;
		this.DateOfChalaan = dateOfChalaan;
	}

	public String getChallanNumber() {
		return ChallanNumber;
	}

	public void setChallanNumber(String challanNumber) {
		ChallanNumber = challanNumber;
	}

	public String getChallanAmount() {
		return ChallanAmount;
	}

	public void setChallanAmount(String challanAmount) {
		this.ChallanAmount = challanAmount;
	}

	public String getChalaanStatus() {
		return ChalaanStatus;
	}

	public void setChalaanStatus(String chalaanStatus) {
		this.ChalaanStatus = chalaanStatus;
	}

	public String getDateOfChalaan() {
		return DateOfChalaan;
	}

	public void setDateOfChalaan(String dateOfChalaan) {
		this.DateOfChalaan = dateOfChalaan;
	}

}
