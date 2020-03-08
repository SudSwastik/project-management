package com.sudarshan.sud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sudarshan.sud.entities.Employee;
import com.sudarshan.sud.repositories.IEmployeeRepository;

@Controller
public class EmployeeController {
	
	@Autowired
	IEmployeeRepository employeeRepository;
	
	@GetMapping("/employees")
	public String displayEmployees(Model model) {
		List<Employee> employees = employeeRepository.findAll();
		model.addAttribute("employees", employees);
		return "list-employees";
	}
	
	@GetMapping("/new/employee")
	public String displayEmployeeForm(Model model) {
		
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "new-employee";
	}
	
	@PostMapping("/save/employee")
	public String createEmployee(Model model, Employee employee) {
		// save to the database using an employee crud repository
		employeeRepository.save(employee);
		return "redirect:/new/employee";
	}
	
}