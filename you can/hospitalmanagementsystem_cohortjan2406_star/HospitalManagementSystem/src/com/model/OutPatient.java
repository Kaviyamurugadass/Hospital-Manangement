package com.model;

public class OutPatient extends Patient {
	private double registerationFess;
	
	public double getRegisterationFess() {
		return registerationFess;
	}
	public void setRegisterationFess(double registerationFess) {
		this.registerationFess = registerationFess;
	}
	public OutPatient(String patientId, String patientName, long phoneNumber, int age, String gender,
			String medicalHistory, String prefferedSpecialist, double medicineFee, String patientType,
			double registerationFess)
	{
		super(patientId,patientName,phoneNumber,age,gender,medicalHistory,
				prefferedSpecialist,medicineFee,patientType);
	

		this.registerationFess = registerationFess;
	}
 

}
