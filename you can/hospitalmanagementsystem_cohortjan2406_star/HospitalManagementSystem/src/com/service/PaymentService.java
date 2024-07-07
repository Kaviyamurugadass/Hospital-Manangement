package com.service;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.management.AllocationManagement;
import com.management.AppointmentManagement;
import com.management.DBConnectionManager;
//import com.management.DoctorManagement;
import com.management.InPatientManagement;
import com.management.OutPatientManagement;
import com.management.PaymentManagement;
import com.model.Allocation;
import com.model.Appointment;
import com.model.InPatient;
import com.model.OutPatient;
import com.model.Payment;
import com.util.ApplicationUtil;

public class PaymentService {
ApplicationUtil auObj=new ApplicationUtil();
PaymentManagement pmObj=new PaymentManagement();




public List<Payment> buildList(List<String> extract) {
// TODO Auto-generated method stub
List<Payment>addList=new ArrayList<Payment>();
int count1=0;
for(String s:extract) {
count1++;
String details[]=s.split(":");
if(details[1].equalsIgnoreCase("INPATIENT")) {
InPatientManagement imObj=new InPatientManagement();
List<InPatient>ipList=imObj.RetriveInpatientDetails(details[0]);
for(InPatient p:ipList) {
AllocationManagement amObj=new AllocationManagement();
List<Allocation>aList=amObj.RetreiveAllocationDetails(p.getPatientId());
for(Allocation a:aList) {
Payment pObj=new Payment(generateId(count1), p.getPatientId(),p.getPatientName(), p.getPatientType(), details[2], details[3],calculateBillAmountForInpatient(p.getTreatment(),p.getRoomType(),p.getWantFood(),p.getAdmissionFees(),p.getMedicineFee(),a.getNoOfDaysAdmitted()) );
addList.add(pObj);
}

}

}      
else if(details[1].equalsIgnoreCase("OUTPATIENT")) {

OutPatientManagement omObj=new OutPatientManagement();
List<OutPatient>opList=omObj.RetriveOutpatientDetails(details[0]);
for(OutPatient o:opList) {

System.out.println(o.getPatientId());
AppointmentManagement amObj=new AppointmentManagement();
List<Appointment>apList=amObj.RetriveAppointmentDetailsFromDB(o.getPatientId());

for(Appointment a:apList) {
// DoctorManagement dmObj=new DoctorManagement();

double doctorFee=getDoctorFee(a.getDoctorId());
System.out.println(doctorFee);
Payment pObj=new Payment(generateId(count1),o.getPatientId(),o.getPatientName() ,o.getPatientType(), details[2], details[3], calculateBillAmountForOutpatient(doctorFee,o.getMedicineFee(),o.getRegisterationFess()));
addList.add(pObj);
}
}
}
}
return addList;
}
public double calculateBillAmountForOutpatient(double doctorFee, double medicineFee, double registrationFees) {
// TODO Auto-generated method stub
double billAmount=(doctorFee)+(medicineFee)+(registrationFees);
return billAmount;
}
public double calculateBillAmountForInpatient(String treatment, String roomType, String wantFood,double admissionFees,double medicineFee,
int noOfDaysAdmitted) {

Double billAmount;
Double treatmentCost;
Double room;
Double food;
if(treatment.equalsIgnoreCase("surgery")) {
treatmentCost=10000.00;
}
else if(treatment.equalsIgnoreCase("general")) {
treatmentCost=6000.00;
}
else {
treatmentCost=1000.00;
}
if(roomType.equalsIgnoreCase("ac")) {
room=1200.00;
}
else if(roomType.equalsIgnoreCase("non-ac")) {
room=500.00;
}
else {
room=300.00;
}
if(wantFood.equalsIgnoreCase("yes")) {
food=150.00;
}
else {
food=0.00;
}

billAmount=treatmentCost+admissionFees+medicineFee+(noOfDaysAdmitted)*(room+food);

return billAmount;
}
int count=0;
public String generateId(int count1) {

String id="PM00";
String paymentId=pmObj.checkIdExist();
if(paymentId=="")
{
count++;
return id+count;
}
else if(count1==1) {
count=Integer.parseInt(paymentId.substring(4,5));
count++;
return id+count;
}
else {
count++;
return id+count;
}
}
public List<Payment> retriveList(String id) {
List<Payment>paymentList=pmObj.RetrivePatientDetails(id);
return paymentList;
}
public double getDoctorFee(String doctorId) {
double res=0.0;
try {
Connection con=DBConnectionManager.getConnection();
PreparedStatement psd=con.prepareStatement("select DOCTOR_FEE from doctor where DOCTOR_ID=?");
psd.setString(1, doctorId);
ResultSet rs=psd.executeQuery();
while(rs.next()) {
res=rs.getDouble(1);
}
} catch (ClassNotFoundException | SQLException  e) {
// TODO Auto-generated catch block
System.err.println(e.getMessage());
}
return res;
}

	public List<Payment> insertPaymentList(String[] pay) {

		List<String>extract=auObj.extractDetails(pay);
		List<Payment>build=buildList(extract);
		List<Payment>resultList=pmObj.insertPaymentDetails(build);
		return resultList;
	}

	
	
	
	
}



//INSERT INTO Payments (PAYMENT_ID, INPATIENT_ID, OUTPATIENT_ID, PATIENT_NAME, PATIENT_TYPE, PAYMENT_DATE, MODE_OF_PAYMENT, BILL_AMOUNT)
//VALUES
//    (1, 101, NULL, 'John Doe', 'Inpatient', '2024-05-06', 'Credit Card', 2500.00),
//    (2, NULL, 201, 'Jane Smith', 'Outpatient', '2024-05-07', 'Cash', 150.00);