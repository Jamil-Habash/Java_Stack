package com.spring.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.spring.demo.models.*;
import com.spring.demo.repositories.DojoRepository;
import com.spring.demo.repositories.NinjaRepository;
import com.spring.demo.services.*;
import jakarta.servlet.http.HttpSession;
import java.util.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.validation.Valid;



@Controller
public class MainController {
    @Autowired
    private DojoService dojoService;
    @Autowired
    private NinjaService ninjaService;

    @RequestMapping(value="/dojos/new", method=RequestMethod.POST)
    public String addDojo(
        @Valid @ModelAttribute("dojo") Dojo dojo,
        BindingResult result,
        Model model) {

    if(result.hasErrors()) {
        model.addAttribute("dojos", dojoService.allDojos());
        return "index";
    }

    dojoService.createDojo(dojo);
    return "redirect:/dojos";
    }

    @RequestMapping(value="/ninjas/new", method=RequestMethod.POST)
    public String addNinja(
        @Valid @ModelAttribute("ninja") Ninja ninja,
        BindingResult result,
        Model model) {

    if(result.hasErrors()) {
        model.addAttribute("ninjas", ninjaService.allNinjas());
        return "index";
    }

    ninjaService.createNinja(ninja);
    return "redirect:/dojos";
    }

    @RequestMapping("/dojos")
    public String showAllDojos(Model model) {
        List<Dojo> dojos = dojoService.allDojos();
        model.addAttribute("dojos", dojos);
        model.addAttribute("dojo", new Dojo());
        return "index";
    }
    
    
    @RequestMapping("/dojos/{id}")
    public String showDojo(HttpSession session,@PathVariable("id") Long id) {
        Dojo dojo = dojoService.findDojo(id);
        session.setAttribute("id", id);
        session.setAttribute("name", dojo.getName());
        session.setAttribute("ninjas", dojo.getNinjas());
        return "ninjas";
    }
    
}
