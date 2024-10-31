package com.consulting.auth_service.controller;

import com.consulting.auth_service.client.dto.ValidateUserRequest;
import com.consulting.auth_service.service.AuthService;
import com.consulting.auth_service.vo.AuthValidationResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final AuthService authService;

    @PostMapping("/token")
    ResponseEntity<AuthValidationResponse> generateToken(@RequestBody ValidateUserRequest validateUserRequest){
        log.info("Received request to generate token: {}", validateUserRequest);
        return ResponseEntity.ok(authService.generateToken(validateUserRequest));
    }
}
