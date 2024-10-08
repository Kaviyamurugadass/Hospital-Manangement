
package com.util;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

//import com.model.Payment;

public class ApplicationUtil {
	static int n=1;

	static int v =101;
	static int pid=1;

	static int k=1000;


	public String generateInPatientId()
	{
		String s="";
	
			s="INPAT"+n;
			n++;

		return s;
		
	}

	
	public String generateDoctorId()
	{
		String DocId="";
		DocId="DOCTOR"+k;
		k++;
		return DocId;
	}
	static int i=1;
	public String generateId()
	{
		String Id="";
			Id="Alloc"+i;
			i++;
		return Id;
	}

	public String generatePaymentId()
	{
		String payId="";

			payId="PAYMENT"+pid;
			pid++;
		return payId;
	}
	
	//allocation
	public java.util.Date availableDate1(String availableDate)
	{
		java.util.Date date1 =null;
		try
		{
//			String availableDate1="";
			date1=new SimpleDateFormat("dd/MM/yyyy").parse(availableDate);
		}
	catch(ParseException e) {
		e.printStackTrace();
	}
		return date1;
	}
	
	public java.util.Date dischargeDate(String dischargeDate)
	{
		java.util.Date date2 =null;
		try
		{
			String dischargeDate1="";
			date2=new SimpleDateFormat("dd/MM/yyyy").parse(dischargeDate1);
		}
	catch(ParseException e) {
		e.printStackTrace();
	}
		return date2;
	}
	public static java.sql.Date sqlDate2(java.util.Date dischargeDate)
	{
		java.sql.Date sqlDate2 = new java.sql.Date(dischargeDate.getTime());
	    return sqlDate2;
	}
	
	public static java.sql.Date sqlDate1(java.util.Date admissionDate)
	{
		java.sql.Date sqlDate1 = new java.sql.Date(admissionDate.getTime());
	    return sqlDate1;
	}
	
// Doctor
	public java.util.Date admissionDate(String admissionDate)
	{
		java.util.Date date1 =null;
		try
		{
			String admissionDate1="";
			date1=new SimpleDateFormat("dd/MM/yyyy").parse(admissionDate1);
		}
	catch(ParseException e) {
		e.printStackTrace();
	}
		return date1;
	}
	
	public static java.sql.Date sqlDate(java.util.Date availableDate)
	{
		java.sql.Date sqlDate = new java.sql.Date(availableDate.getTime());
	    return sqlDate;
	}
	public List<String> extractDetails(String[] input){
		List<String> extracted=new ArrayList<String>();
		for(String i:input) {
			extracted.add(i);
		}
		return extracted;
	}

	public long convertLong(String phoneNumber) {
		// TODO Auto-generated method stub
		long phone=0;
		try {
			phone=Long.parseLong(phoneNumber);
		}catch(NumberFormatException e) {
			phone=0;
		}
		
		return phone;
	}

	public int convertInt(String age) {
		// TODO Auto-generated method stub
		int age1=Integer.parseInt(age);
		return age1;
	}

	
	public double convertDouble(String medicineFee) {
		// TODO Auto-generated method stub
		double medicinefee1=Double.parseDouble(medicineFee);
		return medicinefee1;
	}

	

	public String covertLongToString(long long1) {
		// TODO Auto-generated method stub
		return String.valueOf(long1);
	}

	public String covertIntToString(int int1) {
		// TODO Auto-generated method stub
		return String.valueOf(int1);
	}

	public String convertDoubleToString(double double1) {
		// TODO Auto-generated method stub
		return String.valueOf(double1);
	}

	public java.sql.Date dateConvert(String availableDate)   {
		// TODO Auto-generated method stub
//		java.sql.Date sqlDate=null;
	 try{
		 Date date =new SimpleDateFormat("yyyy-MM-dd",java.util.Locale.getDefault()).parse(availableDate);
		 return  new java.sql.Date(date.getTime());
	 }catch (ParseException e) {
		// TODO: handle exception
		 e.printStackTrace();
		 return null;
	}
	
		
	}

	public Time timeConvert(String availableTime) throws ParseException {
		// TODO Auto-generated method stub
		Time time=Time.valueOf(availableTime);
		return time;
	}

	public String convertDateToString(java.sql.Date date) {
		
		return date.toString();
		// TODO Auto-generated method stub
//		return null;
	}

	public String convertTimeToString(Time time) {
		// TODO Auto-generated method stub
		return time.toString();
	}

}
