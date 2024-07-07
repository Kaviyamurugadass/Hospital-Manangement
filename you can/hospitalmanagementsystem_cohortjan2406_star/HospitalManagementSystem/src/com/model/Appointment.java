package com.model;

public class Appointment {
	   private String appointmentId;
	   private String patientId;
	   private String doctorId;
	   private String doctorName;
	   private String specialization;
	   private String appointmentName;
	   private String appointmentTime;
	   private String modeOfAppointment;
	   
   public String getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(String appointmentId) {
		this.appointmentId = appointmentId;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getAppointmentName() {
		return appointmentName;
	}
	public void setAppointmentName(String appointmentName) {
		this.appointmentName = appointmentName;
	}
	public String getAppointmentTime() {
		return appointmentTime;
	}
	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}
	public String getModeOfAppointment() {
		return modeOfAppointment;
	}
	public void setModeOfAppointment(String modeOfAppointment) {
		this.modeOfAppointment = modeOfAppointment;
	}
public Appointment(String appointmentId, String patientId, String doctorId, String doctorName,
			String specialization, String appointmentName, String appointmentTime, String modeOfAppointment) {
		super();
		this.appointmentId = appointmentId;
		this.patientId = patientId;
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.specialization = specialization;
		this.appointmentName = appointmentName;
		this.appointmentTime = appointmentTime;
		this.modeOfAppointment = modeOfAppointment;
	}

  }
   
   

