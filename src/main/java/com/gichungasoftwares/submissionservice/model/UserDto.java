package com.gichungasoftwares.submissionservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
    private Long id;
    private String password;
    private String email;
    private String fullName;
    private String mobile;
    private String role;
}
