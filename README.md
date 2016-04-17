# Healthcare_app
A complete hospital management system in Java using FXML.

##Features :

* Keeping records of prescriptions and medical history.

* Keeping track of beds and availability of facilities.

* Employment record of medical staff.

* Payment details.

* Record of medicines / equipments etc. 

##Database Design :

The designed relation is in BCNF

1. Employee

	* emp_id (Key)

	* name
	
	* post
	
	* department
	
	* gender
	
	* rights
	
	* dob
		
	* slot
	
	* avalible_Slot

	* password

	* rights

	* contact

3. Patient

	* p_id (Key)

	* name
	
	* gender
	
	* dob
	
	* kin_name
	
	* prim_doctor (F key)

4. Kin_data
	
	* kin_name
	
	* kin_contact


5. Appointments

	* app_id (key)

	* p_id (F key)
	
	* patient_name
	
	* emp_id(F key)
	
	* slot
	
	* date
	
	* discription
	
	* pay_id (F-key)
	
	* queue (int)
	


5. Equipments

	* eq_id (key)

	* emp_id (F key)
	
	* p_id (F key)
	
	* discription
	
	* start_slot
	
	* number_slots
	
	* is_booked

6. Payment

 	* pay_id (key)

 	* amount 
 	
 	* is_paid
 	
 	* methord
 	
 	* discription


