package com.nttech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {

	@GetMapping
	public String Default() {
		return "login";
	}
	
	@PostMapping
	public String Login(@RequestParam String userName, @RequestParam String passWord) {
		if(userName.equals("thuan.ng") && passWord.equals("191291")) {
			return "redirect:/";
		}else {
			return "login";
		}
		
	}
}
