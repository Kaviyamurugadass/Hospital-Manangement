package com.service;
import java.util.ArrayList;
import java.util.List;

import com.management.InPatientManagement;
import com.model.InPatient;
import com.util.ApplicationUtil;


public class InPatientService {
	
	ApplicationUtil au=new ApplicationUtil();

	List<InPatient> inPatientList=new ArrayList<InPatient>();
	InPatientManagement mObj=new InPatientManagement();
 	
	InPatient InObj=null;	
public void BuildInPatientList(String[] patientDetails)
{
	for(int i=0;i<patientDetails.length;i++) 
	{
		String p[]=patientDetails[i].split(":");
		String patientId =au.generateInPatientId();
		String patientName=p[0];
		long phoneNumber=Long.parseLong(p[1]);
		int age=Integer.parseInt(p[2]);
		String gender=p[3];
		String medicalHistory=p[4];
		String prefferedSpecialist=p[5];
		double medicineFee=Double.parseDouble(p[6]);
		String patientType=p[7];
		double admissionFees=Double.parseDouble(p[8]);
		String treatment=p[9];
		String roomType=p[10];
		String wantFood=p[11];
		
		InPatient InObj=new InPatient(patientId,patientName,phoneNumber,age,gender,
				medicalHistory, prefferedSpecialist, medicineFee,patientType,
				admissionFees,treatment,roomType,wantFood);		
		
		inPatientList.add(InObj);
	}
}
public boolean AddInPatientList(String[] inPatientDetails)
{
//		List<String> id=au.extractDetails(inPatientDetails);
	    
		BuildInPatientList(inPatientDetails);
//		System.out.println(mObj.AddInPatientList(InObj);
		boolean b= mObj.InsertInPatientList(inPatientList);		
//		System.out.println(b);
		return b;
}
public boolean UpdatePatientList(String patientId,long phoneNumber)
{
//	  BuildInPatientList(patientId,phoneNumber);
	  boolean c=mObj.UpdateInPatientPhoneNo(patientId,phoneNumber);
//	  System.out.println(c);
	  return c;
}
public boolean UpdatePatientList1(String patientId,String roomType)
{
	boolean d=mObj.UpadateInPatientRoomType(patientId, roomType);
	return d;
}
public boolean UpdatePatientList2(String patientId,String wantFood)
{
	boolean e=mObj.UpdateInPatientFoodPrefer(patientId, wantFood);
    return e;
}


//public boolean RetrivePatientList3(String patientId,String patientName,long phoneNumber,int age,String gender,String medicalHistory,
//			 String prefferedSpecialist,double medicineFee,String pateintType,double admissionFee,String treatment,String roomType,String wantFood)
//{
//	boolean f=mObj.RetriveInpatientDetails(patientId, patientName, phoneNumber, age, gender, medicalHistory, prefferedSpecialist, medicineFee, pateintType, admissionFee, treatment, roomType, wantFood);
//	return f;
//}




public ArrayList<InPatient> RetrivePatientList3(String patientId,String patientName,long phoneNumber,int age,String gender,String medicalHistory,
			 String prefferedSpecialist,double medicineFee,String pateintType,double admissionFee,String treatment,String roomType,String wantFood)
{
	return mObj.RetriveInpatientDetails(patientId);
}

public boolean DeletePatientList4(String patientId)
{
	boolean g=mObj.DeleteInpatientDeatils(patientId);
	return g;
}



}
