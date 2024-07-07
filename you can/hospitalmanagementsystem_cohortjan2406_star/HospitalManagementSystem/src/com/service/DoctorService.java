package com.service;
import java.util.ArrayList;
import java.util.List;
import com.management.DoctorManagement;
import com.model.Doctor;
import com.util.ApplicationUtil;

public class DoctorService {
	ApplicationUtil au=new ApplicationUtil();

		List<Doctor> doctorList=new ArrayList<Doctor>();
		DoctorManagement dObj=new DoctorManagement();
//		Doctor obj=null;		
	public void BuildDoctorList(String[] doctorDetails)
	{
		for(int i=0;i<doctorDetails.length;i++) 
		{
			String g[]=doctorDetails[i].split(":");
			String 	doctorId =au.generateDoctorId();
			String doctorName=g[0];
			double doctorFee=Double.parseDouble(g[1]);
			String specialization =g[2];
			String availableDate =g[3];
			String availableTime =g[4];
			Doctor obj=new Doctor(doctorId,doctorName,doctorFee,specialization,availableDate,availableTime);
			doctorList.add(obj);
			
		}
	}
		
			
		public boolean AddDoctorList(String[] doctorDetails)
		{
				BuildDoctorList(doctorDetails);
				boolean o= dObj.InsertDoctorList(doctorList);		
				return o;
		}
		public boolean UpdateDoctorFee(String doctorId,double doctorFee )
		{
			  boolean c=dObj.UpdateDoctorFee(doctorId,doctorFee);
			  return c;
		}
		
		public boolean UpdateDoctorAvailableDate(String doctorId,String availableDate)
		{
			boolean k=dObj.UpdateAvailableDate(doctorId,availableDate);
			return k;
			
		}
				
		public ArrayList<Doctor>  RetriveDoctorList(String doctorId,String doctorName,double doctorFee, String specialization)
	     {
			return dObj.RetrieveDoctor(doctorId);

	       }


				
				
}

		