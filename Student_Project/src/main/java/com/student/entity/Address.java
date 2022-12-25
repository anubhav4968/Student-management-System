package com.student.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressId;

	@Column(nullable = false,length=50)
	private String area;
	
	@Column(nullable = false,length=50)
	private String state;
	
	@Column(nullable = false,length=50)
	private String district;
	
	@Column(nullable = false,length=50)
	private String pincode;
	
	@Column(nullable = false,length=50)
	private String addressType;
	
	@ManyToOne
	@JoinColumn(name="Student_id")
	private Student student;
}
