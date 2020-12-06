package com.sisprog.keyboard.service;

import com.sisprog.keyboard.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    UserDto getById(Long id);

    List<UserDto> getAll();

    Page<UserDto> getAllByPage(Pageable pageable);
}
