package com.sisprog.keyboard.controller;

import com.sisprog.keyboard.dto.UserDto;
import com.sisprog.keyboard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/getUser/{id}", produces = APPLICATION_JSON_VALUE)
    public UserDto getUser(@PathVariable("id") Long id) {
        return userService.getById(id);
    }

    @GetMapping(value = "/getAllUsers", produces = APPLICATION_JSON_VALUE)
    public List<UserDto> getAllUsers() {
        return userService.getAll();
    }
}
