package com.irebero.Domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class PenTable implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
//	@ManyToOne
//	private PigFarmingUsers owner;
	@NotNull
	
	private String category;
	@NotNull
	private Double size;
	
	@OneToMany(mappedBy="pen")
	private List<Pigsty> pigsty;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
//	public PigFarmingUsers getOwner() {
//		return owner;
//	}
//	public void setOwner(PigFarmingUsers owner) {
//		this.owner = owner;
//	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public List<Pigsty> getPigsty() {
		return pigsty;
	}
	public void setPigsty(List<Pigsty> pigsty) {
		this.pigsty = pigsty;
	}
	public Double getSize() {
		return size;
	}
	public void setSize(Double size) {
		this.size = size;
	}
	@Override
	public String toString() {
		return category;
	}
	public PenTable() {
		
	}
	
	
	
}
