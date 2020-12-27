package com.sisprog.keyboard.controller;

import com.sisprog.keyboard.dto.UpdateUserDto;
import com.sisprog.keyboard.dto.UserDto;
import com.sisprog.keyboard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/getAllUsersByPage", produces = APPLICATION_JSON_VALUE)
    public Page<UserDto> getAllUsersByPage(Pageable pageable) {
        return userService.getAllByPage(pageable);
    }

    @PostMapping(value = "/changeUserLevel", produces = APPLICATION_JSON_VALUE)
    public UserDto changeUserLevel(@RequestBody UserDto userDto) {
        return userService.changeUserLevel(userDto);
    }

    @PostMapping(value = "/updateUser", produces = APPLICATION_JSON_VALUE)
    public void updateUser(@RequestBody UpdateUserDto userDto) {
        userService.updateUser(userDto);
    }
}
