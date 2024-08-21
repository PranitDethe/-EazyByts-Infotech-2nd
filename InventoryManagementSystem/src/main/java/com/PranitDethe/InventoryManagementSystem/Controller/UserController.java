package com.PranitDethe.InventoryManagementSystem.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.PranitDethe.InventoryManagementSystem.Model.User;
import com.PranitDethe.InventoryManagementSystem.Service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute User user, Model model) {
        User loggedInUser = userService.loginUser(user.getUsername(), user.getPassword());
        if (loggedInUser != null) {
            return "redirect:/home";
        } else {
            model.addAttribute("msg", "Invalid credentials");
            return "login";
        }
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model) {
        if (userService.registerUser(user) != null) {
            return "redirect:/login";
        } else {
            model.addAttribute("msg", "Registration failed");
            return "login";
        }
    }

    @GetMapping("/home")
    public String homePage() {
        return "home";
    }
}