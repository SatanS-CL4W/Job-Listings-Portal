//package com.jobListings.SecurityConfigurations;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//import com.jobListings.Entity.User;
//import com.jobListings.Repositories.UserRepository;
//
//@Configuration
//@EnableWebSecurity
//public class MyConfig {
//
//    private final UserRepository userRepository;
//
//    public MyConfig(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        return email -> {
//            User user = userRepository.findByEmail(email);
//            if (user != null) {
//                return org.springframework.security.core.userdetails.User
//                        .withUsername(user.getEmail())
//                        .password(user.getPassword())
//                        .roles(user.getRole())
//                        .build();
//            } else {
//                throw new UsernameNotFoundException("User not found with email: " + email);
//            }
//        };
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    
//    @Bean // Ensure BCryptPasswordEncoder is exposed as a bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//            .csrf(csrf -> csrf.disable())
//            .authorizeHttpRequests(authorize -> authorize
//                .requestMatchers("/admin/**").hasRole("ADMIN")
//                .requestMatchers("/user/**").hasRole("USER")
//                .requestMatchers("/**").permitAll()
//                .anyRequest().authenticated()
//            )
//            .formLogin(form -> form
//                .loginPage("/login") // Customize the login page URL
//                .loginProcessingUrl("/doLogin") // Process login form at this URL
//                .defaultSuccessUrl("/user/index") // Redirect after successful login
//                .failureUrl("/user/index") // Redirect after login failure
//                .permitAll()         // Allow everyone to see the login page
//            )
//            .logout(logout -> logout
//                    .logoutUrl("/logout")
//                    .logoutSuccessUrl("/login?logout=true")
//                    .permitAll());
//
//        return http.build();
//    }
//
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//            .userDetailsService(userDetailsService())
//            .passwordEncoder(passwordEncoder());
//    }
//}
