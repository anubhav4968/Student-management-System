package com.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.entity.Student;
import com.student.payloads.AddressDto;
import com.student.payloads.ApiResponse;
import com.student.payloads.CourseDto;
import com.student.payloads.OwnerDto;
import com.student.payloads.StudentDto;
import com.student.service.OwnerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/owner")
public class OwnerController {

	@Autowired
	private OwnerService ownerService;
	
	@PostMapping("/")
	public ResponseEntity<OwnerDto> addOwner(@Valid @RequestBody OwnerDto ownerDto){
		OwnerDto addOwnerDto = this.ownerService.addOwner(ownerDto);
		return new ResponseEntity<OwnerDto>(addOwnerDto,HttpStatus.CREATED);
	}
	
	@PutMapping("/{ownerId}")
	public ResponseEntity<OwnerDto> updateOwner(@Valid @RequestBody OwnerDto ownerDto,@PathVariable Integer ownerId){
		OwnerDto updatedOwner = this.ownerService.updateOwner(ownerDto, ownerId);
		return ResponseEntity.ok(updatedOwner);
	}
	
	@DeleteMapping("/{ownerId}")
	public ResponseEntity<ApiResponse> deleteOwner(@PathVariable Integer ownerId){
		this.ownerService.deleteOwner(ownerId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Deleted Successfully",true),HttpStatus.OK);
	}
	
	//Student----->
	
	@PostMapping("/student")
	public ResponseEntity<StudentDto> admitStudent(@Valid @RequestBody StudentDto studentDto){
		StudentDto admitStudent = this.ownerService.admitStudents(studentDto);
		return new ResponseEntity<StudentDto>(admitStudent,HttpStatus.CREATED);
	}
	
	@GetMapping("/student/{student_id}")
	public ResponseEntity<StudentDto> getStudents( @PathVariable Integer student_id){
		return ResponseEntity.ok(this.ownerService.getStudents(student_id));
	}
	
	//get Student By Name
		@GetMapping("/student/byName/{name}")
		public ResponseEntity<StudentDto> getStudentByName(@PathVariable String name){
			return ResponseEntity.ok(this.ownerService.getStudentsByName(name));
		}
	
	
	@DeleteMapping("/student/{student_id}")
	public ResponseEntity<ApiResponse> deleteStudent(@PathVariable Integer student_id){
		this.ownerService.deleteStudent(student_id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Student Deleted Successfully!!", true),HttpStatus.OK);
	}
	
	//Course ---->
	@PostMapping("/course")
	public ResponseEntity<CourseDto> addCourse(@RequestBody CourseDto courseDto){
		CourseDto addCourse = this.ownerService.addCourse(courseDto);
		return new ResponseEntity<CourseDto>(addCourse,HttpStatus.CREATED);
	}
	
	//Address --->
	@PostMapping("/student/{student_id}/address")
	public ResponseEntity<AddressDto> addCourse(
			@RequestBody AddressDto addressDto,
			@PathVariable Integer student_id
			){
		AddressDto addAddress = this.ownerService.addAddress(addressDto, student_id);
		return new ResponseEntity<AddressDto>(addAddress,HttpStatus.CREATED);
	}
	
}
