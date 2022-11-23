package com.employee.management.service;

import java.util.List;

import com.employee.management.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public Employee findbyId(int theId);

	public void save (Employee theEmployee);
	
	public void deleteById(int theId);
}
