package com.soft.app.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.soft.app.data.entity.Teacher;
import com.soft.app.data.repos.TeacherRepository;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class TeacherServiceImpl implements TeacherService {
	
	private TeacherRepository repos;

	@Override
	public Teacher getTeacherById(long id) {
		Optional<Teacher> opt =  repos.findById(id);
		return opt.orElseThrow(()-> new NoSuchElementException("no teacher found"));
	}

	@Override
	public List<Teacher> getTeachers() {
		
		return repos.findAll();
	}

	@Override
	public Teacher createTeacher(Teacher teacher) {
		return repos.save(teacher);
	}

}