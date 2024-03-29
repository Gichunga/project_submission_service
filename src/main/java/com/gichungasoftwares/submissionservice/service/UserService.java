package com.gichungasoftwares.submissionservice.service;

import com.gichungasoftwares.submissionservice.model.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "USESR-SERVICE", url = "http://localhost:5001")
public interface UserService {

    // get user profile from user service by jwt
    @GetMapping("api/users/profile")
    UserDto findUserByJwt(@RequestHeader("Authorization") String jwt) throws Exception ;

}
