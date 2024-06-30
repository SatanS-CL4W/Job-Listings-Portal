package com.jobListings.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jobListings.Entity.User;
import com.jobListings.Entity.UserResume;
import com.jobListings.Repositories.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;

	
	@GetMapping("/index")
	public String dashboard(Model m) {
		m.addAttribute("title", "Home: Dashboard");
		
		return "normal/user_dashboard";
	}
	
	@GetMapping("/work-with-us")
	public String WorkWithUs(Model m) {
		
		m.addAttribute("title", "Work with Us");
		return "normal/work-with-us";
	}
	
	@GetMapping("/add-resume")
	public String AddResume(Model m) {
		m.addAttribute("title", "Add Resume");
		m.addAttribute("user-resume", new UserResume());
		
		return "normal/resume";
	}
	
	@PostMapping("/process-resume")
	public String processResume(@ModelAttribute UserResume userResume, @RequestParam("email") String email,
	                            BindingResult result) {
	    User user = this.userRepository.findByEmail(email);
	    
	    userResume.setUser(user);
	    
	    user.getJobLists().add(userResume);
	    
	    this.userRepository.save(user);
	    
	    System.out.println("Data added successfully!!!");

	    // Save or process userResume object as needed
	    System.out.println("User Data: " + userResume);

	    return "normal/resume"; // Redirect to a success page or dashboard
	}	

}
