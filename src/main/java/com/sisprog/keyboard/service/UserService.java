package com.sisprog.keyboard.service;

import com.sisprog.keyboard.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto getById(Long id);

    List<UserDto> getAll();
}
