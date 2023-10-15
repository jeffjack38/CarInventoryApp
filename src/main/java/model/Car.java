
package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="carcatalog")//figure out table name and database config??
public class Car {
	// set variables
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="MAKE")
    private String make;
	@Column(name="MODEL")
    private String model;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
    private List<Owner> owners;
	
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Car(int id, String make, String model) {
		super();
		this.id = id;
		this.make = make;
		this.model = model;
	}
	public Car(int id, String make, String model, List<Owner> owners) {
		super();
		this.id = id;
		this.make = make;
		this.model = model;
		this.owners = owners;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public List<Owner> getOwners() {
		return owners;
	}
	public void setOwners(List<Owner> owners) {
		this.owners = owners;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", make=" + make + ", model=" + model + ", owners=" + owners + "]";
	}
	
}

	

    
