package com.sisprog.keyboard.dto;

import com.sisprog.keyboard.domain.Exercise;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseDto {
    private Long id;
    private String words;
    private Long levelId;
    private String name;

    public static ExerciseDto of(Exercise exercise) {
        ExerciseDto exerciseDto = new ExerciseDto();
        exerciseDto.setId(exercise.getId());
        exerciseDto.setWords(exercise.getWords());
        exerciseDto.setLevelId(exercise.getLevelId());
        exerciseDto.setName(exercise.getName());
        return exerciseDto;
    }

    public static Exercise of(ExerciseDto exerciseDto) {
        Exercise exercise = new Exercise();
        exercise.setId(exerciseDto.getId());
        exercise.setWords(exerciseDto.getWords().replaceAll("\\p{Cntrl}", ""));
        exercise.setLevelId(exerciseDto.getLevelId());
        exercise.setName(exerciseDto.getName());
        return exercise;
    }
}
