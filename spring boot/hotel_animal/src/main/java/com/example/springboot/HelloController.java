package com.example.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

//@RestController
@Controller
public class HelloController {

	@RequestMapping("/")
	public String index() {
		return "index";//"Greetings from Spring Boot!";
	}
}
