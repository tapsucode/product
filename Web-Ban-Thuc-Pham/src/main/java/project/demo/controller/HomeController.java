package project.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import project.demo.entity.Category;
import project.demo.entity.Product;
import project.demo.service.CategoryService;
import project.demo.service.ProductService;

@Controller
@RequestMapping("")
public class HomeController {
	
	@Autowired
	CategoryService categoryService;
	@Autowired
	ProductService productService;
	
	@GetMapping("/home")
	public String getHome(ModelMap model) {
		
		List<Product> topProducts = productService.findTopProducts();
		
		model.addAttribute("topProducts", topProducts);
		
		return "home/home";
	}
	
	@ModelAttribute(name = "listCategory")
	public List<Category> getCategories(){
		return categoryService.findAll();
	}
}
