package com.management;
import java.sql.*;
import java.util.*;
import com.model.*;

public class AppointmentManagement {
	 public boolean InsertAppointmentList(List<Appointment> AppObj)
	 {
		 try
		 {
			
			 Connection con=DBConnectionManager.getConnection();
			 PreparedStatement ps=null;
			 for(Appointment Obj:AppObj)
			 {
				 String query="insert into Appointment values(?,?,?,?,?,?,?,?)";
				 ps=con.prepareStatement(query);
				 ps.setString(1,Obj.getAppointmentId());
				 ps.setString(2,Obj.getPatientId());
				 ps.setString(3,Obj.getDoctorId());
				 ps.setString(4,Obj.getDoctorName());
				 ps.setString(5,Obj.getSpecialization());
				 ps.setString(6,Obj.getAppointmentName());
				 ps.setString(7,Obj.getAppointmentTime());
				 ps.setString(8,Obj.getModeOfAppointment());
			 }
			 int status=ps.executeUpdate();
//			 System.out.println(status);
			 if(status>0)
			 {
				 return true;
			 }
			 else
			 {
				 return false;
			 }
		 }
		 catch(SQLException | ClassNotFoundException e)
		 {
			 System.out.println(e.getMessage());
		     return false;
		     
		 }
}

//	 public ArrayList<Appointment> RetriveDoctorDetailsForAppointment(String patientId)
	 public ArrayList<Appointment> RetriveDoctorDetailsForAppointment(String specializatio)
	 {
		 ArrayList<Appointment> al=new ArrayList<Appointment>();
		 try
		 {
			 Connection con=DBConnectionManager.getConnection();
			 String query="select * from Appointment where patient_Id=?";
			 PreparedStatement ps=con.prepareStatement(query);


			

//			 ps.setString(1,patientId);

			 ps.setString(1,specializatio);

			 ResultSet rs=ps.executeQuery();
			 while(rs.next())
			 {
				    String appointmentId =rs.getString(1);
					String patientId1=rs.getString(2);
					String doctorId=rs.getString(3);
					String doctorName=rs.getString(4);
					String specialization1=rs.getString(5);
				    String appointmentDate=rs.getString(6);
					String appointmentTime=rs.getString(7);
					String modeofappointment=rs.getString(8);
					Appointment aobj=new Appointment(appointmentId,patientId1,doctorId,doctorName,specialization1,
							appointmentDate,appointmentTime,modeofappointment);
					al.add(aobj);
			 }
		 }
		 catch(SQLException | ClassNotFoundException e)
		 {
	       e.printStackTrace();
		 }
		 return al;
	 }
	  public int CheckIdExists() {
		  int c=0;
		  try(Connection con=DBConnectionManager.getConnection();) {
				PreparedStatement ps=con.prepareStatement("select count(*) as count from appointment");
				ResultSet rs= ps.executeQuery();
				if(rs.next()) {
					c = rs.getInt("count");
					
				}
				
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
				}
			return c;
		 }

//	  public ArrayList<Appointment> RetriveAppointmentDetailsFromDB(String appointment_id)

	  public ArrayList<Appointment> RetriveAppointmentDetailsFromDB(String patientId)
	  {
		ArrayList<Appointment> ao=new ArrayList<Appointment>();
		try
		{
			Connection con=DBConnectionManager.getConnection();

			String query="Select * from Appointment where patient_id=?";


			
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(2, patientId);

			
			
			
//			ps.setString(1,appointment_id);
			
		

		    ResultSet rs=ps.executeQuery();
		    while(rs.next())
		    {
		    	String appointmentId =rs.getString(1);


				String patientId1 =rs.getString(2);




				

				

				String doctorId=rs.getString(3);
				String doctorName=rs.getString(4);
				String specialization=rs.getString(5);
			    String appointmentDate=rs.getString(6);
				String appointmentTime=rs.getString(7);
				String modeofappointment=rs.getString(8);


				Appointment aobj=new Appointment(appointmentId,patientId1,doctorId,doctorName,specialization,
						appointmentDate,appointmentTime,modeofappointment);
				ao.add(aobj);
		    }
		
		    
		}
	
			


		
		catch (SQLException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		return ao;
	  }
	  public boolean DeleteAppointmentDetailsFromDB(String patientId)
	  {
		  try
		  {
			  Connection con=DBConnectionManager.getConnection();

			  String query="delete  from Appointment where Appointment_id=?";
			  PreparedStatement ps=con.prepareStatement(query);
			  ps.setString(1,patientId);

	

			  int status=0;
			  status=ps.executeUpdate();
			  if(status>0)
			  {
				  return true;
			  }
			  else
			  {
				  return false;
			  }
		  }
		  catch(SQLException | ClassNotFoundException e)
		  {
		          System.out.println(e.getMessage());
		          return false;
		  }
		 
	  }
      
}