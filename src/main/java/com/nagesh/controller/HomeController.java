package com.nagesh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nagesh.entity.Ride;
import com.nagesh.entity.User;
import com.nagesh.repository.Riderepositry;
import com.nagesh.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home() {
        return "home"; // home.jsp
    }
    @GetMapping("/profile")
    public String profilePage() {
        return "profile"; 
    }


    @GetMapping("/register")
    public String register() {
        return "register"; // register.jsp
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // login.jsp
    }
    
    @GetMapping("/info")
    public String info() {
    	return "info";
    }
    
    @GetMapping("/Help")
    public String Help() {
    	return "Help";
    }
    
    @GetMapping("ride")
    public String  ride() {
    	return "ride";
    }
    
   
    @GetMapping("/Self")
    public String Self() {
    	return "Self";
    }
    
    @GetMapping("/Cars")
    public String Cars(){
    	return "Cars";
    }
    
    @GetMapping("/Offers")
    public String Offers() {
    	return "Offers";
    }
    
    @GetMapping("/Privacy")
    public String Privacy() {
    	return "Privacy";
    }
    
    
    @GetMapping("/Terms")
    public String Terms() {
    	return "Terms";
    }
    
    @GetMapping("/About")
    public String About() {
    	return "About";
    }
    
    @GetMapping("/ridenow")
    public String ridenow() {
    	return "ridenow";
    }
    
    

   
    @PostMapping("/saveUser")
    public String registerUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/login"; 
    }

    @PostMapping("/userlogin")
    public String loginPage(@ModelAttribute User user, HttpSession session) {
    	
        User dbUser = userService.getUser(user.getEmail());

        System.out.println(dbUser.getEmail());
        if (dbUser != null && user.getPassword().equals(dbUser.getPassword())) {
        	
            return "profile"; 
        } else {
        	
   
        	session.setAttribute("msg", "PASSWORD IS INCOREECT");
        	System.out.println("login failed");
            return "login"; 
        }
    }
}
