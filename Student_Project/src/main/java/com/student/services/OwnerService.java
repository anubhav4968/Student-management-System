package com.student.services;

import java.util.List;

import com.student.entity.Owner;
import com.student.payloads.CourseDto;
import com.student.payloads.OwnerDto;
import com.student.payloads.StudentDto;

public interface OwnerService {

	OwnerDto addOwner(OwnerDto ownerDto);
	OwnerDto updateOwner(OwnerDto ownerDto,Integer ownerId);
	void deleteOwner(Integer ownerId);
	
	
	
	
	
	StudentDto admitStudents(StudentDto studentDto);
	CourseDto  createCourse(CourseDto courseDto);
	StudentDto getStudents(String name);
	void deleteStudent(Integer student_id);
	CourseDto addCourse(Integer student_id,CourseDto courseDto);
	List<StudentDto> getAllStudentByCourse(Integer courseId);
	public Owner findByEmailAndPassword(String userEmial, String password);

} 
