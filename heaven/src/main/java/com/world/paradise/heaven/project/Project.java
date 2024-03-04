package com.world.paradise.heaven.project;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotBlank
	private String name;
	@NotBlank
	private String address;
	@Pattern(regexp = "(^$|[0-9]{10})", message = "Enter Correct Mobile No.")
	private String mobileno;
	
	
	public Project() {
		super();
	}


	


	public Project(int id, @NotBlank String name, @NotBlank String address,
			@Pattern(regexp = "(^$|[0-9]{10})", message = "Enter Correct Mobile No.") String mobileno) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.mobileno = mobileno;
	}





	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getMobileno() {
		return mobileno;
	}


	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}


	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", address=" + address + ", mobileno=" + mobileno + "]";
	}


	
	
	
}
