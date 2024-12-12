package com.example.globalExceptionHandler.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.globalExceptionHandler.Entity.Employee;

import com.example.globalExceptionHandler.Service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService empService;

	@GetMapping("/findEmployee/{id}")
	public ResponseEntity<Optional<List<Employee>>> findEmployee(@PathVariable int id) {

		var employee = empService.findById(id);

		return ResponseEntity.ok(employee);
	}
	@GetMapping("/findEmployee/name/{name}")
	public ResponseEntity<Employee> findEmployeeByName(@PathVariable String name){
		
		var employee = empService.findEmployeeByName(name);
		return ResponseEntity.ok(employee);
	}
}
