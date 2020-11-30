package com.sisprog.keyboard.dao;

import com.sisprog.keyboard.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
}
