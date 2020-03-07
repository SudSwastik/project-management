package com.sudarshan.sud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sudarshan.sud.entities.Project;
import com.sudarshan.sud.repositories.IProjectRepository;

@Controller
public class ProjectController {
	
	@Autowired
	IProjectRepository projectRepository;
	
	@GetMapping("/new/project")
	public String displayProjectForm (Model model){
		 Project project = new Project();
		 model.addAttribute("project", project);
		return "new-project";
	}
	
	@PostMapping("/save/project")
	public String saveProjectForm (Project project, Model model){
		projectRepository.save(project);
		return "redirect:/new/project";
	}

}
