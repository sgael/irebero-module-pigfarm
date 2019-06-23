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
	
	private String names;
	
	private String address;
	
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

	

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
		return names;
	}

	public PigFarmingUsers() {
		
	}
	
	
	
	
	
}
