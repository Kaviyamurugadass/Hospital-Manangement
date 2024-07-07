package com.management;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;
import com.model.Doctor;

public class DoctorManagement {
   
	public boolean InsertDoctorList(List<Doctor> DocObj)

	{
		try {
//		DBConnectionManager db=new DBConnectionManager();
		Connection con=DBConnectionManager.getConnection();
		int state=0;
		for(Doctor OBJ:DocObj)
		{
		  PreparedStatement pst=con.prepareStatement("insert into Doctor values(?,?,?,?,?,?)");
	      pst.setString(1,OBJ.getDoctorId());
	      pst.setString(2,OBJ.getDoctorName());
	      pst.setDouble(3,OBJ.getDoctorFee());
	      pst.setString(4,OBJ.getSpecialization());
	      pst.setString(5,OBJ.getVailableDate());
	      pst.setString(6,OBJ.getAvailableTime());
	      
	      state=pst.executeUpdate();
		}
		if(state>0)
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
	
public boolean UpdateDoctorFee(String doctor_Id,double doctor_Fee)
{
	try
{
		Connection con=DBConnectionManager.getConnection();
		PreparedStatement pst=con.prepareStatement("Update Doctor set doctor_Fee=? where Doctor_Id=? ");
		pst.setDouble(1,doctor_Fee);
		pst.setString(2,doctor_Id);
		int state=pst.executeUpdate();
		if(state>0)
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
public boolean UpdateAvailableDate(String doctor_Id,String availabledate)
{
	try
	{
		Connection con = DBConnectionManager.getConnection();
		PreparedStatement ps = con.prepareStatement("Update doctor set availabledate=? where doctor_Id=?");
		ps.setString(1, availabledate);
		ps.setString(2, doctor_Id);

		
		int state =ps.executeUpdate();
		if(state>0)

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
		

public ArrayList<Doctor> RetrieveDoctor(String doctor_Id){
	ArrayList<Doctor>doc =new ArrayList<Doctor>();
try
{
	Connection con=DBConnectionManager.getConnection();
	PreparedStatement pst=con.prepareStatement("select *from doctor where doctor_Id=?");
	 pst.setString(1,doctor_Id);
	 
	 ResultSet s=pst.executeQuery();
	 while(s.next()) 
	 {
	  String doctorId1=s.getString(1);
	  String doctorName=s.getString(2);
	  Double doctorFee=s.getDouble(3);
	  String specialization =s.getString(4);
	  String vailableDate = s.getString(5);
	  String availableTime = s.getString(6);
	  
	   Doctor DocObj= new Doctor (doctorId1,doctorName,doctorFee,specialization,vailableDate,availableTime);
	   
	   doc.add(DocObj);
	 }
	 return doc;			
				
}

catch(SQLException | ClassNotFoundException e)
  {
	   System.out.println(e.getMessage());
  }
	   return doc; 
}


	
}

