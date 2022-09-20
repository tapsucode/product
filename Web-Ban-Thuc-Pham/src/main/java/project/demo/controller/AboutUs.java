package project.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("about-us")
public class AboutUs {
	
	@GetMapping()
	public String aboutUs() {
		return "about";
	}
}
