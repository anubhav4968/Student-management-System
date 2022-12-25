package com.student.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int student_id;
	
	@Column(name="Student_Name" , nullable = false, length = 100)
	private String name;
	
	@Column(name = "Dob" , nullable = false, length=100)
	private String dateOfBirth;
	
	@Column(name = "Gender", nullable = false , length=10)
	private String gender;
	
	@Column(name = "Student_Email", nullable = false , length=100)
	private String email;
	
	@Column(name = "Student_Password", nullable = false, length=15)
	private String password;
	
	@Column(name = "Student_Mobile_Number" , nullable = false, length=10)
	private String mobileNumber;
	
	@Column(name ="Parents_Name", nullable = false, length=100)
	private String parentsName;
	
	
	
	@OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
	private List<Address> address = new ArrayList<>();
}
