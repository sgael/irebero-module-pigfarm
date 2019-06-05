package com.irebero.Domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Entity;

@Entity
public class Sector implements Serializable{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	    private String name;
	    @ManyToOne
	    private District district;
	    @OneToMany(mappedBy="sector")
	    private List<Location>locations;
	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public District getDistrict() {
	        return district;
	    }

	    public void setDistrict(District district) {
	        this.district = district;
	    }

	    public Sector(String name) {
	        this.name = name;
	    }

	    public List<Location> getLocations() {
			return locations;
		}

		public void setLocations(List<Location> locations) {
			this.locations = locations;
		}

		public Sector() {
	    }

	    @Override
	    public String toString() {
	        return name;
	    }
	    
}
