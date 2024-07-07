package com.service;
import java.util.ArrayList;
import java.util.List;

import com.management.OutPatientManagement;
import com.model.OutPatient;
import com.util.ApplicationUtil;

public class OutPatientService {
	ApplicationUtil au=new ApplicationUtil();
	
	OutPatientManagement Obj=new OutPatientManagement();
	
	OutPatient OutObj=null;	
	public List<OutPatient> BuildOutPatientList(String[] patientDetails)
	{
		List<OutPatient> outPatientList=new ArrayList<OutPatient>();
		for(int i=0;i<patientDetails.length;i++) 
		{
			String p[]=patientDetails[i].split(":");
			
			String patientId =generateId();
			String patientName=p[0];
			long phoneNumber=Long.parseLong(p[1]);
			int age=Integer.parseInt(p[2]);
			String gender=p[3];
			String medicalHistory=p[4];
			String prefferedSpecialist=p[5];
			double medicineFee=Double.parseDouble(p[6]);
			String patientType=p[7];
			double registerationFess=Double.parseDouble(p[8]);
			
			
			OutPatient OutObj=new OutPatient(patientId,patientName,phoneNumber,age,gender,
					medicalHistory, prefferedSpecialist, medicineFee,patientType,
					registerationFess);		
			
			
			outPatientList.add(OutObj);
		}
		return outPatientList;
	}
	public String generateId() {
		OutPatientManagement Obj=new OutPatientManagement();
		int count = Obj.CheckIdExist();
		count++;
		String id = "OUTPatient"+count;
		return id;
	}
	
	public boolean AddOutPatientList(String[] outPatientDetails)
	{

		List<OutPatient> outPatientList=BuildOutPatientList(outPatientDetails);
			boolean b= Obj.InsertOutPatientList(outPatientList);		
			return b;
	}
	public boolean UpdateOutPatientPhnoeNumber(String patientId,long phoneNumber)
	{

		  boolean c=Obj.UpdateOutPatientPhoneNo(patientId,phoneNumber);

		  return c;
	}
	public ArrayList<OutPatient> RetriveOutPatientDetails(String patientId)
{

	return Obj.RetriveOutpatientDetails(patientId);
	
}
	public boolean DeleteOutPatientDetails(String patientId)
	{
		boolean g=Obj.DeleteOutpatientDeatils(patientId);
		return g;
	}
	 	
}
