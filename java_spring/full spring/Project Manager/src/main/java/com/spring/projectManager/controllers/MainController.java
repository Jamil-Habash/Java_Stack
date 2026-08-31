package com.spring.projectManager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.validation.BindingResult;
import com.spring.projectManager.models.*;
import com.spring.projectManager.repositories.*;
import com.spring.projectManager.services.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.validation.Valid;



@Controller
public class MainController {
    @Autowired
    private UserService userService;
    @Autowired
    private ProjectService projectService;

    @RequestMapping("/")
    public String showLogin(Model model, HttpServletRequest request) {
        model.addAttribute("loginUser", new LoginUser());
        model.addAttribute("user", new User());
        model.addAttribute("currentUrl", request.getRequestURI());

        return "index";
    }

    @RequestMapping("/register")
    public String showRegister(Model model, HttpServletRequest request) {
        model.addAttribute("user", new User());
        model.addAttribute("loginUser", new LoginUser());
        model.addAttribute("currentUrl", request.getRequestURI());

        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginUser(
            @Valid @ModelAttribute("loginUser") LoginUser loginUser,
            BindingResult result,
            Model model,
            HttpSession session) {

        User user = userService.login(loginUser, result);

        if (result.hasErrors()) {
            model.addAttribute("user", new User());
            return "redirect:/";
        }

        session.setAttribute("userId", user.getId());
        session.setAttribute("firstName", user.getFirstName());
        session.setAttribute("email", user.getEmail());

        return "redirect:/dashboard";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(
            @Valid @ModelAttribute("user") User user,
            BindingResult result,
            Model model,
            HttpSession session) {

        User newUser = userService.register(user, result);

        if (result.hasErrors()) {
            model.addAttribute("loginUser", new LoginUser());
            return "redirect:/";
        }

        session.setAttribute("userId", newUser.getId());
        session.setAttribute("firstName", newUser.getFirstName());
        session.setAttribute("email", newUser.getEmail());

        return "redirect:/dashboard";
    }


    @RequestMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {

        Object userId = session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/";
        }
        Long id = Long.parseLong(userId.toString());

        User user = userService.findUserById(id);
        List<Project> allProjects = projectService.allProjects();
        List<Project> availableProjects = allProjects.stream()
                .filter(project -> !user.getProjects().contains(project))
                .collect(Collectors.toList());

        List<Project> userProjects = user.getProjects();

        model.addAttribute("availableProjects", availableProjects);
        model.addAttribute("userProjects", userProjects);
        model.addAttribute("user", user);

        return "dashboard";
    }


    @RequestMapping("/addToList/{id}")
    public String joinTeam(
            HttpSession session,
            @PathVariable("id") Long projectId) {

        Object userId = session.getAttribute("userId");

        if (userId == null) {
            return "redirect:/";
        }

        Long idUser = Long.parseLong(userId.toString());

        User user = userService.findUserById(idUser);
        Project project = projectService.findProject(projectId);

        if (!user.getProjects().contains(project)) {
            user.getProjects().add(project);
            userService.updateUser(user);
        }

        return "redirect:/dashboard";
    }


    @RequestMapping("/leaveTeam/{id}")
    public String leaveTeam(
            HttpSession session,
            @PathVariable("id") Long projectId) {

        Object userId = session.getAttribute("userId");

        if (userId == null) {
            return "redirect:/";
        }

        Long idUser = Long.parseLong(userId.toString());

        User user = userService.findUserById(idUser);
        Project project = projectService.findProject(projectId);

        if (project.getTeamLead() != null &&
            project.getTeamLead().getId().equals(user.getId())) {

            return "redirect:/dashboard";
        }

        user.getProjects().remove(project);
        project.getUsers().remove(user);

        userService.updateUser(user);

        return "redirect:/dashboard";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
    
    @RequestMapping("/projects/new")
    public String renderAddPreojectForm(HttpSession session, Model model) {
        Object userId = session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/";
        }
        model.addAttribute("project", new Project());
        return "new";
    }

    @RequestMapping(value="/projects/new", method=RequestMethod.POST)
    public String createProject( @Valid @ModelAttribute("project") Project project,
            BindingResult result,
            Model model,
            HttpSession session) {
        Object userId = session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/";
        }
        Long idUser = Long.parseLong(userId.toString());

        User user = userService.findUserById(idUser);
        project.setTeamLead(user);
        Project newProject = projectService.createProject(project);
        if (result.hasErrors()) {
            model.addAttribute("project", new Project());
            return "redirect:/projects/new";
        }

        return "redirect:/dashboard";
    }
    
    
}
