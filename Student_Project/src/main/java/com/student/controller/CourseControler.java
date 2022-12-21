package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.exception.NullValueExcception;

import com.student.payloads.CourseDto;
import com.student.services.CourseService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/course")
public class CourseControler {

	@Autowired
	private CourseService courseService;
	
	//get - getAllCourse
			@GetMapping("/")
			public ResponseEntity<List<CourseDto>> viewAddress(@Valid @PathVariable Integer student_id){
				return ResponseEntity.ok(this.courseService.viewCourse(student_id));
			}
			// post - adding the course 
			@PostMapping("/{student_id}")
			public ResponseEntity<String> addCourse(@PathVariable Integer student_id,@RequestBody CourseDto courseDto){
				CourseDto course = courseService.addCourse( student_id,courseDto);
				if(course==null) {
					throw new NullValueExcception("Value Not Found", "Student_Id", student_id);
				}
				else
				{
					return new ResponseEntity<String>("Course Added"+course,HttpStatus.ACCEPTED);
				}
			}		
			
			//put - update
			@PutMapping("/{student_id}")
			public ResponseEntity<CourseDto> updateAddressDetails(@Valid @RequestBody CourseDto courseDto,@PathVariable Integer student_iD){
				CourseDto updatedCourse = this.courseService.updateCourse(courseDto, student_iD);
				return ResponseEntity.ok(updatedCourse);
			}
			
			
			
}
