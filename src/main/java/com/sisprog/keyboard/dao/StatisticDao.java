package com.sisprog.keyboard.dao;

import com.sisprog.keyboard.domain.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatisticDao extends JpaRepository<Statistic, Long> {

    List<Statistic> getStatisticsByUserId(Long userId);

    List<Statistic> getStatisticsByExerciseId(Long exerciseId);
}
