package project.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("services")
public class ServiceController {
	
	@GetMapping
	public String service() {
		return "services";
	}
}
