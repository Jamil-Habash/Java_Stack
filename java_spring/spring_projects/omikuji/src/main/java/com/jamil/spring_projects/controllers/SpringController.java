package com.jamil.spring_projects.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class SpringController {
	@RequestMapping("/omikuji")
	public String index(HttpSession session) {
		return "index";
	}

	@PostMapping("/omikuji/grace")
	public String submitForm(HttpSession session, @RequestParam(value="number") Integer number, @RequestParam(value="city") String city,
	@RequestParam(value="person") String person,@RequestParam(value="hobby") String hobby,@RequestParam(value="living") String living,
	@RequestParam(value="desc") String desc) {

		session.setAttribute("number", number);
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("hobby", hobby);
		session.setAttribute("living", living);
		session.setAttribute("desc", desc);
		return "redirect:/omikuji/show";
	}

	@RequestMapping("/omikuji/show")
	public String showTemp() {
		return "show";
	}
	
	
}
