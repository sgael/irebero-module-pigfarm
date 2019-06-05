
package com.irebero.Domain;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Province implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    private String pname;
    @OneToMany(mappedBy = "province")
    private List<District>district;
    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public List<District> getDistrict() {
        return district;
    }

    public void setDistrict(List<District> district) {
        this.district = district;
    }

    public Province(String pname) {
        this.pname = pname;
    }

    public Province() {
    }

    @Override
    public String toString() {
        return pname;
    }
    
    
    
}
