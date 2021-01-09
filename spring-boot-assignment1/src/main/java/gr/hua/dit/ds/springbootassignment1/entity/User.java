package gr.hua.dit.ds.springbootassignment1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
	@Column(name = "firstname")
    private String firstName;
	
	@Column(name = "lastname")
    private String lastName;
	
	@Column(name = "phone")
    private int phone;
	
	@Column(name = "email")
    private String email;
	
	@Column(name = "department")
    private String department;
	
	@Column(name = "address")
    private String address;
	
	
	 public User(String firstName, String lastName,int phone, String email, String department, String address) {
	        super();
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.phone = phone;
	        this.email = email;
	        this.department = department;
	        this.address = address;
	    }


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public Integer getPhone() {
		return phone;
	}


	public void setPhone(Integer phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
    public String toString() {
        return "Users [firstName=" + firstName + ", lastName=" + lastName + ", phone=" +phone + " email=" + email + " department=" + department +"address=" + address + "]";
    }


	public void setId(Integer email) {
		// TODO Auto-generated method stub
		
	}

}
