package com.consulting.auth_service.service;

import com.consulting.auth_service.client.dto.ValidateUserRequest;
import com.consulting.auth_service.vo.AuthValidationResponse;

public interface AuthService {

    AuthValidationResponse generateToken(ValidateUserRequest validateUserRequest);
}
