package com.employee.management.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.employee.management.entity.Employee;
import com.employee.management.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	private EmployeeService employeeService;
	
public EmployeeController(EmployeeService theEmployeeService) {
	
	employeeService = theEmployeeService;
	
}

@GetMapping("/list")
public String listEmployee(Model theModel) {
	
	List <Employee> theEmployee = employeeService.findAll();
	
	theModel.addAttribute("employee", theEmployee);
	
	
	return "employee/list-employees";
	}

@GetMapping("/showForm")
public String showForm(Model theModel) {
	
	Employee theEmployee = new Employee();
	
	theModel.addAttribute("employee", theEmployee);
	
	return "employee/employee-form";
}



@PostMapping("/save")
public String save(@ModelAttribute("employee") Employee theEmployee) {
	
	employeeService.save(theEmployee);
	
	return "redirect:/employees/list";
}


@GetMapping("/showFormUpdate")
public String showFormUpdate(@RequestParam("employeeId") int theId, Model theModel) {
	
	Employee theEmployee = employeeService.findbyId(theId);
	
	theModel.addAttribute("employee", theEmployee);
	
	return "employee/employee-form";
}

@GetMapping("/delete")
public String delete(@RequestParam("employeeId") int theId) {
	
	employeeService.deleteById(theId);
	
	return "redirect:/employees/list";
}






}
