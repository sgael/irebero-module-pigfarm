package com.irebero.Domain;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@ Entity
public class Pigsty implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	private String location;
	@ManyToOne
	private PenTable pen;
//	@NumberFormat(pattern="#")
	private Double meters;
	@NotNull
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private PigFarmingUsers owner;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	

	public PigFarmingUsers getOwner() {
		return owner;
	}

	public void setOwner(PigFarmingUsers owner) {
		this.owner = owner;
	}

	
	public PenTable getPen() {
		return pen;
	}

	public void setPen(PenTable pen) {
		this.pen = pen;
	}

	public Double getMeters() {
		return meters;
	}

	public void setMeters(Double meters) {
		this.meters = meters;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Pigsty() {
		
	}

	@Override
	public String toString() {
		return "Pigsty [owner=" + owner + "]";
	}

	
	

	
}
