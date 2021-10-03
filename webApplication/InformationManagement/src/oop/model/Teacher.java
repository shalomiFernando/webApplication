/**
 * OOP 2019
 * 
 * @author Shalomi Dilki  Department of Software Engineering, SLIIT 
 * 
 * @version 1.0
 * Copyright: SLIIT, All rights reserved
 * 
 */
package oop.model;

import java.util.Date;

/**
 * This is the Teacher model class
 * 
 * @author Shalomi Dilki, SLIIT
 * @version 1.0
 */
public class Teacher {

	public String teacherID;
	
	public String firstName;
	
	public String lastName;	

	public String address;
	
	public String qualifications;
	
	public String gender;
	
	public float salary;
	
	public String nic;
	
	public String email;

	/**
	 * @return the teacherID
	 */
	public String getTeacherID() {
		return teacherID;
	}

	/**
	 * @param teacherID the teacherID to set
	 */
	public void setTeacherID(String teacherID) {
		this.teacherID = teacherID;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the qualifications
	 */
	public String getQualifications() {
		return qualifications;
	}

	/**
	 * @param qualifications the qualifications to set
	 */
	public void setQualifications(String qualifications) {
		this.qualifications = qualifications;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the dateOfBirth
	 */
	public float getSalary() {
		return salary;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setSalary(float salary) {
		this.salary = salary;
	}

	/**
	 * @return the nic
	 */
	public String getNic() {
		return nic;
	}

	/**
	 * @param nic the nic to set
	 */
	public void setNic(String nic) {
		this.nic = nic;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}			
}
