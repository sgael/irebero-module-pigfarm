package com.irebero.Domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Entity;

@Entity
public class District implements Serializable{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	    private String dname;
	    @ManyToOne
	    private Province province;
	    @OneToMany(mappedBy = "district")
	    private List<Sector>sector;
	    public String getDname() {
	        return dname;
	    }

	    public void setDname(String dname) {
	        this.dname = dname;
	    }

	    public Province getProvince() {
	        return province;
	    }

	    public void setProvince(Province province) {
	        this.province = province;
	    }

	    public List<Sector> getSector() {
	        return sector;
	    }

	    public void setSector(List<Sector> sector) {
	        this.sector = sector;
	    }

	    public District(String dname) {
	        this.dname = dname;
	    }

	    public District() {
	    }

	    @Override
	    public String toString() {
	        return dname;
	    }
	    
}
