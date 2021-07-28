package com.soft.app.data.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "teacher_table")
@Data
@ToString(exclude = {"laptop","clubs"})
public class Teacher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(unique = true, nullable = false,length = 20,name = "code")
	private String matricule;
	
	private String firstName;
	private String lastName;
	private int score;
	private LocalDate dateOfBirth;
	
	@OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
	private Laptop laptop;
	
	
	@OneToMany(mappedBy = "teacher")
	private List<Club> clubs;
	
	@ManyToMany(mappedBy = "teachers")
	private List<ClassRoom> classRooms;

}
