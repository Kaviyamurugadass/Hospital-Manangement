package com.model;

public class Patient {
	private String patientId;
	private String patientName;
	private long phoneNumber;
	private int age;
	private String gender;
	private String medicalHistory;
	private String prefferedSpecialist;
	private double medicineFee;
	private String patientType;

	
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMedicalHistory() {
		return medicalHistory;
	}
	public void setMedicalHistory(String medicalHistory) {
		this.medicalHistory = medicalHistory;
	}
	public String getPrefferedSpecialist() {
		return prefferedSpecialist;
	}
	public void setPrefferedSpecialist(String prefferedSpecialist) {
		this.prefferedSpecialist = prefferedSpecialist;
	}
	public double getMedicineFee() {
		return medicineFee;
	}
	public void setMedicineFee(double medicineFee) {
		this.medicineFee = medicineFee;
	}
	public String getPatientType() {
		return patientType;
	}
	public void setPatientType(String patientType) {
		this.patientType = patientType;
	}
	public Patient(String patientId, String patientName, long phoneNumber, int age, String gender,
			String medicalHistory, String prefferedSpecialist, double medicineFee, String patientType) {

		this.patientId = patientId;
		this.patientName = patientName;
		this.phoneNumber = phoneNumber;
		this.age = age;
		this.gender = gender;
		this.medicalHistory = medicalHistory;
		this.prefferedSpecialist = prefferedSpecialist;
		this.medicineFee = medicineFee;
		this.patientType = patientType;
	}

}
