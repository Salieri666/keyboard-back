package com.sisprog.keyboard.dao;

import com.sisprog.keyboard.domain.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseDao extends JpaRepository<Exercise, Long> {
}
