package com.student.payloads;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class OwnerDto {

    private int id;
	
	@NotEmpty
	@Size(min=4,message="Name must be 4 char!!!!!")
	private String name;
	
	@NotEmpty
	@Email(message = "Please Enter Valid Email")
	private String email;
	

	@NotEmpty
	@Size(min = 4,max=10,message="Password must be min of 4 chars or maz of 10 chars")
	@Pattern(regexp="[a-zA-Z0-9]{6,12}",message="Password must contain between 6 to 12 characters. Must be alphanumeric with both Upper and lowercase characters.")
	private String password;
}
