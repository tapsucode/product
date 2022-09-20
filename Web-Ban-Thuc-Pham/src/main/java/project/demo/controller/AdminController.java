package project.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import project.demo.dtos.ProductDtos;
import project.demo.dtos.UserDtos;
import project.demo.entity.Category;
import project.demo.entity.Product;
import project.demo.entity.User;
import project.demo.service.CategoryService;
import project.demo.service.ProductService;
import project.demo.service.UserService;

@RequestMapping("admin")
@Controller
public class AdminController {
	
	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;
	@Autowired 
	UserService userService;
	
	@GetMapping("/user")
	public String getUser(ModelMap model) {
		List<User> listUsers = (List<User>) userService.findAll();
		
		List<UserDtos> userDtos = new ArrayList<>();
		
		listUsers.forEach((item)-> {
			UserDtos userDto = new UserDtos(item.getId(), item.getUserName(), item.getPassword(), item.getFullName(), item.getEmail(), item.getPhone_number(), item.getAddress(), item.getRole().getName());
			userDtos.add(userDto);
		} );
		
		model.addAttribute("listUser", userDtos);
		return "admin/user";
	}
	
	@GetMapping("/product")
	public String listProduct(ModelMap model) {
		List<Product> listProduct = productService.findAll();
		model.addAttribute("listproduct", listProduct);
		return "admin/product-list";
	}
	
	@GetMapping("/product/add")
	public String addProduct(ModelMap model) {
		model.addAttribute("product", new ProductDtos());
		return "admin/product-add";
	}
	
	@PostMapping("product/save")
	public String saveProduct(ModelMap model,@ModelAttribute(value = "product") ProductDtos product) {
		
		Category category = categoryService.findById(product.getCategoryId()).get();
		Product product2 = new Product();		
		BeanUtils.copyProperties(product, product2);
		product2.setCategory(category);
		System.out.println(product2);
		
		productService.save(product2);
		return "admin/product-add";
	}
	
	@GetMapping("category")
	public String listCategory() {
		
		return "admin/category-list";
	}
	
	@GetMapping("/category/add")
	public String addCategory(ModelMap model) {
		model.addAttribute("category", new Category());
		return "admin/category-add";
	}
	
	@PostMapping("category/save")
	public String saveCategory(ModelMap model,@ModelAttribute(value = "category") Category category) {
		
		if (category.getName()==null) {
			return "admin/category-add";
		} else {
			List<Category> listCategories = categoryService.findAll();
			for (Category category2 : listCategories) {
				if (category2.getName().equals(category.getName())) {
					model.addAttribute("message","category was exist");
					return "admin/category-add";
				}
			}
		}
		categoryService.save(category);
		
		return "admin/category-add";
	}
	
	@ModelAttribute(name = "listCategory")
	public List<Category> getCategories(){
		return categoryService.findAll();
	}
}
