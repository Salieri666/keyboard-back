package com.sisprog.keyboard.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationRequestDto {
    private String username;
    private String password;
    private String roles;
    private String permissions;
    private Long levelId;
}
