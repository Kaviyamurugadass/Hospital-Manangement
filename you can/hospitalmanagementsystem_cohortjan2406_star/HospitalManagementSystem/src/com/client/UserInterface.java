package com.client;

import java.util.*;



import com.management.*;

import com.model.Allocation;
import com.model.Appointment;
import com.model.Doctor;

import com.model.InPatient;

import com.model.OutPatient;

import com.model.Payment;

import com.service.*;

public class UserInterface {



	@SuppressWarnings("resource")
	public static void main(String[] args) {

		// TODO Auto-generated method stub

		Scanner sc =new Scanner(System.in);  

		InPatientService sObj=new InPatientService();

		OutPatientService OObj=new OutPatientService();

		AllocationService aObj=new AllocationService();
		
		AppointmentService apObj = new AppointmentService();

		DoctorService dcObj=new DoctorService();

//		PaymentService pObj=new PaymentService();
		
		

//		PaymentService pObj=new PaymentService();
		


		
		
		while(true) {

		System.out.println("_______________________________________\n \n    Stars Hospital Management     \n_______________________________________");

		 System.out.println("Enter Your Choice\n");

		 System.out.println("1.Doctor\n2.Patient\n3.Exit");

		 int choice1=sc.nextInt();
		 
		 if(choice1==3) {
			 System.out.println("Thanks For using This application");
			 break;
		 }

//		 Doctor

		 if(choice1==1) {

			 while(true) {

					

        		 System.out.println("1.Add Doctor details\n2.Update Doctor Fee\n3.Update Doctor Available Date\n4.Retrieve Doctor information\n5.Exit");

        	     int choice=sc.nextInt();

        	     if(choice==1) {

        	    	 System.out.println("Enter total no of Doctor Information:");

     				int n=sc.nextInt();

     				sc.nextLine();

     				System.out.println("Enter the Doctor details");

     				String details[]=new String[n];

     				for(int i=0;i<n;i++)

     				{

     				 details[i]=sc.nextLine();

     				}

     		    	if(dcObj.AddDoctorList(details))

     				{

     					System.out.println("Doctor Details Inserted succuessfully");

     				}

     				else

     				{

     					System.out.println("Insertion failed");

     				}	

        	     }

        	     if(choice==2)

     		    {

     		    	System.out.println("Enter the DoctorId");

     		         String doctorId=sc.next();

     		    	System.out.println("Enter the Doctor Fee to be updated");

     		    	double doctorfee=sc.nextDouble();

     		    	if(dcObj.UpdateDoctorFee(doctorId,doctorfee))

     				{

     					System.out.println("Doctor Fees  updated successfully");

     				}

     				else

     				{

     					System.out.println("Doctor Fees are not updated. Check for the ID");

     				}

     		    }

        	     if(choice==3)

      		    {

      		    	System.out.println("Enter the DoctorId");

      		         String doctorId=sc.next();

      		    	System.out.println("Enter the Doctor Available Date to be updated");

      		    	String doctorAvailDate=sc.next();

      		    	if(dcObj.UpdateDoctorAvailableDate(doctorId,doctorAvailDate))

      				{

      					System.out.println("Doctor Available Date  updated successfully");

      				}

      				else

      				{

      					System.out.println("Doctor Available Date are not updated. Check for the ID");

      				}

      		    }

        	     if(choice==4)

     			{

     				System.out.println("Enter the Doctor id");

     				String doctorId=sc.next();

     				DoctorManagement dObj=new DoctorManagement();

     				ArrayList<Doctor> rlist=dObj.RetrieveDoctor(doctorId);

     				if(rlist.isEmpty())

     				{

     					System.out.println("No Doctor details are available");

     				}

     				else

     				{

     					for(Doctor i:rlist)

     					{				

     						System.out.println("PatientId : " +i.getDoctorId());

     						System.out.println("PatientName : " +i.getDoctorName());

     						System.out.println("Patient Phone number : " +i.getSpecialization());

                             System.out.println("Patient age : " +i.getVailableDate());

                             System.out.println("Patient gender : "+i.getAvailableTime());

                          

     					}

     				}

     			}

        	   

        	     if(choice==5) {

        	    	

        	    	 break;

        	     }



        	 

				 

			 }

		 }

		 if(choice1==2) {

			 while(true){

         System.out.println("Enter the choice\n1.OutPatient\n2.InPatient\n3.Appointment\n4.Allocation\n5.Payment\n6.Exit");

         int choices=sc.nextInt();
       
         if(choices==6) {
        	 System.out.println("Thank You!, Hope You Like Our *STAR* Service");

        	 break;

         }

         if(choices==1) {


        	 while(true){

        		 System.out.println("1.Insert Outpatient details\n2.Update Outpatient Phone number\n3.Retrieve patient details\n4.Delete patient information\n5.Exit");

        	     int choice=sc.nextInt();

        	     if(choice==1) {

        	    	 System.out.println("Enter total no of OutPatients:");

     				int n=sc.nextInt();

     				sc.nextLine();

     				System.out.println("Enter the patient details");

     				String details[]=new String[n];

     				for(int i=0;i<n;i++)

     				{

     				 details[i]=sc.nextLine();

     				}

     		    	if(OObj.AddOutPatientList(details))

     				{

     					System.out.println("Patient Details Inserted succuessfully");

     				}

     				else

     				{

     					System.out.println("Insertion failed");

     				}	

        	     }

        	     if(choice==2)

     		    {

     		    	System.out.println("Enter the patientId");

     		         String patientId=sc.next();

     		    	System.out.println("Enter the phoneNumber to be updated");

     		    	long phoneNumber=sc.nextLong();

     		    	if(OObj.UpdateOutPatientPhnoeNumber(patientId,phoneNumber))

     				{

     					System.out.println("OutPatient Phone Number updated successfully");

     				}

     				else

     				{

     					System.out.println("OutPatient phone Number are not updated. Check for the ID");

     				}

     		    }

        	     if(choice==3)

     			{

     				System.out.println("Enter the OutPatient id");

     				String patientId=sc.next();

     				OutPatientManagement rObj=new OutPatientManagement();

     				ArrayList<OutPatient> rlist=rObj.RetriveOutpatientDetails(patientId);

     				if(rlist.isEmpty())

     				{

     					System.out.println("No patients details are available");

     				}

//     			



     				else

     				{

     					for(OutPatient i:rlist)

     					{				

     						System.out.println("PatientId : " +i.getPatientId());

     						System.out.println("PatientName : " +i.getPatientName());

     						System.out.println("Patient Phone number : " +i.getPhoneNumber());

                             System.out.println("Patient age : " +i.getAge());

                             System.out.println("Patient gender : "+i.getGender());

                             System.out.println("Patient Medical History : " +i.getMedicalHistory());

                             System.out.println("Patient Preffered Specialist : "+i.getPrefferedSpecialist());

                             System.out.println("Patient MedicalFee : "+i.getMedicineFee());

                             System.out.println("Patient Type : "+i.getPatientType());

                             System.out.println("Patient Registration Fees : "+i.getRegisterationFess());

     					}

     				}

     			}

        	     if(choice==4) {

     				System.out.println("Enter the Patient Id to delete");

     				String patientId=sc.next();

     				OutPatientManagement dObj=new OutPatientManagement();

     				boolean result=dObj.DeleteOutpatientDeatils(patientId);

     				if(result)

     				{

     					System.out.println("Patient details deleted successfully");

     				}

     				else

     				{

     					System.out.println("Patient details not deleted. check for patient Id");

     				}

     				

     			}

        	     if(choice==5) {

        	    	

        	    	 break;

        	     }



        	 

        	 }

         

         }

        	if(choices==2) {

         

		while(true)

		{

			System.out.println("1.Insert patient details\n2.Update Phone number\n3.Update Room type\n4.Update food preference\n5.Retrieve patient details\n6.Delete patient information\n7.Exit");

		    System.out.println("Enter the chocie");

		    int choice=sc.nextInt();

		    sc.nextLine();

		    if(choice==1)

		    {

		    	System.out.println("Enter total no of patients:");

				int n=sc.nextInt();

				sc.nextLine();

				System.out.println("Enter the patient details");

				String details[]=new String[n];

				for(int i=0;i<n;i++)

				{

				 details[i]=sc.nextLine();

				}

		    	if(sObj.AddInPatientList(details))

				{

					System.out.println("Patient Details Inserted succuessfully");

				}

				else

				{

					System.out.println("Insertion failed");

				}	

		    }

		    if(choice==2)

		    {

		    	System.out.println("Enter the patientId");

		         String patientId=sc.next();

		    	System.out.println("Enter the phoneNumber to be updated");

		    	long phoneNumber=sc.nextLong();

		    	if(sObj.UpdatePatientList(patientId,phoneNumber))

				{

					System.out.println("Patient Phone Number updated successfully");

				}

				else

				{

					System.out.println("Patient phone Number are not updated. Check for the ID");

				}

		    }

		    if(choice==3)

		    {

		    	System.out.println("Enter the patientId");

		    	String patientId=sc.next();

		    	System.out.println("Enter the room type to be updated");

		    	String roomType=sc.next();

		    	if(sObj.UpdatePatientList1(patientId, roomType))

		    	{

		    		System.out.println("Room type updated successfully");

		    	}

		    	else

		    	{

		    		System.out.println("Room type are not updated. Check for the ID");

		    	}

		    }

		    if(choice==4)

		    {

		    	System.out.println("Enter the patientId");

		    	String patientId=sc.next();

		    	System.out.println("Enter the Food preference to be updated");

		    	String wantFood=sc.next();

		    	if(sObj.UpdatePatientList2(patientId,wantFood))

		    	{

		    		System.out.println("Want food updated successfully");  		

		    	}

		    	else 

		    	{

		    		System.out.println("Want food are not updated. Check for the ID");

		    	}

		    }

			if(choice==5)

			{

				System.out.println("Enter the patient id");

				String patientId=sc.next();

				InPatientManagement rObj=new InPatientManagement();

				ArrayList<InPatient> rlist=rObj.RetriveInpatientDetails(patientId);

				if(rlist.isEmpty())

				{

					System.out.println("No patients details are available");

				}



				else

				{

					for(InPatient i:rlist)

					{

						System.out.println("PatientId : " +i.getPatientId());

						System.out.println("PatientName : " +i.getPatientName());

						System.out.println("Patient Phone number : " +i.getPhoneNumber());

                        System.out.println("Patient age : " +i.getAge());

                        System.out.println("Patient gender : "+i.getGender());

                        System.out.println("Patient Medical History : " +i.getMedicalHistory());

                        System.out.println("Patient Preffered Specialist : "+i.getPrefferedSpecialist());

                        System.out.println("Patient MedicalFee : "+i.getMedicineFee());

                        System.out.println("Patient Type :"+i.getPatientType());

                        System.out.println("Patient admission fee :" +i.getAdmissionFees());

                        System.out.println("Patient treatment fee : "+i.getTreatment());

                        System.out.println("Patient room type :" +i.getRoomType());

                        System.out.println("Patient food preference :"+i.getWantFood());

					}

				}

			}

			if(choice==6) {

				System.out.println("Enter the Patient Id to delete");

				String patientId=sc.next();

				InPatientManagement dObj=new InPatientManagement();

				boolean result=dObj.DeleteInpatientDeatils(patientId);

				if(result)

				{

					System.out.println("Patient details deleted successfully");

				}

				else

				{

					System.out.println("Patient details not deleted. check for patient Id");

				}

				

			}

			if(choice==7) {

				break;

			}

		}

		}
        	
        	
        	if(choices==3) {

        		while(true){

            		

           		 System.out.println("1.Add Appointment details\n2.Retrieve Appointment Details\n3.Delete patient information\n4.Exit");

           	     int choice=sc.nextInt();

           	     if(choice==1) {

           	    	 System.out.println("Enter total no of appointments");

        				int n=sc.nextInt();

        				sc.nextLine();

        				System.out.println("Enter the Appointment Details");

        				String details[]=new String[n];

        				for(int i=0;i<n;i++)

        				{

        				 details[i]=sc.nextLine();

        				}

        		    	if(apObj.AddInAppointmentList(details))

        				{

        					System.out.println("Appointment details inserted succuessfully");

        				}

        				else

        				{

        					System.out.println("Insertion failed");

        				}	

           	     }

           	    

           	     if(choice==2)

        			{

        				System.out.println("Enter the patient id");

        				String patientId=sc.next();

        				AppointmentManagement appObj=new AppointmentManagement();

        				ArrayList<Appointment> rlist=appObj.RetriveAppointmentDetailsFromDB(patientId);

        				if(rlist.isEmpty())

        				{

        					System.out.println("No patients details are available");

        				}     			



        				else

        				{

        								

        					for(Appointment i:rlist)

        					{	
        						
//        						private String appointmentId;
//        						   private String patientId;
//        						   private String doctorId;
//        						   private String doctorName;
//        						   private String specialization;
//        						   private String appointmentName;
//        						   private String appointmentTime;
//        						   private String modeOfAppointment;

        						System.out.println("PatientId : " +i.getAppointmentId());

        						System.out.println("PatientId : " +i.getPatientId());

                                System.out.println("Patient age : " +i.getDoctorName());

                                System.out.println("Patient gender : "+i.getSpecialization());

                       

                                System.out.println("Patient admission fee :" +i.getAppointmentName());

                                System.out.println("Patient treatment fee : "+i.getAppointmentTime());

                                System.out.println("Patient room type :" +i.getModeOfAppointment());

                               

        					}

        				}

        			}

           	     if(choice==3) {

        				System.out.println("Enter the Patient Id to delete");

        				String patientId=sc.next();

        				AllocationManagement alObj=new AllocationManagement();

        				

        				boolean result=alObj.DeleteAllocationDetails(patientId);

        				if(result)

        				{

        					System.out.println("Allocation details deleted successfully");

        				}

        				else

        				{

        					System.out.println("Allocation details not deleted. check for patient Id");

        				}

        				

        			}

           	     if(choice==4) {

           	    	

           	    	 break;

           	     }



           	 

           	 }

        		

        	}

    // Appointment
        	if(choices==3) {
        		while(true){

            		

              		 System.out.println("1.Add Appointment details\n2.Retrieve  Doctor Details from Appointment\n3.Retrieve Appointment Details\n4.Delete Appointment information\n5.Exit");

              	     int choice=sc.nextInt();
              	     if(choice==1) {


               	    	 System.out.println("Enter total no of appointments");

            				int n=sc.nextInt();

            				sc.nextLine();

            				System.out.println("Enter the appointments Details");

            				String details[]=new String[n];

            				for(int i=0;i<n;i++)

            				{

            				 details[i]=sc.nextLine();

            				}

            		    	if(apObj.AddInAppointmentList(details))

            				{

            					System.out.println("Appointment details inserted succuessfully");

            				}

            				else

            				{

            					System.out.println("Insertion failed");

            				}	

               	     
              	     }
              	     if(choice==2) {


          				System.out.println("Enter the Specialization");

          				String doctorId=sc.next();

          				
          				AppointmentManagement apdObj=new AppointmentManagement();

          				ArrayList<Appointment> rlist=apdObj.RetriveDoctorDetailsForAppointment(doctorId);

          				if(rlist.isEmpty())

          				{

          					System.out.println("No Doctor details are available");

          				}

          				else

          				{
          					System.out.println("Doctor Names are: ");
          					

          					for(Appointment i:rlist)

          					{				

          						System.out.println();
                                System.out.println("Doctor ID :"+i.getDoctorId()+" Doctor Name :"+i.getDoctorName());
          						
                               

          					}

          				}

          			
              	     }
              	     if(choice==3) {



           				System.out.println("Enter the patient id");

           				String doctorId=sc.next();

           	
           				AppointmentManagement apdObj=new AppointmentManagement();

           				ArrayList<Appointment> rlist=apdObj.RetriveAppointmentDetailsFromDB(doctorId);

           				if(rlist.isEmpty())

           				{

           					System.out.println("No Appointment details are available");

           				}

           				else

           				{

           					for(Appointment i:rlist)

           					{				

           						System.out.println("AppointmentID : " +i.getAppointmentId());

           						System.out.println("PatientID : " +i.getPatientId());

           						System.out.println("DoctorID : " +i.getDoctorId());

           						
           						System.out.println("Doctor Name : " +i.getDoctorName());

           						System.out.println("Specialization of Doctor: " +i.getSpecialization());
           						
           						System.out.println("Appointment Name: " +i.getAppointmentName());

                                   System.out.println("Appointment Time : " +i.getAppointmentTime());

                                   System.out.println("Mode Of Payment : "+i.getModeOfAppointment());

                                

           					}

           				}

           			
               	     
              	     }
              	     if(choice==4) {


         				System.out.println("Enter the appointment Id to delete");

         				String patientId=sc.next();

         				AppointmentManagement apdObj=new AppointmentManagement();

         				boolean result=apdObj.DeleteAppointmentDetailsFromDB(patientId);

         				if(result)

         				{

         					System.out.println("Appointment details deleted successfully");

         				}

         				else

         				{

         					System.out.println("Appointment details not deleted. check for patient Id");

         				}

         				

         			
              	     }
              	   if(choice==5) {

   			    	break;

   			    }
        	}
        	}

//        	Allocation

        	if(choices==4) {

        		while(true){

            		

           		 System.out.println("1.Add allocation details\n2.Retrieve Alocation Details\n3.Delete patient information\n4.Exit");

           	     int choice=sc.nextInt();

           	     if(choice==1) {

           	    	 System.out.println("Enter total no of allocations");

        				int n=sc.nextInt();

        				sc.nextLine();

        				System.out.println("Enter the Allocation Details");

        				String details[]=new String[n];

        				for(int i=0;i<n;i++)

        				{

        				 details[i]=sc.nextLine();

        				}

        		    	if(aObj.AddAllocationList(details))

        				{

        					System.out.println("Allocation details inserted succuessfully");

        				}

        				else

        				{

        					System.out.println("Insertion failed");

        				}	

           	     }

           	    

           	     if(choice==2)

        			{

        				System.out.println("Enter the OutPatient id");

        				String patientId=sc.next();

        				AllocationManagement alObj=new AllocationManagement();

        				ArrayList<Allocation> rlist=alObj.RetreiveAllocationDetails(patientId);

        				if(rlist.isEmpty())

        				{

        					System.out.println("No patients details are available");

        				}     			



        				else

        				{

        								

        					for(Allocation i:rlist)

        					{	

        						System.out.println("PatientId : " +i.getAllocationId());

        						System.out.println("PatientId : " +i.getPatientId());

                                System.out.println("Patient age : " +i.getRoomNumber());

                                System.out.println("Patient gender : "+i.getNoOfDaysAdmitted());

                       

                                System.out.println("Patient admission fee :" +i.getAdmissionDate());

                                System.out.println("Patient treatment fee : "+i.getDischargeDate());

                                System.out.println("Patient room type :" +i.getTreatment());

                                System.out.println("Patient food preference :"+i.getRoomType());

                                System.out.println("Patient food preference :"+i.getWantFood());

        					}

        				}

        			}

           	     if(choice==3) {

        				System.out.println("Enter the allocation Id to delete");

        				String patientId=sc.next();

        				AllocationManagement alObj=new AllocationManagement();

        				

        				boolean result=alObj.DeleteAllocationDetails(patientId);

        				if(result)

        				{

        					System.out.println("Allocation details deleted successfully");

        				}

        				else

        				{

        					System.out.println("Allocation details not deleted. check for patient Id");

        				}

        				
        				

        			}

           	     if(choice==4) {

           	    	

           	    	 break;

           	     }



           	 

           	 }

        		

        	}

        	

        	if(choices==5) {

			while(true) {

			System.out.println("Enter your choice\n1.Add Payment Details\n2.Retrive Payment Details\n3.Exit");
			
			PaymentService pSer=new PaymentService();

			 int choice=sc.nextInt();
//			 System.out.println(choice);
			    sc.nextLine();
			    
			    if(choice==3) {

			    	break;

			    }

			    if(choice==1)

			    {

			    	System.out.println("Enter  How Many Payments Add:");

					int n=sc.nextInt();

					sc.nextLine();

					System.out.println("Enter details\nInput format: Patient ID:Patient Type:Payment Date:mode of Payment");

					String details[]=new String[n];

					for(int i=0;i<n;i++)

					{

					 details[i]=sc.nextLine();

					}

					List<Payment>paymentList=pSer.insertPaymentList(details);
					if(paymentList.isEmpty()) {
						System.out.println("Payment details cannot be added");
					}
					else {
						System.out.println("Payment details added successfully");
						for(Payment p:paymentList) {
							System.out.println(p.getPatientName()+" 's Payment ID     : "+p.getPaymentId()+"\nBill Amount              : "+p.getBillAmount());
						}
					}
			    }

			    if(choice==2) {

			    	System.out.println("Enter the patient id");

					String patientId=sc.next();

					PaymentManagement rObj=new PaymentManagement();

					List<Payment> rlist=rObj.RetrivePatientDetails(patientId);

					if(rlist.isEmpty())

					{

						System.out.println("No patients details are available");

					}


					else

					{

						for(Payment i:rlist)

						{

							  System.out.println("Patient MedicalFee : "+i.getPaymentId());

							System.out.println("PatientId : " +i.getPatientId());

							System.out.println("PatientName : " +i.getPatientName());

							 System.out.println("Patient Type :"+i.getPatientType());

	                        System.out.println("Patient age : " +i.getPaymentDate());

	                        System.out.println("Patient gender : "+i.getModeOfPayment());

	                        System.out.println("Patient Medical History : " +i.getBillAmount());

	                      

	                      

	                       

	                       

						}

					}

			    	

			    }

		}

		}

		

			 }

		 }

	}}

}