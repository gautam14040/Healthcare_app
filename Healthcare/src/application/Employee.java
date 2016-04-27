package application ;

import java.util.Date;

public class Employee {
     
    public int emp_id;
    public String emp_name;
    public String post;
    public int dept_id ;
    public String gender ;
    public int rights ;
    public Date dob;
    public String slot ;
    public String availible_slot ;
    public String password ;
    public String contact ;
    
	public Employee() {
		super();
	}
	public Employee(int emp_id, String emp_name, String post, int department, String gender, int rights, Date dob,
			String slot, String availible_slot, String password, String contact) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.post = post;
		this.dept_id = department;
		this.gender = gender;
		this.rights = rights;
		this.dob = dob;
		this.slot = slot;
		this.availible_slot = availible_slot;
		this.password = password;
		this.contact = contact;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public int getDepartment() {
		return dept_id;
	}
	public void setDepartment(int department) {
		this.dept_id = department;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getRights() {
		return rights;
	}
	public void setRights(int rights) {
		this.rights = rights;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getSlot() {
		return slot;
	}
	public void setSlot(String slot) {
		this.slot = slot;
	}
	public String getAvailible_slot() {
		return availible_slot;
	}
	public void setAvailible_slot(String availible_slot) {
		this.availible_slot = availible_slot;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", emp_name=" + emp_name + ", post=" + post + ", department=" + dept_id
				+ ", gender=" + gender + ", rights=" + rights + ", dob=" + dob + ", slot=" + slot + ", availible_slot="
				+ availible_slot + ", password=" + password + ", contact=" + contact + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((availible_slot == null) ? 0 : availible_slot.hashCode());
		result = prime * result + ((contact == null) ? 0 : contact.hashCode());
		result = prime * result + dept_id;
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + emp_id;
		result = prime * result + ((emp_name == null) ? 0 : emp_name.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((post == null) ? 0 : post.hashCode());
		result = prime * result + rights;
		result = prime * result + ((slot == null) ? 0 : slot.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (availible_slot == null) {
			if (other.availible_slot != null)
				return false;
		} else if (!availible_slot.equals(other.availible_slot))
			return false;
		if (contact == null) {
			if (other.contact != null)
				return false;
		} else if (!contact.equals(other.contact))
			return false;
		if (dept_id != other.dept_id)
			return false;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (emp_id != other.emp_id)
			return false;
		if (emp_name == null) {
			if (other.emp_name != null)
				return false;
		} else if (!emp_name.equals(other.emp_name))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (post == null) {
			if (other.post != null)
				return false;
		} else if (!post.equals(other.post))
			return false;
		if (rights != other.rights)
			return false;
		if (slot == null) {
			if (other.slot != null)
				return false;
		} else if (!slot.equals(other.slot))
			return false;
		return true;
	}
	
    
     
     
}