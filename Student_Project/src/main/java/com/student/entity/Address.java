package com.student.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Student_Address")
public class Address {

	@Id
	private int address_id;
	
	@Column(name = "Area",nullable = false, length=50)
	private String area;
	
	@Column(name = "State" , nullable = false, length=50)
	private String state;
	
	@Column(name = "District", nullable = false, length=50)
	private String district;
	
	@Column(name = "Pincode", nullable = false, length=15)
	private String pincode;
	
	@Column(name = "Address_Type" ,nullable = false, length=50)
	private String addressType;
	
	@ManyToOne
	@JoinColumn(name="Student_id")
	private Student student;
	
}
