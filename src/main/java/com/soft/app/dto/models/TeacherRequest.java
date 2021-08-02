package com.soft.app.dto.models;

import java.time.LocalDate;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.soft.app.data.entity.Laptop;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class TeacherRequest {

	@NotBlank
	@Size(min = 4, max = 50)
	private String matricule;

	@Pattern(regexp = "^[a-zA-Z]{4,20}", message = "name must contain only letters")
	private String firstName;
	private String lastName;
	private int score;
	@Past
	private LocalDate dateOfBirth;
	
	@Valid
	private LaptopRequest laptop;
	
	private ClubRequest club;
	
	private List<ClassRoomRequest> classes;
	
	public Laptop getLaptop() {
		return new ModelMapper().map(this.laptop, Laptop.class);
	}
}
