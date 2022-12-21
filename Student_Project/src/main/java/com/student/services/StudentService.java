package com.student.services;

import java.util.List;

import com.student.payloads.CourseDto;
import com.student.payloads.StudentDto;

public interface StudentService {

	
	StudentDto updateStudent(StudentDto studentDto , Integer student_id);
	List<CourseDto> getAllCourses();
	void leaveCourse(Integer id);
	
}