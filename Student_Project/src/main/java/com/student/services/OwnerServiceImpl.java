package com.student.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.entity.Address;
import com.student.entity.Course;
import com.student.entity.Owner;
import com.student.entity.Student;
import com.student.exception.ResourseNotFoundException;
import com.student.payloads.AddressDto;
import com.student.payloads.CourseDto;
import com.student.payloads.OwnerDto;
import com.student.payloads.StudentDto;
import com.student.repository.AddressRepo;
import com.student.repository.CourseRepo;
import com.student.repository.OwnerRepo;
import com.student.repository.StudentRepo;

@Service
public class OwnerServiceImpl implements OwnerService{

	@Autowired
	private OwnerRepo ownerRepo;
	
	@Autowired
	private ModelMapper  modelMapper;
	
	//Owner
		public Owner dtoToOwner(OwnerDto ownerDto) {
			Owner owner = this.modelMapper.map(ownerDto, Owner.class);
			return owner;
		}
		
		//
		public OwnerDto ownerToDto(Owner owner) {
			OwnerDto ownerDto = this.modelMapper.map(owner, OwnerDto.class);
			return ownerDto;
		}

	@Override
	public OwnerDto addOwner(OwnerDto ownerDto) {

		Owner owner = this.dtoToOwner(ownerDto);
		Owner savedOwner=this.ownerRepo.save(owner);
		return this.ownerToDto(savedOwner);

	}

	@Override
	public OwnerDto updateOwner(OwnerDto ownerDto, Integer ownerId) {
		
		Owner owner = this.ownerRepo.findById(ownerId).orElseThrow(()-> new ResourseNotFoundException("Owner", "OwnerId", ownerId));
		owner.setEmail(ownerDto.getEmail());
		owner.setName(ownerDto.getName());
		owner.setPassword(ownerDto.getPassword());
		
		Owner updatedOwner = this.ownerRepo.save(owner);
		
		return this.ownerToDto(updatedOwner);
	}

	@Override
	public void deleteOwner(Integer ownerId) {
		
		Owner owner = this.ownerRepo.findById(ownerId).orElseThrow(()-> new ResourseNotFoundException("Owner", "OwnerId", ownerId));
		this.ownerRepo.delete(owner);
	}

	@Override
	public Owner findByEmailAndPassword(String userEmial, String password) {
		List<Owner> owner_list= ownerRepo.findAll();
		for(Owner own:owner_list) {
			if(own.getEmail().equals(userEmial) && own.getPassword().equals(password)) {
				return own;
			}
		}
		return null;
	}
	
	//Student
		public Student dtoToStudent(StudentDto studentDto) {
			Student student = this.modelMapper.map(studentDto, Student.class);
			return student;
		}
		
		//
		public StudentDto studentToDto(Student student) {
			StudentDto studentDto = this.modelMapper.map(student, StudentDto.class);
			return studentDto;
		}

		@Autowired
		private StudentRepo studentRepo;
		@Override
		public StudentDto admitStudents(StudentDto studentDto) {
			Student student = this.dtoToStudent(studentDto);
			Student savedStudent = this.studentRepo.save(student);
			return this.studentToDto(savedStudent);
		}
	
		@Override
		public StudentDto getStudents(Integer student_id) {
			Student user = this.studentRepo.findById(student_id).orElseThrow(()->new ResourseNotFoundException("User" ,"Id",student_id));
			return this.studentToDto(user);
		}
	
		@Override
		public void deleteStudent(Integer student_id) {
			Student student = this.studentRepo.findById(student_id).orElseThrow(()-> new ResourseNotFoundException("Student", "Id",student_id));
			this.studentRepo.delete(student);;
			
		}
	
		@Override
		public StudentDto getStudentsByName(String name) {
			
			List<Student> list = this.studentRepo.findAll();
			for(Student stu: list) {
				if(stu.getName().equalsIgnoreCase(name)) {
					return this.studentToDto(stu);
				}
			}
			return null;
		}
		
		//Course ---->
		
		@Autowired
		private CourseRepo courseRepo;
		
		public Course dtoToCourse(CourseDto dto) {
			
			Course course = this.modelMapper.map(dto,Course.class);
			 return course;
		}
		
		public CourseDto courseToDto(Course user) {
			CourseDto dto = this.modelMapper.map(user, CourseDto.class);
			return dto;
		}

		@Override
		public CourseDto addCourse(CourseDto courseDto) {
			
			Course course =this.dtoToCourse(courseDto);
			Course addCourse=this.courseRepo.save(course);
			
			
			return this.courseToDto(addCourse);
		}

		
        //Address ----->
		
		@Autowired
		private AddressRepo addressRepo;
		
        public Address dtoToAddress(AddressDto dto) {
			
        	Address address = this.modelMapper.map(dto,Address.class);
			 return address;
		}
		
		public AddressDto addressToDto(Address user) {
			AddressDto dto = this.modelMapper.map(user, AddressDto.class);
			return dto;
		}
		
		@Override
		public AddressDto addAddress(AddressDto addressDto, Integer student_id) {
			Address address =this.dtoToAddress(addressDto);
			
			Student student = this.studentRepo.findById(student_id).orElseThrow(()->new ResourseNotFoundException("Student", "StudentId", student_id));
			
			address.setStudent(student);
			
			Address newAddress = this.addressRepo.save(address);
			return this.addressToDto(newAddress);
		}
	
	
}