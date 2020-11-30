package com.sisprog.keyboard.dao;

import com.sisprog.keyboard.domain.DifficultyLevel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DifficultyLevelDao extends JpaRepository<DifficultyLevel, Long> {
}
