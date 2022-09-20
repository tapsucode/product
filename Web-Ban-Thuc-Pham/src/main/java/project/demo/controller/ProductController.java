package project.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import project.demo.entity.Category;
import project.demo.entity.Product;
import project.demo.service.CategoryService;
import project.demo.service.ProductService;

@Controller
@RequestMapping("products")
public class ProductController {
	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/all")
	public String getProducts(ModelMap model) {
		
		List<Product> products = productService.findAll();
		
		model.addAttribute("products", products);
		
		return "products";
	}
	
	@GetMapping("/category/{id}")
	public String getCategoryProducts(ModelMap modelMap,@PathVariable(name = "id") Integer Id ) {
		
		List<Product> CategoryProducts = productService.findByCategoryId(Id);
			
		modelMap.addAttribute("products", CategoryProducts);
		
		
		return getProducts(modelMap);
	}
	
	@GetMapping("/hot")
	public String getHome(ModelMap model) {
		
		List<Product> topProducts = productService.findTopProducts();
			
		model.addAttribute("products", topProducts);
		
		return getProducts(model);
	}
	
	@RequestMapping(value = "/search",method = RequestMethod.POST)
	public String searchProducts(ModelMap model,@RequestParam (defaultValue = "") String name) {
		List<Product> searchProducts = productService.findByTitleLike(name);
		
		model.addAttribute("products", searchProducts);
		return getProducts(model);
	}

	
	@ModelAttribute(name = "listCategory")
	public List<Category> getCategories(){
		return categoryService.findAll();
	}
}
