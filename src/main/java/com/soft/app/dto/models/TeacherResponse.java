package com.soft.app.dto.models;


import com.soft.app.data.entity.Laptop;

import lombok.Data;

@Data
public class TeacherResponse {

	private String matricule;

	private String firstName;
	private String lastName;
	
	private String laptop;
	
	public void setLaptop(Laptop laptop) {
		this.laptop = laptop.toString();
	}
}
