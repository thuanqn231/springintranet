package com.nttech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nttech.entity.Employee;

@Controller
@RequestMapping("/detail")
public class DetailController {

	@GetMapping
	public String Default() {
		return "detail";
	}
	
	@PostMapping
	public String showUser(@ModelAttribute Employee employee, ModelMap map) {
		map.addAttribute("employee", employee);
		return "detail";
	}
}
