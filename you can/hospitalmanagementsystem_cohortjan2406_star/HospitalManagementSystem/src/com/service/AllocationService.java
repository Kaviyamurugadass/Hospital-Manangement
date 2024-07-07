package com.service;
import java.util.Date;

//import java.sql.*;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;

import java.util.*;

import com.management.AllocationManagement;
import com.model.Allocation;
import com.util.ApplicationUtil;
public class AllocationService{
	ApplicationUtil a = new ApplicationUtil();
	List<Allocation> AllocationList = new ArrayList<Allocation>();
	AllocationManagement b = new AllocationManagement();
	Allocation c = null;
	public void BuildAllocationList(String [] AllocationDetails)
	{
//	System.out.println("jsf");
		for(int i=0;i<AllocationDetails.length;i++)
		{
			String arr[]=AllocationDetails[i].split(":");
			String 	allocationId =a.generateId();
			String patientId =arr[0];
			int roomNumber=Integer.parseInt(arr[1]);
			int noOfDaysAdmitted=Integer.parseInt(arr[2]);
			Date admissionDate= a.availableDate1(arr[3]);
			System.out.println(admissionDate);
            Date dischargeDate=a.availableDate1(arr[4]) ;
			String treatment = arr[5];
			String roomType =arr[6];
			String wantFood= arr[7];
//			System.out.println("jsf");
			Allocation c= new Allocation(allocationId,patientId,roomNumber,noOfDaysAdmitted,admissionDate,dischargeDate,treatment,
				     roomType,wantFood);
//			System.out.println("jsf");
			AllocationList.add(c);
			
		}
	}
	public boolean AddAllocationList(String[] AllocationDetails)
	{
		BuildAllocationList(AllocationDetails);
		boolean a=b.InsertAllocationList(AllocationList);
		return a;
	}

    public boolean checkIdExist(String patientId)
    {
    	boolean x=b.checkIdExist(patientId);
    	return x;
    }
	public ArrayList<Allocation> RetreiveAllocationDetails(String patientId)
	{
		ArrayList<Allocation> z=b.RetreiveAllocationDetails(patientId);
				return z;
	}
	


	public boolean DeleteAllocationDetails(String patientId)
	{
		boolean c=b.DeleteAllocationDetails(patientId);
		return c;
	}
}



