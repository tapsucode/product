package project.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import project.demo.entity.Category;
import project.demo.entity.Feedback;
import project.demo.service.CategoryService;
import project.demo.service.FeedbackService;

@Controller
@RequestMapping()
public class ContactController {
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	FeedbackService feedbackService;
	
	@GetMapping("/contact")
	public String contact(ModelMap model) {
		model.addAttribute("Feedback", new Feedback());
		return "mail";
	}
	
	@PostMapping("/contact/add" )
	public String addFeedback(ModelMap model,Feedback feedback) {
		feedbackService.save(feedback);
		model.addAttribute("Feedback", new Feedback());
		return "redirect:/contact";
	}
	
	@ModelAttribute(name = "listCategory")
	public List<Category> getCategories(){
		return categoryService.findAll();
	}
}
