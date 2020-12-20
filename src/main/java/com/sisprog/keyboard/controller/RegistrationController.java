package com.sisprog.keyboard.controller;


import com.sisprog.keyboard.dao.UserDao;
import com.sisprog.keyboard.domain.User;
import com.sisprog.keyboard.dto.RegistrationRequestDto;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("api/registration")
public class RegistrationController {

    private final UserDao userRepository;
    private final PasswordEncoder passwordEncoder;

    public RegistrationController(UserDao userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping
    public void reg(@RequestBody RegistrationRequestDto requestDto) {
        if (requestDto != null) {
            try {
                User user = userRepository.findByUsername(requestDto.getUsername());


                if (user != null) {
                    throw new UsernameNotFoundException("User with username: " + requestDto.getUsername() + " exists!");
                }

                User newuser = new User();
                newuser.setUsername(requestDto.getUsername());
                newuser.setPassword(passwordEncoder.encode(requestDto.getPassword()));
                newuser.setRoles(requestDto.getRoles());
                newuser.setPermissions("");
                newuser.setActive(1);
                newuser.setLevelId(requestDto.getLevelId());

                userRepository.save(newuser);
            } catch (DataAccessException e) {
                e.printStackTrace();
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            } catch (UsernameNotFoundException e) {
                e.printStackTrace();
                throw new ResponseStatusException(HttpStatus.CONFLICT);
            } catch (Exception | Error e) {
                e.printStackTrace();
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
}
