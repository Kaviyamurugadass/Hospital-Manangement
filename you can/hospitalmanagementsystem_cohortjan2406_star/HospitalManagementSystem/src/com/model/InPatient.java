package com.model;

public class InPatient extends Patient {

//	System.out.println("Hello");
	
	private double admissionFees;
	private String treatment;
	private String roomType;
	private String wantFood;
	
	public double getAdmissionFees() {
		return admissionFees;
	}

	public void setAdmissionFees(double admissionFees) {
		this.admissionFees = admissionFees;
	}

	public String getTreatment() {
		return treatment;
	}

	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}
	public String getRoomType()
	{
		return roomType;
	}
    public void setRoomType(String roomType)
    {
    	this.roomType=roomType;
    }
    public String getWantFood()
    {
    	return wantFood;
    }
    public void setWantFood(String wantFood)
    {
    	this.wantFood=wantFood;
    }
	
	
	public InPatient(String patientId, String patientName, long phoneNumber, int age, String gender,
			String medicalHistory, String prefferedSpecialist, double medicineFee, String patientType,
			double admissionFees,String treatment,String roomType,String wantFood) 
	{
		super(patientId,patientName,phoneNumber,age,gender,medicalHistory,
				prefferedSpecialist,medicineFee,patientType);
	
		this.admissionFees= admissionFees;
		this.treatment=treatment;
		this.roomType=roomType;
		this.wantFood=wantFood;
	}
	
	
	
}
	
	



