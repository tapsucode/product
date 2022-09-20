package project.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.demo.entity.Product;
import project.demo.service.ProductService;

@Controller
public class SingleController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(value = "/single",method = RequestMethod.GET)
	public String getSingle() {
		return "redirect : /products/all";
	}
	
	@RequestMapping(value = "/single/{id}" ,method = RequestMethod.GET)
	public String getSingleByID(ModelMap model,@PathVariable(value = "id") int id ) {
		
		Product singleProduct = productService.findOneById(id);
		
		if (singleProduct==null) {
			
			return "redirect : /products/all";
	
		} else {
			model.addAttribute("single", singleProduct);
			return "single";
		}
		
	}
}
