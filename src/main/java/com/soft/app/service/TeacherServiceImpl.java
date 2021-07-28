package com.soft.app.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.soft.app.data.entity.Club;
import com.soft.app.data.entity.Teacher;
import com.soft.app.data.repos.ClubRepository;
import com.soft.app.data.repos.LaptopRepository;
import com.soft.app.data.repos.TeacherRepository;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class TeacherServiceImpl implements TeacherService {
	
	private TeacherRepository reposTeacher;
	private LaptopRepository reposLap;
	private ClubRepository reposClub;

	@Override
	public Teacher getTeacherById(long id) {
		Optional<Teacher> opt =  reposTeacher.findById(id);
		Teacher teacher= opt.orElseThrow(()-> new NoSuchElementException("no teacher found"));
		
		System.err.println(teacher.getClubs());
		return teacher;
	}

	@Override
	public List<Teacher> getTeachers() {
		
		return reposTeacher.findAll();
	}

	@Override
	public Teacher createTeacher(Teacher teacher) {
		//Laptop lap = teacher.getLaptop();
		//lap = reposLap.save(lap);
		//teacher.setLaptop(lap);
		Teacher teacherNew= reposTeacher.save(teacher);
		for (Club c : teacher.getClubs()) {
			c.setResponsable(teacherNew);
			reposClub.save(c);
		}
				 
		return teacher;
	}

	@Override
	public Teacher updateTeacher(Teacher newTeacher, long id) {
		Teacher oldTeacher = getTeacherById(id);
		
		if(newTeacher.getMatricule()!=null)
			oldTeacher.setMatricule(newTeacher.getMatricule());
		if(newTeacher.getLastName()!=null)
			oldTeacher.setLastName(newTeacher.getLastName());
		if(newTeacher.getFirstName()!=null)
			oldTeacher.setFirstName(newTeacher.getFirstName());
		if(newTeacher.getScore()>0)
			oldTeacher.setScore(newTeacher.getScore());
		if(newTeacher.getDateOfBirth()!=null)
			oldTeacher.setDateOfBirth(newTeacher.getDateOfBirth());
		
		return reposTeacher.save(oldTeacher);
	}

	@Override
	public Teacher deleteTeacher(long id) {
		Teacher teacher = getTeacherById(id);
		reposTeacher.deleteById(id);
		return teacher;
	}

}
