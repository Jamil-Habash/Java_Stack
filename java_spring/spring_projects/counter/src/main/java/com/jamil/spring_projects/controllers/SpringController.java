package com.jamil.spring_projects.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.servlet.http.HttpSession;


@Controller
public class SpringController {
	@RequestMapping("/counter")
	public String index(HttpSession session) {
		return "index";
	}
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		session.setAttribute("count", 0);
		return "index";
	}

	@RequestMapping("/")
	public String welcomeTemp(HttpSession session) {
		if(session.getAttribute("count") == null){
			session.setAttribute("count", 1);
		} else {
			int times = (Integer)session.getAttribute("count");
			times += 1;
			session.setAttribute("count", times);
		}
		return "welcome";
	}
	
}
