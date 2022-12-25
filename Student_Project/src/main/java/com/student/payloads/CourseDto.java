package com.student.payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CourseDto {

	private int courseId;
	
	@NotEmpty
	@Size(min=4,message ="Length must be min of 4 char!!!!")
	private String courseName;
	
	@NotEmpty
	@Size(min=10,message ="Length must be min of 10 char!!!!")
	private String description;
	
	private String duration;
	
	private String courseType;
	
	
}
