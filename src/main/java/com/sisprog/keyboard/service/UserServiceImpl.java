package com.sisprog.keyboard.service;

import com.sisprog.keyboard.dao.UserDao;
import com.sisprog.keyboard.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Override
    public UserDto getById(Long id) {
        return UserDto.of(userDao.getOne(id));
    }

    @Override
    public List<UserDto> getAll() {
        return userDao.findUsersByRole("USER").stream().map(UserDto::of).collect(Collectors.toList());
    }

    @Override
    public Page<UserDto> getAllByPage(Pageable pageable) {
        return userDao.findUsersByRole("USER", pageable).map(UserDto::of);
    }
}
