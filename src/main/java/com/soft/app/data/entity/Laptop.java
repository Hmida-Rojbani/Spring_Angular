package com.soft.app.data.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Laptop {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int code;
	
	private String cpu;
	private String hd;
	private String ram;
	
	@OneToOne(mappedBy = "laptop")
	@JsonIgnore
	private Teacher teacher;

}
