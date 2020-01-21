package com.spring5.practice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring5.practice.model.Course;
import com.spring5.practice.service.CourseSercvice;

@Controller
public class CourseController {

	@Autowired
	private CourseSercvice courseService;

	@GetMapping("/course/add")
	public String addCourse_GET(Model model) {
		model.addAttribute("course", new Course());
		model.addAttribute("message", "Please add a course");
		return "course/add";
	}

	@PostMapping("/course/add")
	public String addCourse(Model model, @ModelAttribute(name = "course") Course course) {
		courseService.addCourse(course);
		model.addAttribute("message", "Course added successfully");
		return "redirect:/course/show-all";
	}

	@GetMapping("/course/show-all")
	public String showAll_GET(Model model) {
		model.addAttribute("courses", courseService.getAll());
		model.addAttribute("message", "Showing all courses");
		return "course/show-all";
	}

}
