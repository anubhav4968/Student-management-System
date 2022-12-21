package com.student.services;

import java.util.List;


import com.student.payloads.CourseDto;


public interface CourseService {

	 public List<CourseDto> viewCourse(Integer id);
	    public CourseDto addCourse(Integer student_id,CourseDto address);
	    public CourseDto updateCourse(CourseDto course_Dto , Integer student_id);
}
