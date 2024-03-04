package com.ebit.company.worker.worker;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
public class Worker {

	@Id
	private int id;
	@NotBlank
	private String name;
	@NotNull
	private String address;
	@Pattern(regexp = "(^|$[0-9]{10})" , message = "Enter Valid Mobile No.")
	private String mobile;
	
	public Worker() {
		
	}

	public Worker(int id, @NotBlank String name, @NotNull String address,
			@Pattern(regexp = "(^$|[0-9]{10)", message = "Enter Valid Mobile No.") String mobile) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.mobile = mobile;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Worker [id=" + id + ", name=" + name + ", address=" + address + ", mobile=" + mobile + "]";
	}

	
	
	
	
	
	
}
