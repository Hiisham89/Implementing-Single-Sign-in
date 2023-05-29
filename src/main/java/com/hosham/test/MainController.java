package com.hosham.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	
	@GetMapping("/demo")
	public String string() {
		return "hello world spring";
	}

}
