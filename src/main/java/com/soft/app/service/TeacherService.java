package com.soft.app.service;

import java.util.List;

import com.soft.app.data.entity.Teacher;
import com.soft.app.dto.models.TeacherRequest;
import com.soft.app.dto.models.TeacherResponse;

public interface TeacherService {
	
	TeacherResponse getTeacherById(long id);
	List<Teacher> getTeachers();
	TeacherResponse createTeacher(TeacherRequest teacher);
	Teacher updateTeacher(Teacher teacher, long id);
	Teacher deleteTeacher(long id);

}
