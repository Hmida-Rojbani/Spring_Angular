package com.soft.app.service;

import java.util.List;

import com.soft.app.data.entity.Teacher;

public interface TeacherService {
	
	Teacher getTeacherById(long id);
	List<Teacher> getTeachers();
	Teacher createTeacher(Teacher teacher);
	Teacher updateTeacher(Teacher teacher, long id);
	Teacher deleteTeacher(long id);

}
