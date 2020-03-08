package com.sudarshan.sud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sudarshan.sud.entities.Employee;
import com.sudarshan.sud.entities.Project;
import com.sudarshan.sud.repositories.IEmployeeRepository;
import com.sudarshan.sud.repositories.IProjectRepository;

@Controller
public class HomeController {
	
	
	@Autowired
	IProjectRepository projectRepository;
	
	@Autowired
	IEmployeeRepository employeeRepository;
	


	@GetMapping("/")
	public String displayHome(Model model){
		
		
		// we are querying the database for projects
		List<Project> projectsList = projectRepository.findAll();
		model.addAttribute("projectsList", projectsList);
		
		// we are querying the database for employees
		List<Employee> employeesList = employeeRepository.findAll();
		model.addAttribute("employeesList", employeesList);
		
		
		return "home";
		
	}
}