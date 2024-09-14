package com.authentication.controller;


import com.authentication.controller.dto.SignUpRequest;
import com.authentication.service.UserService;
import com.authentication.domain.LoginAttempt;
import com.authentication.service.LoginService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/auth", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin("http://localhost:3000")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final LoginService loginService;

    public AuthController(AuthenticationManager authenticationManager, UserService userService, LoginService loginService) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.loginService = loginService;
    }

    @PostMapping("/signup")
    public ResponseEntity<Void> signup(@RequestBody SignUpRequest requestDto) {
        userService.signup(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping(value = "/login")
    public ResponseEntity login(@RequestBody SignUpRequest request) {
        try {
          //  authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getName(), request.getPassword()));
        } catch (BadCredentialsException e) {
            throw e;
        }
        return ResponseEntity.ok("Login successful");
    }



}
