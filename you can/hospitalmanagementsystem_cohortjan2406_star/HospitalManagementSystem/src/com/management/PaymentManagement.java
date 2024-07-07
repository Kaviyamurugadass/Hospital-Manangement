package com.management;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.model.Payment;
import com.util.ApplicationUtil;

public class PaymentManagement {

public ApplicationUtil auObj=new ApplicationUtil();
public List<Payment> insertPaymentDetails(List<Payment> build) {
// TODO Auto-generated method stub
List<Payment>pList=new ArrayList<Payment>();
try {
Connection con=DBConnectionManager.getConnection();
for(Payment p:build) {
PreparedStatement psd=con.prepareStatement("insert into payment (PAYMENT_ID ,OUTPATIENT_ID,PATIENT_NAME, PATIENT_TYPE, PAYMENT_DATE, MODE_OF_PAYMENT, BILL_AMOUNT ) values(?,?,?,?,?,?,?)");
psd.setString(1, p.getPaymentId());
psd.setString(2, p.getPatientId());
psd.setString(3, p.getPatientName());
psd.setString(4, p.getPatientType());
psd.setDate(5,auObj.dateConvert(p.getPaymentDate()));
psd.setString(6, p.getModeOfPayment());
psd.setDouble(7,p.getBillAmount());
psd.executeUpdate();
pList.add(p);

	
			}
			
		} catch (ClassNotFoundException | SQLException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pList;
	}
	




public List<Payment> insertPaymentDetailsInpatient(List<Payment> build) {
// TODO Auto-generated method stub
List<Payment>pList=new ArrayList<Payment>();
try {
Connection con=DBConnectionManager.getConnection();
for(Payment p:build) {
PreparedStatement psd=con.prepareStatement("insert into payment (PAYMENT_ID ,INPATIENT_ID,PATIENT_NAME, PATIENT_TYPE, PAYMENT_DATE, MODE_OF_PAYMENT, BILL_AMOUNT ) values(?,?,?,?,?,?,?)");
psd.setString(1, p.getPaymentId());
psd.setString(2, p.getPatientId());
psd.setString(3, p.getPatientName());
psd.setString(4, p.getPatientType());
psd.setDate(5,auObj.dateConvert(p.getPaymentDate()));
psd.setString(6, p.getModeOfPayment());
psd.setDouble(7,p.getBillAmount());
psd.executeUpdate();
pList.add(p);
}

} catch (ClassNotFoundException | SQLException  e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
return pList;
}
public List<Payment> RetrivePatientDetails(String id) {
// TODO Auto-generated method stub
List<Payment>paymentList=new ArrayList<Payment>();
try {
Connection con=DBConnectionManager.getConnection();
PreparedStatement psd=con.prepareStatement("select * from payment where OUTPATIENT_ID=?");
psd.setString(1, id);
ResultSet rs=psd.executeQuery();
while(rs.next()) {
String paymentId=rs.getString(1);
String patientId=rs.getString(2);
String patientName=rs.getString(3);
String patientType=rs.getString(4);
String paymentDate=auObj.convertDateToString(rs.getDate(5));
String modeOfPayment=rs.getString(6);
double billAmount=rs.getDouble(7);
Payment pObj=new Payment(paymentId, patientId, patientName, patientType, paymentDate, modeOfPayment, billAmount);
paymentList.add(pObj);

}
} catch (ClassNotFoundException | SQLException  e) {
// TODO Auto-generated catch block
System.err.println(e.getMessage());
}

return paymentList;
}
public List<Payment> RetrivePatientDetailsInpatient(String id) {
// TODO Auto-generated method stub
List<Payment>paymentList=new ArrayList<Payment>();
try {
Connection con=DBConnectionManager.getConnection();
PreparedStatement psd=con.prepareStatement("select * from payment where PATIENT_ID=?");
psd.setString(1, id);
ResultSet rs=psd.executeQuery();
while(rs.next()) {
String paymentId=rs.getString(1);
String patientId=rs.getString(2);
String patientName=rs.getString(3);
String patientType=rs.getString(4);
String paymentDate=auObj.convertDateToString(rs.getDate(5));
String modeOfPayment=rs.getString(6);
double billAmount=rs.getDouble(7);
Payment pObj=new Payment(paymentId, patientId, patientName, patientType, paymentDate, modeOfPayment, billAmount);
paymentList.add(pObj);

}
} catch (ClassNotFoundException | SQLException  e) {
// TODO Auto-generated catch block
System.err.println(e.getMessage());
}

return paymentList;
}
public  String checkIdExist()
{
String paymentId="";
try
{
Connection con=DBConnectionManager.getConnection();
PreparedStatement ps = con.prepareStatement("select PAYMENT_ID from payment order by PAYMENT_ID desc limit 1");
ResultSet rs= ps.executeQuery();
while(rs.next()) {
paymentId=rs.getString(1);
}

} catch (Exception e) {

System.out.println(e.getMessage());
}
return paymentId;
}
}