package com.management;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.model.Allocation;
import com.util.ApplicationUtil;
public class AllocationManagement {
	public boolean InsertAllocationList(List<Allocation> Allobj)
	{
//		ApplicationUtil u = new ApplicationUtil();
		
		try {
          Connection con = DBConnectionManager.getConnection();
			PreparedStatement ps = null;
			int Allow = 0;
			for(Allocation obj : Allobj) {
				ps=con.prepareStatement("insert into Allocation values(?,?,?,?,?,?,?,?,?)");
				ps.setString(1, obj.getAllocationId());
				ps.setString(2, obj.getPatientId());
				ps.setInt(3, obj.getRoomNumber());
				ps.setInt(4, obj.getNoOfDaysAdmitted());
				ps.setDate(5, ApplicationUtil.sqlDate2(obj.getAdmissionDate()));
				ps.setDate(6, ApplicationUtil.sqlDate2(obj.getDischargeDate()));
				ps.setString(7, obj.getTreatment());
				ps.setString(8, obj.getRoomType());
				ps.setString(9, obj.getWantFood());
				Allow = ps.executeUpdate();
			}
			if(Allow>0) {
				return true;
			}
			else {
				return false;
			}
		}
			catch(SQLException | ClassNotFoundException e) {
				System.out.println(e.getMessage());
				return false;
			}
		}
   public boolean checkIdExist(String patientId)
   {
	   return true;
   }
   public ArrayList<Allocation> RetreiveAllocationDetails(String allocation_id)
   {
		ArrayList<Allocation> all=new ArrayList<Allocation>();
		try {
			Connection con = DBConnectionManager.getConnection();
			String query="select * from Allocation where patient_id =?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,allocation_id);
			ResultSet s=ps.executeQuery();
			while(s.next())
			{
			    String allocationId=s.getString(1);

				String patientId1=s.getString(2);

				int RoomNumber=s.getInt(3);
				int NoOfDaysAdmitted=s.getInt(4);
			    java.util.Date AdmissionDate=s.getDate(5);
				java.util.Date DischargeDate=s.getDate(6);
				String Treatment=s.getString(7);
				String RoomType=s.getString(8);
				String WantFood=s.getString(9);
				Allocation obj=new Allocation(allocationId,patientId1,RoomNumber,NoOfDaysAdmitted,
						AdmissionDate,DischargeDate,Treatment,RoomType,WantFood);

				all.add(obj);		

			}
		}
		catch(SQLException | ClassNotFoundException e)
		 {
	       e.printStackTrace();
		 }
		 return all;
	 }
  
		public boolean DeleteAllocationDetails(String allocation_id)
		{
			try {
				Connection con=DBConnectionManager.getConnection();
				String query="delete from  Allocation where allocation_id=?";
				PreparedStatement ps=con.prepareStatement(query);
				ps.setString(1,allocation_id);
			    int Allow=ps.executeUpdate();
			    if(Allow>0)
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












































//package com.management;
//import java.sql.*;
//public class AllocationManagement {
//	public boolean InsertAllocationList (List<Allocation> Allobj) {
//		try {
//          Connection con = DBConnectionManager.getConnection();
//			PreparedStatement ps = null;
//			int Allow = 0;
//			for(Allocation obj : Allobj) {
//				ps=con.prepareStatement("insert into Allocation values(?,?,?,?,?,?,?,?,?)");
//				ps.setString(1, obj.getAllocationId());
//				ps.setString(2, obj.getPatientId());
//				ps.setInt(3, obj.getRoomNumber());
//				ps.setInt(4, obj.getNoOfDaysAdmitted());
//				ps.setString(5, obj.getAdmissionDate());
//				ps.setString(6, obj.getDischargeDate());
//				ps.setString(7, obj.getTreatment());
//				ps.setString(8, obj.getRoomType());
//				ps.setString(9, obj.getWantFood());
//				Allow = ps.executeUpdate();
//			}
//			if(Allow>0) {
//				return true;
//			}
//			else {
//				return false;
//			}
//		}
//			catch(SQLException | ClassNotFoundException e) {
//				System.out.println(e.getMessage());
//				return false;
//			}
//		}
//		public boolean checkIdExist(String patientId) {
//			return true;
//		}
//		public ArrayList<Allocation> RetrieveAllocationDetails(String patientId)
//		{
//			ArrayList<Allocation> all=new ArrayList<Allocation>();
//			try {
//				Connection con = DBConnectionManager.getConnection();
//				String query="select * from Allocation where patientId =?";
//				PreparedStatement ps=con.prepareStatement(query);
//				ps.setString(2,patientId);
//				ResultSet s=ps.executeQuery();
//				while(s.next());
//				{
//				    String allocationId=s.getString(1);
//					patientId=s.getString(2);
//					int RoomNumber=s.getInt(3);
//					int NoOfDaysAdmitted=s.getInt(4);
//				    String AdmissionDate=s.getString(5);
//					String DischargeDate=s.getString(6);
//					String Treatment=s.getString(7);
//					String RoomType=s.getString(8);
//					String WantFood=s.getString(9);
//					Allocation obj=new Allocation(allocationId,patientId,RoomNumber,NoOfDaysAdmitted,
//
//							AdmissionDate,DischargeDate,Treatment,RoomType,WantFood);
//
//					all.add(obj);		
//
//				}
//			}
//			catch(SQLException | ClassNotFoundException e)
//			 {
//		       e.printStackTrace();
//			 }
//			 return all;
//		 }
//
//        }
//		public boolean DeleteAllocationDetails(String patientId)
//		{
//			try {
//				Connection con=DBConnectionManager.getConnection();
//				String query="delete from  Allocation where patientId=?";
//				PreparedStatement ps=con.prepareStatement(query);
//				ps.setString(2,patientId);
//			    int Allow=ps.executeUpdate();
//			    if(Allow>0)
//			    {
//			    	return true;
//			    }
//			    else
//			    {
//			    	return false;
//			    }
//		   }
//			 catch(SQLException | ClassNotFoundException e)
//			 {
//				 System.out.println(e.getMessage());
//			 }
//			 return false;
//		 }
//			}
//
//		