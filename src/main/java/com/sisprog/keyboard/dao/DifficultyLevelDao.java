package com.sisprog.keyboard.dao;

import com.sisprog.keyboard.domain.DifficultyLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DifficultyLevelDao extends JpaRepository<DifficultyLevel, Long> {
}
