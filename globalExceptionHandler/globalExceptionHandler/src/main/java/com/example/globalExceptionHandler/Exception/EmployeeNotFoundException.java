package com.example.globalExceptionHandler.Exception;

public class EmployeeNotFoundException extends RuntimeException{

	
	public EmployeeNotFoundException(String message)
	{
		super(message);
	}
}
