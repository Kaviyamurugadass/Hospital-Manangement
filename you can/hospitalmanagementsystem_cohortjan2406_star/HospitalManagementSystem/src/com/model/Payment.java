package com.model;

public class Payment {
	private String paymentId;
	private String patientId;
    private String patientName;
    private String patientType;
    private String paymentDate;
    private String modeOfPayment;
    private double billAmount;
    
      public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
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
	public String getPatientType() {
		return patientType;
	}
	public void setPatientType(String patientType) {
		this.patientType = patientType;
	}
	public String getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	public String getModeOfPayment() {
		return modeOfPayment;
	}
	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}
	public double getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}

      public Payment(String paymentId, String patientId, String patientName, String patientType, String paymentDate,
			String modeOfPayment, double billAmount) {
		super();
		this.paymentId = paymentId;
		this.patientId = patientId;
		this.patientName = patientName;
		this.patientType = patientType;
		this.paymentDate = paymentDate;
		this.modeOfPayment = modeOfPayment;
		this.billAmount = billAmount;
	}
	
}
