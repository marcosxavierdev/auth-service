package com.consulting.auth_service.client.dto;

import lombok.*;

@Value
public class ValidateUserRequest {

    String username;
    String password;
}
