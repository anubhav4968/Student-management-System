package com.student.service;

import com.student.entity.Owner;
import com.student.entity.Student;
import com.student.payloads.AddressDto;
import com.student.payloads.CourseDto;
import com.student.payloads.OwnerDto;
import com.student.payloads.StudentDto;

public interface OwnerService {

	OwnerDto addOwner(OwnerDto ownerDto);
	OwnerDto updateOwner(OwnerDto ownerDto,Integer ownerId);
	void deleteOwner(Integer ownerId);
	public Owner findByEmailAndPassword(String userEmial, String password);
	
	StudentDto admitStudents(StudentDto studentDto);
	CourseDto  addCourse(CourseDto courseDto);
	StudentDto getStudents(Integer student_id);
	StudentDto getStudentsByName(String name);
	void deleteStudent(Integer student_id);
	AddressDto addAddress(AddressDto addressDto,Integer student_id);
//	CourseDto addCourse(Integer student_id,CourseDto courseDto);
//	List<StudentDto> getAllStudentByCourse(Integer courseId);
}
