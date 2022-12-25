package com.student.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.payloads.AddressDto;
import com.student.payloads.ApiResponse;
//import com.student.payloads.CourseDto;
import com.student.payloads.StudentDto;
//import com.student.services.StudentService;
import com.student.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/student")
public class StudentControler {

	@Autowired
	private StudentService studentService;
	
	
	// update
	@PutMapping("/{student_id}")
	public ResponseEntity<StudentDto> updateStudentDetails(@Valid @RequestBody StudentDto studentDto,@PathVariable Integer student_id){
		StudentDto updatedStudent = this.studentService.updateStudent(studentDto, student_id);
		return ResponseEntity.ok(updatedStudent);
	}
	//update Address
		@PutMapping("/address/{address_id}")
		public ResponseEntity<AddressDto> updateStudentAddress(@Valid @RequestBody AddressDto addressDto,@PathVariable Integer address_id){
			AddressDto updatedStudentAddress = this.studentService.updateAddress(addressDto, address_id);
			return ResponseEntity.ok(updatedStudentAddress);
		}
	
	
//	//get - getAllCourse
//	@GetMapping("/")
//	public ResponseEntity<List<CourseDto>> getAllCourses(){
//		return ResponseEntity.ok(this.studentService.getAllCourses());
//	}
//	
//	//delete- leaveCourse
//	@DeleteMapping("/{course_id}")
//	public ResponseEntity<ApiResponse> leaveCourse(@PathVariable Integer course_id){
//		this.studentService.leaveCourse(course_id);
//		return new ResponseEntity<ApiResponse> ( new ApiResponse("Leave Course Successfully!!", true),HttpStatus.OK);
//	}
	
}











