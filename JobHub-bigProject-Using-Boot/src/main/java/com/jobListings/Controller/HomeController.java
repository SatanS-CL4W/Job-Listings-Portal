// HomeController.java
package com.jobListings.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jobListings.Entity.User;
import com.jobListings.Repositories.UserRepository;

import jakarta.validation.Valid;

@Controller
public class HomeController {
    
	
//	private final BCryptPasswordEncoder passwordEncoder;
	
    @Autowired
    private UserRepository userRepository;
    
    
//    public HomeController(BCryptPasswordEncoder passwordEncoder) {
//        this.passwordEncoder = passwordEncoder;
//    }
    
    @GetMapping("/")
    public String homePage(Model m) {
        
        m.addAttribute("title", "Home - Job Listings Portal");
        return "home";    
    }
    
    @GetMapping("/about")
    public String about(Model m) {
        
        m.addAttribute("title", "About - Job Listings Portal");
        return "about";
    }
    
    @GetMapping("/signup")
    public String signup(Model m) {
        
        m.addAttribute("title", "SignUp - Job Listings Portal");
        m.addAttribute("user", new User()); // Add an empty User object to the model
        
        return "signup";
    }
    
    @PostMapping("/doRegister")
    public String dataHandler(@Valid @ModelAttribute("user") User user, BindingResult result, Model m) {
        
        if(result.hasErrors()) {
            m.addAttribute("user", user);
            return "signup";
        }
        user.setRole("Default");
        
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
        
        userRepository.save(user);
        
        m.addAttribute("message", "User Registered Successfully!!!");
        return "login";
    }

    
    @PostMapping("/doLogin") // This method handles login form submission
    public String loginSubmit(Model m) {
        // Handle login logic here if needed
        return "redirect:/user/index"; // Redirect to a success page after login
    }
    
    
    @GetMapping("/login")
    public String login(Model m) {
        
        m.addAttribute("title", "Login - Job Listings Portal");
        m.addAttribute("user", new User()); // Add an empty User object to the model

        return "login";
    }
    
   
    
    @GetMapping("/jobs")
    public String JobsListings(Model m) {
        
        m.addAttribute("title", "Jobs - Job Listings Portal");
        return "jobs";
    }
}