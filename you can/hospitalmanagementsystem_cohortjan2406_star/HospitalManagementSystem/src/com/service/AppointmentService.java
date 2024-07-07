package com.service;
import java.util.List;
import java.util.ArrayList;
import com.management.AppointmentManagement;
import com.model.Appointment;
import com.util.ApplicationUtil;

public class AppointmentService {

	ApplicationUtil au=new ApplicationUtil();

	List<Appointment> AppointmentList=new ArrayList<Appointment>();
	AppointmentManagement mObj=new AppointmentManagement();
 	
	Appointment InObj=null;
	public void BuildAppointmentList(String[] AppointmentDetails)
	{
		
		for(int i=0;i<AppointmentDetails.length;i++) 
		{
			String p[]=AppointmentDetails[i].split(":");
			

			String appointmentId =generateID();
			String patientId = p[0];
			String doctorId=p[1];
			String doctorName=p[2];
			String specialization=p[3];
		    String appointmentDate=p[4];
			String appointmentTime=p[5];
			String modeofappointment=p[6];


			Appointment InObj=new Appointment(appointmentId,patientId,doctorId,doctorName,specialization,appointmentDate,appointmentTime,modeofappointment);
			AppointmentList.add(InObj);

		}
	}
	
	public boolean AddInAppointmentList(String[] AppointmentDetails)
	{

			BuildAppointmentList(AppointmentDetails);

			boolean b= mObj.InsertAppointmentList(AppointmentList);		


			return b;
	}
    public ArrayList<Appointment> RetriveAppointmentList(String specialization)
    {
    	ArrayList<Appointment> c=mObj.RetriveAppointmentDetailsFromDB(specialization);
    	return c;
    }

	public String generateID()
	{
		AppointmentManagement Obj=new AppointmentManagement();
		int d = Obj.CheckIdExists();
		d++;
		String id = "APPOINT"+d;
		return id;
	}
	


	public int CheckIdExists(String patientId)
	{
		int z=mObj.CheckIdExists();
		return z;
	}

//	public boolean CheckIdExists(String patientId)
//	{
//		boolean z=mObj.CheckIdExists(patientId);
//		return z;
//	}

	public ArrayList<Appointment> RetriveAppointmentList2(String patientId)
	{
		ArrayList<Appointment> d=mObj.RetriveAppointmentDetailsFromDB(patientId);
		return d;
	}

	public boolean DeleteAppointmentDetails(String patientId)
	{
		boolean e=mObj.DeleteAppointmentDetailsFromDB(patientId);
		return e;
	}


	}


//APPOINTMENT_ID 	VARCHAR (25) primary key  
//PATIENT_ID 	VARCHAR (25)    foreign key 
//DOCTOR_ID 	VARCHAR (25)    foreign key 
//DOCTOR_NAME 	VARCHAR (25)     
//SPECIALIZATION 	VARCHAR (25)     
//APPOINTMENT_DATE 	DATE 
//APPOINTMENT_TIME 	TIME 
//MODE_OF_APPOINTMENT 	VARCHAR (25)     


	


