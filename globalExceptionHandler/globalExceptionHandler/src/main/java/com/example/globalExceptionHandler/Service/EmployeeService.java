package com.example.globalExceptionHandler.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.globalExceptionHandler.Entity.Employee;
import com.example.globalExceptionHandler.Exception.EmployeeNotFoundException;
import com.example.globalExceptionHandler.Repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository repo;

	public Optional<List<Employee>> findById(int id) {
		var employee = repo.findById(id);
		System.out.println(employee.isEmpty());
		if (employee.isEmpty())
			throw new EmployeeNotFoundException("Employee with the id not found");
		return Optional.ofNullable(employee);

	}
	
	public Employee findEmployeeByName(String name) {
		Employee employee = repo.findByName(name);
		if (employee==null)
			throw new EmployeeNotFoundException("Employee with name "+name+" not found");
		return employee;
	}
}
