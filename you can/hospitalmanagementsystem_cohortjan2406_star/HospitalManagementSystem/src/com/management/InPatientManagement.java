package com.management;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


import com.model.InPatient;

public class InPatientManagement {
	
	 public boolean InsertInPatientList(List<InPatient> InObj)
	 {
		 try
		 {
			 
			 Connection con=DBConnectionManager.getConnection();
			 PreparedStatement ps=null;
			 int status=0;
			 for(InPatient Obj:InObj)
			 {
			 String query="insert into InPatient values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			 ps=con.prepareStatement(query);
			 ps.setString(1,Obj.getPatientId());
			 ps.setString(2,Obj.getPatientName());
			 ps.setLong(3,Obj.getPhoneNumber());
			 ps.setInt(4,Obj.getAge());
			 ps.setString(5,Obj.getGender());
			 ps.setString(6,Obj.getMedicalHistory());
			 ps.setString(7,Obj.getPrefferedSpecialist());
			 ps.setDouble(8,Obj.getMedicineFee());
			 ps.setString(9,Obj.getPatientType());
			 ps.setDouble(10,Obj.getAdmissionFees());
			 ps.setString(11,Obj.getTreatment());
			 ps.setString(12,Obj.getRoomType());
			 ps.setString(13,Obj.getWantFood());
			 status=ps.executeUpdate();
			 }
			
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
			 System.out.println("hello");
			 System.out.println(e.getMessage());

			 System.out.println("hello");
		     return false;
		     
		 }
	 }
	 public boolean UpdateInPatientPhoneNo(String patientId,long phoneNumber)
	 {
		 try
		 {
			 
			 Connection con=DBConnectionManager.getConnection();
			 PreparedStatement ps=null;

			 String query="update InPatient set phone_Number=? where patient_Id=?";
			 ps=con.prepareStatement(query);
			 ps.setLong(1,phoneNumber);
			 ps.setString(2,patientId);
			 int status=ps.executeUpdate();
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
		 }	
		 return false;
	 }
	 public boolean UpadateInPatientRoomType(String patientId,String roomType)
	 {
		 try
		 {
			 
			 Connection con=DBConnectionManager.getConnection();
			 String query="update InPatient set room_Type=? where patient_Id=?";
			 PreparedStatement ps=con.prepareStatement(query);
			 ps.setString(1,roomType);
			 ps.setString(2,patientId);
			 int status=ps.executeUpdate();
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
		 }
		 return false;
	 }
	 public boolean UpdateInPatientFoodPrefer(String patientId,String wantFood)
	 {
		try
		{
			
			Connection con=DBConnectionManager.getConnection();
			String query="update InPatient set want_Food=? where patient_Id=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,wantFood);
			ps.setString(2,patientId);
			int status=ps.executeUpdate();
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
		}
		return false;
	 }
	 public ArrayList<InPatient> RetriveInpatientDetails(String patientId)
	 {
		 
		 ArrayList<InPatient> inP=new ArrayList<InPatient>();
		 try
		 {
			 
			 Connection con=DBConnectionManager.getConnection();

			 String query="select * from inPatient where patient_Id=?";
			 PreparedStatement ps=con.prepareStatement(query);
			 ps.setString(1,patientId);
			 
			 ResultSet s=ps.executeQuery();
			 while(s.next())
			 {
				 String patientId1=s.getString(1);
				 String patientName=s.getString(2);
				 long phoneNumber=s.getLong(3);
				 int age=s.getInt(4);
				 String gender=s.getString(5);
				 String medicalHistory=s.getString(6);
				 String prefferedSpecialist=s.getString(7);
				 double medicineFee=s.getDouble(8);
				 String patientType=s.getString(9);
				 double admissionFee=s.getDouble(10);
				 String treatment=s.getString(11);
				 String roomType=s.getString(12);
				 String wantFood=s.getString(13);	
				 InPatient InObj=new InPatient(patientId1,patientName,phoneNumber,age,gender,
							medicalHistory, prefferedSpecialist, medicineFee,patientType,
							admissionFee,treatment,roomType,wantFood);
				 inP.add(InObj);
			 }
			 
		 }
		 catch(SQLException | ClassNotFoundException e)
		 {

		System.out.println(e.getMessage());





		





			 

		 }
		 return inP;
	 }
	 public boolean DeleteInpatientDeatils(String patientId) {
		 try
		 {
			Connection con=DBConnectionManager.getConnection();
			String query="delete from inpatient where patientId=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,patientId);
		    int status=ps.executeUpdate();
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
		 }
		 return false;
	 
	 }
	 
	
}

