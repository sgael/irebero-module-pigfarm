package com.irebero.Domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PigFarmingUsers implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	private Long id;
	
	private String Firstname;
	
	private String Lastname;
	
	private String Address;
	
	private String gender;
	
	private String phone;
	
	
//	@OneToMany(mappedBy="owner",fetch=FetchType.LAZY)
//	private List<PenTable> penTables;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return Firstname;
	}

	public void setFirstname(String firstname) {
		Firstname = firstname;
	}

	public String getLastname() {
		return Lastname;
	}

	public void setLastname(String lastname) {
		Lastname = lastname;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

//	public List<PenTable> getPenTables() {
//		return penTables;
//	}
//
//	public void setPenTables(List<PenTable> penTables) {
//		this.penTables = penTables;
//	}

	@Override
	public String toString() {
		return Firstname+" "+Lastname;
	}

	public PigFarmingUsers() {
		
	}
	
	
	
	
	
}
