package com.consulting.auth_service.service;

import com.consulting.auth_service.client.UserFeignClient;
import com.consulting.auth_service.client.dto.ValidateUserRequest;
import com.consulting.auth_service.utils.JwtUtils;
import com.consulting.auth_service.vo.AuthValidationResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final UserFeignClient userFeignClient;
    private final JwtUtils jwtUtils;

    @Override
    public AuthValidationResponse generateToken(ValidateUserRequest validateUserRequest) {
        log.info("Starting validating user {} credentials", validateUserRequest.getUsername());
        var userValidationResponse = userFeignClient.validateUser(validateUserRequest);
        if(userValidationResponse.getValid()){
            log.info("Successfully validated user {}", validateUserRequest.getUsername());
            return new AuthValidationResponse(jwtUtils.generateToken(validateUserRequest.getUsername()));
        }
        //Como retornar amigavel ao cliente isso
        log.error("Failed to validate user {}", validateUserRequest.getUsername());
        throw new RuntimeException("Token generation failed");
    }
}
