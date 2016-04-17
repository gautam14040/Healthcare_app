# Healthcare_app
A complete hospital management system in Java using FXML.

##Features :

* Keeping track of beds and availability of facilities.
* Employment record of medical staff.
* Payment details.
* Appointment managment 
* Record of equipments  

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

2. Patient
	* p_id (Key)
	* name
	* gender
	* dob
	* kin_id
	* prim_doctor (F key)
	* 
3. Kin_data
	* kin_id
	* kin_name
	* kin_contact


4. Appointments
	* app_id (key)
	* p_id (F key)
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
 	* method
 	* discription
