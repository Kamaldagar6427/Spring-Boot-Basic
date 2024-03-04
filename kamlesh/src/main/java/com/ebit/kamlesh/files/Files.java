package com.ebit.kamlesh.files;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
public class Files {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotBlank
	private String name;
	@NotBlank
	private String address;
	@Pattern(regexp = "(^$|[0-9]{10})", message = "Enter correct mobile no.")
	private String mobileno;
	
	
	
	public Files() {
		super();
	}
	
	
	
	public Files(int id, @NotBlank String name, @NotBlank String address,
			@Pattern(regexp = "(^$|[0-9]{10})", message = "Enter correct mobile no.") String mobileno) {
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
	
	
}
