package com.soft.app.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soft.app.data.entity.Teacher;
import com.soft.app.dto.models.TeacherRequest;
import com.soft.app.dto.models.TeacherResponse;
import com.soft.app.service.TeacherService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/teachers")
@AllArgsConstructor
public class TeacherController {
	
	private TeacherService service;
	
	@PostMapping()
	public ResponseEntity<TeacherResponse> addTeacher(@RequestBody TeacherRequest teacher) {
		TeacherResponse newTeacher= service.createTeacher(teacher);
		return new ResponseEntity<TeacherResponse>(newTeacher, HttpStatus.CREATED);
	}
	
	@GetMapping()
	public List<Teacher> getAllTeachers(){
		return service.getTeachers();
	}
	
	@GetMapping("/id/{code}")
	public TeacherResponse getTeacherWithId(@PathVariable("code") long id){
		return service.getTeacherById(id);
	}
	
	@PutMapping("/id/{code}")
	public Teacher changeTeacherWithId(@PathVariable("code") long id, @RequestBody Teacher teacher){
		return service.updateTeacher(teacher, id);
	}
	
	@DeleteMapping("/id/{code}")
	public Teacher deleteTeacherWithId(@PathVariable("code") long id){
		return service.deleteTeacher(id);
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> NoSuchElementHandler(NoSuchElementException e){
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

}
