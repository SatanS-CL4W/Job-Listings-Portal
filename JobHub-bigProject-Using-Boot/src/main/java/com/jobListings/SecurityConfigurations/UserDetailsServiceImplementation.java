//package com.jobListings.SecurityConfigurations;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import com.jobListings.Entity.User;
//import com.jobListings.Repositories.UserRepository;
//
//@Service
//public class UserDetailsServiceImplementation implements UserDetailsService {
//
//    private final UserRepository userRepository;
//    
//    private final BCryptPasswordEncoder bCryptPasswordEncoder;
//    
//    @Autowired
//    public UserDetailsServiceImplementation(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
//        this.userRepository = userRepository;
//        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        System.out.println("Attempting to load user by username: " + email); // Debug statement
//        User user = userRepository.findByEmail(email);
//        
//        if (user == null) {
//            System.out.println("User not found with email: " + email); // Debug statement
//            throw new UsernameNotFoundException("Could not found user with email: " + email);
//        }
//        
//        System.out.println("User found: " + user.getEmail()); // Debug statement
//        
//        return new org.springframework.security.core.userdetails.User(
//                user.getEmail(), 
//                user.getPassword(), 
//                List.of(new SimpleGrantedAuthority(user.getRole()))
//        );
//    }
//}
