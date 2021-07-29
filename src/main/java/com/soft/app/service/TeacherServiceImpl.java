package com.soft.app.service;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.soft.app.data.entity.ClassRoom;
import com.soft.app.data.entity.Club;
import com.soft.app.data.entity.Teacher;
import com.soft.app.data.repos.ClassRoomRepository;
import com.soft.app.data.repos.ClubRepository;
import com.soft.app.data.repos.LaptopRepository;
import com.soft.app.data.repos.TeacherRepository;
import com.soft.app.dto.models.TeacherRequest;
import com.soft.app.dto.models.TeacherResponse;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class TeacherServiceImpl implements TeacherService {
	
	private TeacherRepository reposTeacher;
	private LaptopRepository reposLap;
	private ClubRepository reposClub;
	private ClassRoomRepository reposClass;
	private ModelMapper mapper;

	
	private Teacher findTeacherById(long id) {
		Optional<Teacher> opt =  reposTeacher.findById(id);
		Teacher teacher= opt.orElseThrow(()-> new NoSuchElementException("no teacher found"));
		return teacher;
	}

	@Override
	public List<Teacher> getTeachers() {
		
		return reposTeacher.findAll();
	}

	@Override
	public TeacherResponse createTeacher(TeacherRequest teacherRequest) {
		
		//Laptop lap = teacher.getLaptop();
		//lap = reposLap.save(lap);
		//teacher.setLaptop(lap);
		Teacher teacher = mapper.map(teacherRequest, Teacher.class);
		
		Teacher teacherNew= reposTeacher.save(teacher);
		if(teacher.getClubs()!=null)
		for (Club c : teacher.getClubs()) {
			c.setTeacher(teacherNew);
			reposClub.save(c);
		}
				 
		// take classRoom list
		// check if the classRoom is already persisted(new, update)
		
		List<ClassRoom> classes= teacher.getClassRooms();
		if(classes !=null)
		for (ClassRoom classRoom : classes) {
			Optional<ClassRoom> room = reposClass.findByName(classRoom.getName());
			if(room.isPresent()) {
				classRoom = room.get();
				classRoom.getTeachers().add(teacherNew);
			}else {
				classRoom.setTeachers(Arrays.asList(teacherNew));
			}
				
				reposClass.save(classRoom);
				
		}
		return mapper.map(teacherNew, TeacherResponse.class);
	}

	@Override
	public Teacher updateTeacher(Teacher newTeacher, long id) {
		Teacher oldTeacher = findTeacherById(id);
		
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
		Teacher teacher = findTeacherById(id);
		reposTeacher.deleteById(id);
		return teacher;
	}

	@Override
	public TeacherResponse getTeacherById(long id) {
		return mapper.map(findTeacherById(id), TeacherResponse.class);
	}

}
