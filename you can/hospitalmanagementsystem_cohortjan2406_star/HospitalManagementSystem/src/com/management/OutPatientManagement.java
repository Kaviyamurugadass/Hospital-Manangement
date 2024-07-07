package com.management;
import java.sql.*;
import java.util.*;
import com.model.OutPatient;

public class OutPatientManagement {

	public boolean InsertOutPatientList(List<OutPatient> OutObj) {
		// TODO Auto-generated method stub
		try
		 {
			 Connection con=DBConnectionManager.getConnection();
			 PreparedStatement ps=null;
			 int status=0;
			 for(OutPatient Obj:OutObj)
			 {
				 ps=con.prepareStatement("insert into outpatient values(?,?,?,?,?,?,?,?,?,?)");
				 ps.setString(1,Obj.getPatientId());
				 ps.setString(2,Obj.getPatientName());
				 ps.setLong(3,Obj.getPhoneNumber());
				 ps.setInt(4,Obj.getAge());
				 ps.setString(5,Obj.getGender());
				 ps.setString(6,Obj.getMedicalHistory());
				 ps.setString(7,Obj.getPrefferedSpecialist());
				 ps.setDouble(8,Obj.getMedicineFee());
				 ps.setString(9,Obj.getPatientType());
				 ps.setDouble(10,Obj.getRegisterationFess());
				 status=ps.executeUpdate();
		
	}
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
	public int CheckIdExist() {
		int d =0;
		try(Connection con=DBConnectionManager.getConnection();) {
			PreparedStatement ps=con.prepareStatement("select count(*) as count from outpatient");
			ResultSet rs= ps.executeQuery();
			if(rs.next()) {
				d = rs.getInt("count");
				
			}
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			}
		return d;
	}
	 public ArrayList<OutPatient> RetriveOutpatientDetails(String patientId)
	 {
		 ArrayList<OutPatient> op=new ArrayList<OutPatient>();
		 try
		 {
			 
			 Connection con=DBConnectionManager.getConnection();

			 String query="select * from outPatient where patient_Id=?";
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
				 double registerationFess=s.getDouble(10);
				
				 OutPatient OObj=new OutPatient(patientId1,patientName,phoneNumber,age,gender,
							medicalHistory, prefferedSpecialist, medicineFee,patientType,registerationFess);
				 op.add(OObj);
			 }
			 
		 }
		 catch(SQLException | ClassNotFoundException e)
		 {
	       e.printStackTrace();
		
		 }
		 return op;
	 }
	public boolean DeleteOutpatientDeatils(String patientId) {
		// TODO Auto-generated method stub
		 try
		 {
			Connection con=DBConnectionManager.getConnection();
			String query="delete from outpatient where patient_Id=?";
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
	public boolean UpdateOutPatientPhoneNo(String patientId, long phoneNumber) {
		// TODO Auto-generated method stub
		try
		 {
			 Connection con=DBConnectionManager.getConnection();
			 PreparedStatement ps=null;

			 String query="update OutPatient set phone_Number=? where patient_Id=?";
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
	 
}
	
