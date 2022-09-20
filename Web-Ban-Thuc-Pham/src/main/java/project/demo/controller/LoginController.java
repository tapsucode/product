package project.demo.controller;


import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import project.demo.entity.Category;
import project.demo.entity.Product;
import project.demo.entity.Role;
import project.demo.entity.User;
import project.demo.service.CategoryService;
import project.demo.service.ProductService;
import project.demo.service.RoleService;
import project.demo.service.UserService;


@Controller
@RequestMapping("login")
public class LoginController {
	
	@Autowired
	EntityManagerFactory entityManagerFactory;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	RoleService roleService;
	
	@GetMapping("")
	public String login(ModelMap model) {
		model.addAttribute("user", new User());
		model.addAttribute("messagea", null);
		return "/login";
	}
	
	@PostMapping("")
	public String loginForm(ModelMap model,@RequestParam(name = "Username",defaultValue = "") String username,
		@RequestParam(name = "Password",defaultValue = "") String password) {
		
		List<User> listUsers = (List<User>) userService.findAll();
		
		for (User user : listUsers) {
			if (user.getUserName().equals(username)) {
				if (user.getPassword().equals(password)) {
					List<Product> topProducts = productService.findTopProducts();
					model.addAttribute("topProducts", topProducts);
					model.addAttribute("user", user);
					
					return "redirect:/home";
				} else {
					model.addAttribute("message", "Password không đúng");
					model.addAttribute("user", new User());
					return "login";
				}
			}		
		}
		model.addAttribute("message", "User không tồn tại");
		model.addAttribute("user", new User());
		return "login";		
	}
	@Transactional
	@PostMapping("/dangky")
	public String register(ModelMap model,User user ) {
		
		Role role = roleService.findOneById(2);
		
		user.setRole(role);
		
		List<User> listUsers = (List<User>) userService.findAll();
		for (User user1 : listUsers) {
			System.out.println(user1);
			if (user1.getUserName().equals(user.getUserName())) {
				model.addAttribute("messagea", "User đã tồn tại");
				model.addAttribute("user", new User());
				
				return "redirect:/login";
			} 
		}
		
		List<Product> topProducts = productService.findTopProducts();
		model.addAttribute("topProducts", topProducts);
		model.addAttribute("user", user);
			
		Session session = entityManagerFactory.createEntityManager().unwrap(Session.class);
		System.out.println(user);
		session.save(user);
		
		
		return "redirect:/home";
		
	}
	
	@ModelAttribute(name = "listCategory")
	public List<Category> getCategories(){
		return categoryService.findAll();
	}
	
}
