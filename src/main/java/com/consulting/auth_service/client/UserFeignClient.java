package com.consulting.auth_service.client;

import com.consulting.auth_service.client.dto.UserValidationResponse;
import com.consulting.auth_service.client.dto.ValidateUserRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient(name = "user-management-service", url = "http://localhost:8080")
public interface UserFeignClient {

    @PostMapping("/users/validate")
    UserValidationResponse validateUser(@RequestBody ValidateUserRequest validateUserRequest);
}
