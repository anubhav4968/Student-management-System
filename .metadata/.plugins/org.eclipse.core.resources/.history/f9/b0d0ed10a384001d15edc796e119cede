package com.student.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.student.entity.Course;
import com.student.entity.Student;
import com.student.exception.ResourseNotFoundException;

import com.student.payloads.CourseDto;
import com.student.repository.CourseRepo;
import com.student.repository.StudentRepo;

@Service
public class CourseServiceImpl implements CourseService{

	
	@Autowired
	private CourseRepo courseRepo;
	
	@Autowired
	private StudentRepo studentRepo;
	
	
	@Autowired
	private ModelMapper modelMapper;
	
	public Course dtoToCourse(CourseDto dto) {
		
		Course course = this.modelMapper.map(dto,Course.class);
		 return course;
	}
	
	public CourseDto courseToDto(Course user) {
		CourseDto dto = this.modelMapper.map(user, CourseDto.class);
		return dto;
	}
	
	
	

	@Override
	public List<CourseDto> viewCourse(Integer id) {
		List<Course> list = this.courseRepo.findAll();
		List<Course> list1 = new ArrayList<>();
		for(Course std:list) {
			
			
				if(std.getCourse_id()==id) {
					list1.add(std);
				
			}
			
		}
		return list1.stream().map(student->this.courseToDto(student)).collect(Collectors.toList());
		
		
		
		
	}

	@Override
	public CourseDto addCourse(Integer student_id, CourseDto course) {
		Optional<Student> opt = studentRepo.findById(student_id);
		if(opt.isPresent()) {
			opt.get().getCourse().add(this.dtoToCourse(course));
			studentRepo.save(opt.get());
			return course;
		}
		return null;
	}

	@Override
	public CourseDto updateCourse(CourseDto course_Dto, Integer student_id) {
		Course course =this.courseRepo.findById(student_id).orElseThrow(()-> new ResourseNotFoundException("Course", "Course_id", student_id));
		
		
		course.setCourseName(course_Dto.getCourseName());
		course.setCourseTopics(course_Dto.getCourseTopics());
		course.setCourseType(course_Dto.getCourseType());
		course.setDescription(course_Dto.getDescription());
		course.setDuration(course_Dto.getDuration());
		Course updatedCourse = this.courseRepo.save(course);
		return this.courseToDto(updatedCourse);
	}
	
}
