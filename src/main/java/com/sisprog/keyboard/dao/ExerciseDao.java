package com.sisprog.keyboard.dao;

import com.sisprog.keyboard.domain.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseDao extends JpaRepository<Exercise, Long> {

    @Query(value = "select e.* from exercise e " +
            "where e.id in (select distinct s.exercise_id from statistic s " +
            "where s.user_id = :userId)", nativeQuery = true)
    List<Exercise> getExecutedExercisesByUser(Long userId);

    @Query(value = "select count(e) from exercise e " +
            "where e.level_id = :levelId ", nativeQuery = true)
    long getCountExercisesByLevelId(Long levelId);
}
