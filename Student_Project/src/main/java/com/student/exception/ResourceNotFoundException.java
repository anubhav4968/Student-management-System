package com.student.exception;

public class ResourceNotFoundException extends RuntimeException{
	
	String resourseName;
	String fieldName;
	long fieldValue;
	
	
	public ResourceNotFoundException(String resourseName, String fieldName, long fieldValue) {
		super( String.format("%s Not found with %s : %s",resourseName, fieldName , fieldValue));
		this.resourseName = resourseName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
}
