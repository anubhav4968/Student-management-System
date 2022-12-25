package com.student.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int courseId;
	
	@Column(nullable = false,length=20)
	private String courseName;
	
	@Column(nullable = false,length=100)
	private String description;
	
	@Column(nullable = false,length=20)
	private String duration;
	
	@Column(nullable = false,length=20)
	private String courseType;
	
}
