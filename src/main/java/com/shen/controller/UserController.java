package com.shen.controller;

import com.shen.mapper.UserMapper;
import com.shen.pojo.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;


@Controller
public class UserController {

    @Autowired
    private UserMapper userMapper;

    // Home page
    @RequestMapping("/")
    public String index() {
        return "index";  // This could be an HTML or Thymeleaf template
    }

    // Login page
    @RequestMapping("/login")
    public String login() {
        return "login"; // Return the login page
    }

    // Registration page
    @RequestMapping("/register")
    public String register() {
        return "register"; // Return the register page
    }

    // User registration logic
    @PostMapping("/register")
    public String registerUser(@RequestParam("id") String id, @RequestParam("password") String password, Model model) {
        User user = new User();
        user.setId(id);
        user.setPassword(password);

        // Insert user into the database
        userMapper.insertUser(user);

        // Add success message to the model
        model.addAttribute("message", "注册成功!");

        return "register"; // Redirect or return to the registration page (template)
    }


    // User login logic
    @PostMapping("/login")
    public String loginUser(@RequestParam("id") String id, @RequestParam("password") String password, Model model,HttpSession session) {
        User user = userMapper.getUserById(id);
        if (user != null && user.getPassword().equals(password)) {
            // Successful login
            model.addAttribute("message", "login success!");

            session.setAttribute("loginUser",id);

            return "welcome";  // Redirect to a welcome page or dashboard
        } else {
            // Invalid credentials
            model.addAttribute("error", "Invalid ID or password!");
            return "login";  // Stay on the login page
        }
    }
}
