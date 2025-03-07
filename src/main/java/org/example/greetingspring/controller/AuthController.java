package org.example.greetingspring.controller;

import jakarta.validation.Valid;
import org.example.greetingspring.dto.AuthUserDTO;
import org.example.greetingspring.service.AuthenticationService;
import org.example.greetingspring.dto.LoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@Tag(name = "Authentication API", description = "Endpoints for user authentication")
public class AuthController {

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/register")
    @Operation(summary = "Register a new user", description = "Registers a user and sends a welcome email")

    public String registerUser(@Valid @RequestBody AuthUserDTO authUserDTO) {
        return authenticationService.registerUser(authUserDTO);
    }

    @PostMapping("/login")
    public Map<String, String> loginUser(@Valid @RequestBody LoginDTO loginDTO) {
        return authenticationService.loginUser(loginDTO);
    }
}
