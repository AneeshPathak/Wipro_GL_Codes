package com.wipro.WiproSpringboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

    private final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/home")
    public String home(Model model, HttpSession session) {
        Object username = session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }
        model.addAttribute("fullName", session.getAttribute("fullName"));
        model.addAttribute("users", userService.findAll());
        model.addAttribute("newUser", new User());
        return "home";
    }

    @PostMapping("/users/add")
    public String addUser(@ModelAttribute User newUser, Model model) {
        if (newUser.getUsername()==null || newUser.getUsername().trim().isEmpty()) {
            model.addAttribute("error", "Username is required");
            model.addAttribute("users", userService.findAll());
            model.addAttribute("newUser", newUser);
            return "home";
        }
        userService.register(newUser);
        return "redirect:/home";
    }
}
