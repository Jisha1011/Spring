package com.example.globalExceptionHandler.Repository;

import org.springframework.stereotype.Repository;

import com.example.globalExceptionHandler.Entity.Employee;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{

	List<Employee>findById(int id);
	
	@NativeQuery("SELECT * FROM employee e where e.name= :name")
	Employee findByName(@Param("name") String name);
	
		
}
