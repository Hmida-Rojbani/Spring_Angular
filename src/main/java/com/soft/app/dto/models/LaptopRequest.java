package com.soft.app.dto.models;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class LaptopRequest {
	@NotBlank
	private String cpu;
	private String hd;
	private String ram;

}
