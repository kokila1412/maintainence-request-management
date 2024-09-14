//package com.springbootdockermavenjibplugin.configurations;
//
//import com.authentication.service.UserService;
//import lombok.AllArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.web.bind.annotation.CrossOrigin;
//
//import static org.springframework.http.HttpMethod.*;
//
//@Configuration
//@EnableWebSecurity
//
//public class SecurityConfig {
//    private final UserService userDetailsService;
//
//    public SecurityConfig(UserService userDetailsService) {
//        this.userDetailsService = userDetailsService;
//        //this.jwtAuthFilter = jwtAuthFilter;
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
//        httpSecurity.csrf().disable()
////                .authorizeHttpRequests()
////                .anyRequest()
////                .authenticated()
////                .and()
//                .httpBasic();
//
//        return httpSecurity.build();
//    }
//
//
//
////    @Bean
////    public SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authenticationManager) throws Exception {
////        return http
////                .cors(AbstractHttpConfigurer::disable)
////                .csrf(AbstractHttpConfigurer::disable)
////              .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//////        Set permissions on endpoints
////                .authorizeHttpRequests(auth -> auth
//////            our public endpoints
//////                        .antMatchers("api/auth/signup/**").permitAll()
//////                        .antMatchers("/api/auth/login/**").permitAll()
////
//////            our private endpoints
////                        .anyRequest().authenticated()).build();
////
////
//////        We need jwt filter before the UsernamePasswordAuthenticationFilter.
//////        Since we need every request to be authenticated before going through spring security filter.
//////        (UsernamePasswordAuthenticationFilter creates a UsernamePasswordAuthenticationToken from a username and password that are submitted in the HttpServletRequest.)
////                //.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
////
////    }
//
////    @Bean
////    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
////        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
////        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
////        return authenticationManagerBuilder.build();
////    }
//}
//
//// CORS(Cross-origin resource sharing) is just to avoid if you run javascript across different domains like if you execute JS on http://testpage.com and access http://anotherpage.com
//// CSRF(Cross-Site Request Forgery)