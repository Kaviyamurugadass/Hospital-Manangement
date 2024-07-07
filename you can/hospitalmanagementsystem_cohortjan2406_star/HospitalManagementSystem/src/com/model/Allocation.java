package com.model;

import java.util.*;

public class Allocation{
     private String allocationId;
     private String patientId;
     private int roomNumber;
     private int noOfDaysAdmitted;
     private Date admissionDate;
     private Date dischargeDate;
     private String treatment;
     private String roomType;
     private String wantFood;
	public String getAllocationId() {
		return allocationId;
	}
	public void setAllocationId(String allocationId) {
		this.allocationId = allocationId;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public int getNoOfDaysAdmitted() {
		return noOfDaysAdmitted;
	}
	public void setNoOfDaysAdmitted(int noOfDaysAdmitted) {
		this.noOfDaysAdmitted = noOfDaysAdmitted;
	}
	public Date getAdmissionDate() {
		return admissionDate;
	}
	public void setAdmissionDate(Date admissionDate) {
		this.admissionDate = admissionDate;
	}
	public Date getDischargeDate() {
		return dischargeDate;
	}
	public void setDischargeDate(Date dischargeDate) {
		this.dischargeDate = dischargeDate;
	}
	public String getTreatment() {
		return treatment;
	}
	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public String getWantFood() {
		return wantFood;
	}
	public void setWantFood(String wantFood) {
		this.wantFood = wantFood;
	}
	public Allocation(String allocationId, String patientId, int roomNumber, int noOfDaysAdmitted, Date admissionDate,
			Date dischargeDate, String treatment, String roomType, String wantFood) {
		super();
		this.allocationId = allocationId;
		this.patientId = patientId;
		this.roomNumber = roomNumber;
		this.noOfDaysAdmitted = noOfDaysAdmitted;
		this.admissionDate = admissionDate;
		this.dischargeDate = dischargeDate;
		this.treatment = treatment;
		this.roomType = roomType;
		this.wantFood = wantFood;
	}
    
    

	
}
