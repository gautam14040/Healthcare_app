# Healthcare_app
A complete hospital management system in Java using FXML.

##Features :

* Keeping records of prescriptions and medical history.

* Keeping track of beds and availability of facilities.

* Employment record of medical staff.

* Payment details.

* Record of medicines / equipments etc. 

##Database Design :

1. Employee

	* emp_id (Key)

	* name
	
	* post
	
	* department
	
	* gender
	
	* contact
	
	* rights
	
	* dob
	
	* resume
	
	* slot
	
	* avalible_Slot

	* password

	* rights


2. Patient

	* p_id (Key)

	* name
	
	* gender
	
	* dob
	
	* kin_name
	
	* kin_contact
	
	* prim_doctor (F key)

3. Appointments

	* app_id (key)

	* p_id (F key)
	
	* patient_name
	
	* doctor_name
	
	* emp_id(F key)
	
	* slot
	
	* date
	
	* discription
	
	* is_paid
	
	* pay_id (F-key)
	
	* queue (int)
	


4. Equipments

	* eq_id (key)

	* emp_id (F key)
	
	* p_id (F key)
	
	* discription
	
	* start_slot
	
	* number_slots
	
	* is_booked

5. Payment

 	* pay_id (key)

 	* amount 
 	
 	* is_paid
 	
 	* methord
 	
 	* discription


