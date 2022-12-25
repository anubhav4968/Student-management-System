package com.student.exception;

public class NullValueException extends Exception{

	String resourseName;
	public NullValueException(String resourseName) {
		super( String.format("%s Not found with %s : %s",resourseName));
		this.resourseName = resourseName;
		
	}
}
