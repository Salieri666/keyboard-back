package com.sisprog.keyboard.dto;

import com.sisprog.keyboard.domain.Statistic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatisticDto {

    private Long id;
    private Integer maxSpeed;
    private Integer avgSpeed;
    private Integer errors;
    private Date dateExecution;
    private Integer numberOfExecutions;
    private Integer numberOfFailures;
    private Long userId;
    private Long exerciseId;

    public static StatisticDto of(Statistic statistic) {
        StatisticDto dto = new StatisticDto();
        dto.setId(statistic.getId());
        dto.setMaxSpeed(statistic.getMaxSpeed());
        dto.setAvgSpeed(statistic.getAvgSpeed());
        dto.setErrors(statistic.getErrors());
        dto.setDateExecution(statistic.getDateExecution());
        dto.setNumberOfExecutions(statistic.getNumberOfExecutions());
        dto.setNumberOfFailures(statistic.getNumberOfFailures());
        dto.setUserId(statistic.getUserId());
        dto.setExerciseId(statistic.getExerciseId());
        return dto;
    }

    public static  Statistic of(StatisticDto statisticDto) {
        Statistic statistic = new Statistic();
        statistic.setId(statisticDto.getId());
        statistic.setMaxSpeed(statisticDto.getMaxSpeed());
        statistic.setAvgSpeed(statisticDto.getAvgSpeed());
        statistic.setErrors(statisticDto.getErrors());
        statistic.setDateExecution(statisticDto.getDateExecution());
        statistic.setNumberOfExecutions(statisticDto.getNumberOfExecutions());
        statistic.setNumberOfFailures(statisticDto.getNumberOfFailures());
        statistic.setUserId(statisticDto.getUserId());
        statistic.setExerciseId(statisticDto.getExerciseId());
        return statistic;
    }
}
