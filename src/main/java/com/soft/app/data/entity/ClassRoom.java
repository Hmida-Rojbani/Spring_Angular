package com.soft.app.data.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class ClassRoom {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int code;

	@Column(unique = true, nullable = false)
	private String name;
	
	private int classNumber;
	
	@ManyToMany
	@JsonIgnore
	@JoinTable(name = "teachedBy", 
	joinColumns =  @JoinColumn(name = "classRoomCode"),
	inverseJoinColumns =  @JoinColumn(name = "teacherId"))
	private List<Teacher> teachers;
}
